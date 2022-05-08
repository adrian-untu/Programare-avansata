package Lab8.homework;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "STUDENT";
    private static final String PASSWORD = "STUDENT";
    private static Connection connection = null;

    private Database() {}

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try{
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void runScript() {
        ScriptRunner sr = new ScriptRunner(getConnection());
        sr.setSendFullScript(true);
        Reader reader = null;
        Reader reader1 = null;
        try {
            reader = new BufferedReader(new FileReader("E:\\Semestrul 2, anul 2\\Programare avansata\\GitHub\\Laboratorul 8\\Laboratorul8\\src\\main\\java\\Lab8\\homework\\createCities.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            reader1 = new BufferedReader(new FileReader("E:\\Semestrul 2, anul 2\\Programare avansata\\GitHub\\Laboratorul 8\\Laboratorul8\\src\\main\\java\\Lab8\\compulsory\\createTables.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sr.runScript(reader1);
        sr.runScript(reader);
    }
}