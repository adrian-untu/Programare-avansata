package Lab10.homework.commands;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login implements Command{
    private String name;
    private String password;
    private Connection conn;

    public Login(String name, String password, Connection conn) {
        this.name = name;
        this.password = password;
        this.conn = conn;
    }

    @Override
    public String run() {
        try {
            Statement statement = conn.createStatement();
            ResultSet set = statement.executeQuery("SELECT COUNT(*) FROM USERS WHERE username = '" + name + "' AND PASSWORD = '" + password + "'");
            set.next();
            if(set.getInt("COUNT(*)") != 1) {
                set.close();
                return "not_exist";
            }
            set.close();
            return "succ";
        }
        catch (SQLException e) {
            return "exception";
        }
    }
}