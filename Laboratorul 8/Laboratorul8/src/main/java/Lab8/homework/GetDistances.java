package Lab8.homework;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;

public class GetDistances {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "STUDENT";
    private static final String PASSWORD = "STUDENT";
    private static Connection connection = null;
    public static double distance(int city1, int city2)
    {
        double lat1 = 0, lon1 = 0, lat2 = 0, lon2 = 0;
        try {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String queryPattern ="select * from cities where id='" + city1 + "'";
            PreparedStatement pstmt =  connection.prepareStatement(queryPattern);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                lat1 = Double.parseDouble(rs.getString("latitude"));
                lon1 = Double.parseDouble(rs.getString("longitude"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String queryPattern ="select * from cities where id='" + city2 + "'";
            PreparedStatement pstmt =  connection.prepareStatement(queryPattern);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                lat2 = Double.parseDouble(rs.getString("latitude"));
                lon2 = Double.parseDouble(rs.getString("longitude"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return(c * r);
    }
}
