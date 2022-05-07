package Lab8.compulsory;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Database.getConnection();
        Database.runScript();

        try {
            var continents = new ContinentDAO();
            continents.create(1, "Europe");
            continents.create(2, "Asia");
            continents.create(3, "Africa");
            Database.getConnection().commit();
            System.out.println(continents.findById(1));
            System.out.println(continents.findByName("Asia"));

            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            int asiaId = continents.findByName("Asia");
            int africaId = continents.findByName("Africa");
            countries.create(1, "Romania", "RO", europeId);
            countries.create(2, "Ukraine", "UA", europeId);
            countries.create(3, "Russia", "RU", asiaId);
            countries.create(4, "Japan", "JP", asiaId);
            countries.create(5, "Egypt", "EG", africaId);
            countries.create(6, "Ghana", "GH", africaId);
            Database.getConnection().commit();
            System.out.println(countries.findByName("Romania"));
            System.out.println(countries.findById(2));
            System.out.println(countries.findByName("Russia"));
            System.out.println(countries.findById(4));
            System.out.println(countries.findById(5));
            System.out.println(countries.findByName("Ghana"));

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            try {
                Database.getConnection().rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}