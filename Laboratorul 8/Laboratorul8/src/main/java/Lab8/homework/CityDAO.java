package Lab8.homework;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class CityDAO {
    public void create(int id, String country_code, String name, int capital, String latitude, String longitude) {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into cities values (?, ?, ?, ?, ?, ?)")) {
            pstmt.setString(1, String.valueOf(id));
            pstmt.setString(2, country_code);
            pstmt.setString(3, name);
            pstmt.setInt(4, capital);
            pstmt.setString(5, latitude);
            pstmt.setString(6, longitude);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Cities: " + id + " already exists");
        }
    }

    public Integer findByName(String name) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(
                    "select id from cities where name='" + name + "'");
            return rs.next() ? rs.getInt(1) : null;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public String findById(int id) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(
                    "select name from cities where id='" + id + "'");
            return rs.next() ? rs.getString(1) : null;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void insertCSV(String path) {
        try {
            BufferedReader lineReader = new BufferedReader(new FileReader(path));
            String lineText = null;

            int count = 0;

            lineReader.readLine(); // skip header line

            int id = 0, id_continent = 0, id_country = 0;
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                int id1 = id;
                String country_name = data[0];
                String name = data[1];
                String latitude = data[2];
                String longitude = data[3];
                id++;
                create(id1, country_name, name, 1, latitude, longitude);
            }

            lineReader.close();

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}

