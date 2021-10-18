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

    // Test sur la fonction retourneUtilisateurs lorsqu'il y a 2 clients avec le
    // même nom
    void conditionEstUser1_retourneUtilisateurs_DevraitRetourner2() {

        App app = new App();

        // On demande à la liste de retourner l'utilisateur user1
        List<Client> clients = app.retourneUtilisateurs("user1");

        // On recupère la taille de la liste clients
        int actualInt = clients.size();

        // On s'attend à ce que la liste ne soit pas nulle
        assertNotNull(clients);

        // Le nombre de clients attendu est de 2, on compare et si le résultat est
        // différent du nombre attendu
        // on affiche le message "Il devrait y avoir 2 clients"
        assertEquals(2, actualInt, "Il devrait y avoir 2 clients");
    }

    @Test

    // On teste la fonction retourneUtilisateurs lorsque l'on fait une injection SQL
    void conditionEstInjection_retourneUtilisateurs_DevraitRetournerTousLesClients() {

        App app = new App();

        // On créé la liste clients et on lui demande de retourner l'utilisateur
        // Geoffrey
        // ou une condition qui est toujours vraie avec deux caractères qu'on met entre
        // simple guillemets sauf après le dernier
        List<Client> clients = app.retourneUtilisateurs("Geoffrey' OR '1' = '1");

        // On recupère la taille de la liste clients dans un int
        int actualInt = clients.size();

        // On s'attend à ce que la liste ne soit pas nulle
        assertNotNull(clients);
        // Le nombre attendu est 5 (car nombre total de clients dans ma BDD), on le
        // compare avec le nombre obtenu
        // Si erreur, affiche "Il devrait y avoir 5 clients"
        assertEquals(5, actualInt, "Il devrait y avoir 5 clients");

    }
}
