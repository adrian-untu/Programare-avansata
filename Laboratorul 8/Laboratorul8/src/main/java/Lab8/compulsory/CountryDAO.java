package Lab8.compulsory;

import java.sql.*;

public class CountryDAO {
    public void create(int id, String name, String code, int idContinent) {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into countries values (?, ?, ?, ?)")) {
            pstmt.setString(1, String.valueOf(id));
            pstmt.setString(2, name);
            pstmt.setString(3, code);
            pstmt.setString(4, String.valueOf(idContinent));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Countries: id " + id + " already exists");
        }
    }

    public Integer findByName(String name) {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(
                    "select id from countries where name='" + name + "'");
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
                    "select name from countries where id='" + id + "'");
            return rs.next() ? rs.getString(1) : null;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
