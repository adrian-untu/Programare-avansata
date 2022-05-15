package Lab10.homework.commands;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Register implements Command {

    private String name;
    private String password;
    private Connection conn;

    public Register(String name, String password, Connection conn) {
        this.name = name;
        this.password = password;
        this.conn = conn;
    }

    @Override
    public String run() {
        try {
            Statement statement = conn.createStatement();
            ResultSet set = statement.executeQuery(
                    "INSERT INTO USERS VALUES(" + "'" + name + "','" + password + "')"
            );
            set.close();
            statement.close();
            return "succ";
        }
        catch (SQLException e) {
            return "exception";
        }
    }
}