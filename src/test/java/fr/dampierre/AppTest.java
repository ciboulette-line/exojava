package fr.dampierre;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;

class AppTest {

    @Test
    // Pour les tests, on créé une fonction sous la forme
    // etatActuel_fontionTestee_ResultatQuiDoitEtreRetourne

    // Ici on effectue le test sur la fonction retourneUtilisateurs lorsqu'un qu'il
    // y a un seul client Allan
    void conditionEstAllan_retourneUtilisateurs_DevraitRetourner1() {

        // Act
        // On instancie l'objet app
        App app = new App();

        // Arrange
        // On créé la liste clients à partir de l'objet Client et on lui demande de
        // retourner l'utilisateur Allan
        List<Client> clients = app.retourneUtilisateurs("Allan");

        // On instancie un int qui va renvoyer la taille de la liste clients
        int actualInt = clients.size();

        // On s'attend à ce que la liste ne soit pas nulle
        assertNotNull(clients);

        // Le résultat attendu est 1, renvoie la taille de la liste, si le nombre actuel
        // est différent de celui attendu
        // on affiche le message "Il devrait y avoir 1 client"
        assertEquals(1, actualInt, "Il devrait y avoir 1 client");
    }

    @Test
    void conditionEstUser1_retourneUtilisateurs_DevraitRetourner2() {

        App app = new App();

        List<Client> clients = app.retourneUtilisateurs("user1");

        int actualInt = clients.size();

        assertNotNull(clients);
        assertEquals(2, actualInt, "Il devrait y avoir 2 clients");
    }

    @Test
    void conditionEstInjection_retourneUtilisateurs_DevraitRetournerPlusieursClients() {

        App app = new App();

        List<Client> clients = app.retourneUtilisateurs("Geoffrey' OR '1' = '1");

        int actualInt = clients.size();

        assertNotNull(clients);
        assertEquals(5, actualInt, "Il devrait y avoir 5 clients");

    }
}
