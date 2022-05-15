package Lab10.homework.utils;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database instance;

    private static final String url ="jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user="STUDENT";
    private static final String password="STUDENT";

    private Connection connection;

    private Database() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    public static Database getDBInstance() throws SQLException {
        if(instance == null)
            instance = new Database();
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }

    public static void runScript() throws SQLException {
        ScriptRunner sr = new ScriptRunner(DriverManager.getConnection(url,user,password));
        sr.setSendFullScript(true);
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("E:\\Semestrul 2, anul 2\\Programare avansata\\GitHub\\Laboratorul 10\\Laborator10\\src\\main\\java\\Lab10\\homework\\utils\\createTables.sql"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sr.runScript(reader);
    }
}