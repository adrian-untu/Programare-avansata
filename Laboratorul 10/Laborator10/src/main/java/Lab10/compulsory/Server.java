package Lab10.compulsory;// A Java program for a Server
import java.net.*;
import java.io.*;

public class Server
{


    public static void main(String[] args) throws IOException
    {
        ServerSocket myServerSocket = new ServerSocket(8100);
        // getting client request
        while (true)
        // running infinite loop
        {
            Socket socket = null;
            socket = myServerSocket.accept();

            System.out.println("A new connection identified : " + socket);
            // obtaining input and out streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            System.out.println("Thread assigned");

            Thread myThread = new ClientThread(myServerSocket, socket, in, out);
            // starting
            myThread.start();
        }
    }
}
