package Lab10.compulsory;

import java.io.*;
import java.net.*;

class ClientThread extends Thread
{
    final DataInputStream in;
    final DataOutputStream out;
    final Socket socket;
    final ServerSocket mySocket;


    // Constructor
    public ClientThread(ServerSocket mySocket, Socket socket, DataInputStream in, DataOutputStream out)
    {
        this.mySocket = mySocket;
        this.socket = socket;
        this.in = in;
        this.out = out;
    }

    @Override
    public void run()
    {
        String receivedString;
        while (true)
        {
            try {
                out.writeUTF("Enter text:");

                // getting answers from client
                receivedString = in.readUTF();

                if(receivedString.equals("Exit"))
                {
                    System.out.println("Client " + this.socket + " sends exit...");
                    System.out.println("Connection closing...");
                    this.socket.close();
                    System.out.println("Server stopped");
                    this.in.close();
                    this.out.close();
                    break;
                }
                else if(receivedString.equals("Stop"))
                {
                    System.out.println("Server stopping..");
                    socket.close();
                    in.close();
                    out.close();
                    this.socket.close();
                    this.mySocket.close();
                    System.out.println("Server stopped");
                    break;
                }
                else
                    out.writeUTF("Server received command " + receivedString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try
        {
            // closing resources
            this.in.close();
            this.out.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}