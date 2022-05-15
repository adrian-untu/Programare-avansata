package Lab10.homework.server;

import java.io.IOException;
import java.sql.SQLException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Server server = new Server();
        }
        catch (IOException | SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
}