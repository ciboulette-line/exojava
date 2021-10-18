package fr.dampierre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        testBdd();
    }

    private static void testBdd() {

        // Connexion à la base de données en précisant son URL ainsi ainsi que les
        // identifiants de l'utilisateur SQL
        String dbURL = "jdbc:mysql://localhost:3306/exo_random_java?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "6GPTqaJXn3g7Y3jg459y";

        try {
            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from users");

            while (resultSet.next()) {
                System.out.println("nom: " + resultSet.getString("nom_user"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> retourneUtilisateurs(String condition) {

        String dbURL = "jdbc:mysql://localhost:3306/exo_random_java?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "6GPTqaJXn3g7Y3jg459y";
        List<Client> clients = new ArrayList();
        String sql = String.format("select nom_user , id_user , password_user from users where nom_user = '%s'",
                condition);

        try {
            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                clients.add(construireClientDepuis(resultSet));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;

    }

    private Client construireClientDepuis(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id_user");
        String nom = resultSet.getString("nom_user");
        String mdp = resultSet.getString("password_user");

        return new Client(id, nom, mdp);

    }

}
