package Lab10.compulsory;
import java.util.Scanner;
import java.io.*;
import java.net.*;


public class Client
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            InetAddress address = InetAddress.getByName("127.0.0.1");
            // establishing the connection
            Socket socket = new Socket(address, 8100);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            // In the following loop, the client and client handle exchange data.
            while (true)
            {
                System.out.println(in.readUTF());
                String toSend = scanner.nextLine();
                out.writeUTF(toSend);
                // Exiting from a while loo should be done when a client gives an exit message.
                if(toSend.equals("Exit"))
                {
                    System.out.println("Connection closing... : " + socket);
                    socket.close();
                    System.out.println("Closed");
                    in.close();
                    out.close();
                    scanner.close();
                    break;
                }
                if(toSend.equals("Stop"))
                {
                    System.out.println("Server stopping..");
                    socket.close();
                    in.close();
                    out.close();
                    scanner.close();
                    System.out.println("Server stopped");
                    break;
                }

                // printing date or time as requested by client
                String receivedString = in.readUTF();
                System.out.println(receivedString);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
