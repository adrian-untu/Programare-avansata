package Lab9.compulsory;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.sql.*;

public abstract class DataRepository
        <T extends AbstractEntity, ID extends Serializable> {
    private EntityManager em; //create it somehow
    public String findById(ID id) {
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
    public boolean persist(T entity) {
        try {
            beginTransaction();
            em.persist(entity);
            Database.getConnection().commit();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    private void beginTransaction() {
    }
}

