package Lab10.homework.commands;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Read implements Command {
    private String name;
    private Connection conn;

    public Read(String name, Connection conn) {
        this.name = name;
        this.conn = conn;
    }

    @Override
    public String run() {
        try {
            Statement statement = conn.createStatement();
            ResultSet set = statement.executeQuery("SELECT USER1, MESSAGE, TIMESTAMP FROM MESSAGES WHERE USER2 = '" + name + "'");
            StringBuilder messages = new StringBuilder();
            while(set.next()) {
                messages.append(set.getString("USER1")).append(" said:\n").append(set.getString("MESSAGE")).append("\nat\n").append(set.getString("TIMESTAMP")).append("\n\n");
            }
            set.close();
            return messages.toString();
        }
        catch (SQLException e) {
            return "exception";
        }
    }
}