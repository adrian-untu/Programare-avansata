package Lab10.homework.commands;

import java.sql.*;

public class Send implements Command {
    private String sender;
    private String receiver;
    private String message;
    private String timestamp;
    private Connection conn;

    public Send(String sender, String receiver, String message, String timestamp, Connection conn) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.timestamp = timestamp;
        this.conn = conn;
    }

    @Override
    public String run() {
        try {
            Statement statement = conn.createStatement();
            ResultSet set = statement.executeQuery(
                    "INSERT INTO MESSAGES VALUES(" + "'" + sender + "','" + receiver + "','" + message + "','" + timestamp + "')");
            set.close();
            statement.close();
            return "succ";
        }
        catch (SQLException e) {
            return "exception";
        }
    }
}