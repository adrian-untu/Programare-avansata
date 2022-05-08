package Lab8.homework;


import java.sql.*;

public class ContinentDAO {
    public void create(int id, String name) {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into continents values (?, ?)")) {
            pstmt.setString(1, String.valueOf(id));
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Continents: id " + id + " already exists");
        }
    }

    public Integer findByName(String name) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(
                    "select id from continents where name='" + name + "'");
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
                    "select name from continents where id='" + id + "'");
            return rs.next() ? rs.getString(1) : null;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}