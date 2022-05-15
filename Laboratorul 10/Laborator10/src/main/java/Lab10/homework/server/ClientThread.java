package Lab10.homework.server;

import Lab10.homework.commands.*;
import Lab10.homework.utils.Database;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ClientThread extends Thread
{
    private static Integer TIMEOUT_TIME = 3600_000;
    private Socket socket;
    private Database dbc;

    public ClientThread(Socket socket, Database dbc)
    {
        this.socket = socket;
        this.dbc = dbc;
    }

    public void run()
    {
        try
        {
            socket.setSoTimeout(TIMEOUT_TIME);
            while (true)
            {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();

                if (request == null)
                    break;

                PrintWriter out = new PrintWriter(socket.getOutputStream());
                if (request.equals("stop"))
                {
                    out.println("Server stopped");
                    out.flush();
                    System.exit(0);
                } else
                {
                    String response = interpretCommand(request);
                    out.println(response);
                    out.flush();
                }
            }
        }
        catch (SocketTimeoutException e)
        {
            System.out.printf("%d seconds passed since last request. Timed out.\n", TIMEOUT_TIME / 1000);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                socket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private String interpretCommand(String string) {
        String[] command = string.trim().toLowerCase().split(" ");
        Command com;
        String result;
        switch (command[0])
        {
            case "register":
                com = new Register(command[1], command[2], this.dbc.getConnection());
                result = com.run();
                if(result.equals("succ")) {
                    System.out.println("Registered " + command[1]);
                    return "Registered successfully";
                }
                else {
                    System.err.println("Could not register " + command[1]);
                    return "Could not register";
                }
            case "login":
                com = new Login(command[1], command[2], this.dbc.getConnection());
                result = com.run();
                if(result.equals("succ")) {
                    System.out.println("Logged in " + command[1]);
                    return "Logged in as " + command[1];
                }
                else {
                    System.err.println("Could not log in " + command[1]);
                    return "Could not log in";
                }
            case "friend":
                String clientName = command[2];
                String[] friends = command[1].split(",");
                StringBuilder res = new StringBuilder();
                for(String s : friends)
                {
                    com = new Friends(clientName, s, this.dbc.getConnection());
                    result = com.run();
                    if(result.equals("already"))
                    {
                        res.append(clientName).append(" is already friends with ").append(s).append("\n");
                    }
                    else if(result.equals("succ"))
                    {
                        res.append(clientName).append(" is now friends with ").append(s).append("\n");
                    }
                    else
                    {
                        res.append(clientName).append(" could not befriend ").append(s).append("\n");
                    }
                }
                return res.toString().replace("\n", "/socketNewLine/");
            case "send":
                StringBuilder text = new StringBuilder();
                for(int i = 2; i < command.length - 1; ++i)
                {
                    text.append(command[i]).append(" ");
                }
                Date date = new Date();
                String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
                com = new Send(command[command.length - 1], command[1], text.toString().trim(), timeStamp, this.dbc.getConnection());
                result = com.run();
                if(result.equals("succ"))
                {
                    return "Message sent";
                }
                else
                {
                    return "Message not sent";
                }
            case "read":
                com = new Read(command[1], this.dbc.getConnection());
                result = com.run();
                if(result.equals("exception"))
                {
                    return "Could not read messages";
                }
                else
                {
                    return result.replace("\n", "/socketNewLine/");
                }
            default:
                System.err.println("Command not recognized");
                return "Command not recognized";
        }
    }
}