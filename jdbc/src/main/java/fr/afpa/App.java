package fr.afpa;

import java.time.LocalDate;
import java.util.List;

import fr.afpa.dao.ConnectionPostgreSQL;
import fr.afpa.dao.ContactDAO;
import fr.afpa.models.Contact;

public class App 
{
    public static void main( String[] args )
    {   

        ContactDAO dao = new ContactDAO();

        // // Ajout d'un nouveau contact
        // Contact newContact = new Contact(
        //         "Jane",                         // Prénom
        //         "Doe",                          // Nom
        //         "Female",                       // Sexe
        //         LocalDate.of(1990, 7, 15),      // Date de naissance
        //         "jdoe",                         // Pseudo
        //         "456 Second St",                // Adresse
        //         "123-456-7890",                 // Numéro de téléphone personnel
        //         "123-555-7890",                 // Numéro de téléphone professionnel
        //         "jane.doe@example.com",         // Email
        //         "https://linkedin.com/in/jdoe", // LinkedIn
        //         "https://github.com/jdoe"       // GitHub
        // );

        // boolean isAdded = dao.insert(newContact);
        // if (isAdded) {
        //     System.out.println("Le contact a été ajouté avec succès.");
        // } else {
        //     System.out.println("Erreur lors de l'ajout du contact.");
        // }

        // // Récupérer tous les contacts
        // List<Contact> contacts = dao.getAll();
        // System.out.println("Liste des contacts :");
        // for (Contact contact : contacts) {
        //     System.out.println(contact);
        // }

        // // Récupérer un contact par ID
        // Contact retrievedContact = dao.getById(3); // ID à ajuster
        // if (retrievedContact != null) {
        //     System.out.println("Contact récupéré : " + retrievedContact);
        // } else {
        //     System.out.println("Aucun contact trouvé avec cet ID.");
        // }

        // // Mise à jour d'un contact par ID
        // Contact updatedContact = new Contact(
        //         "Jane",                         // Prénom
        //         "Smith",                        // Nom de famille mis à jour
        //         "Female",                       // Sexe
        //         LocalDate.of(1990, 7, 15),      // Date de naissance
        //         "jsmith",                       // Pseudo mis à jour
        //         "789 Third St",                 // Nouvelle adresse
        //         "123-999-7890",                 // Nouveau téléphone personnel
        //         "123-666-7890",                 // Nouveau téléphone pro
        //         "jsmith@example.com",           // Email mis à jour
        //         "https://linkedin.com/in/jsmith",// Nouveau LinkedIn
        //         "https://github.com/jsmith"     // Nouveau GitHub
        // );

        // boolean isUpdated = dao.updateById(3, updatedContact); // ID à ajuster
        // if (isUpdated) {
        //     System.out.println("Le contact a été mis à jour avec succès.");
        // } else {
        //     System.out.println("Erreur lors de la mise à jour du contact.");
        // }

        // // Suppression d'un contact par nom et prénom
        // boolean isDeletedByName = dao.deleteContactByName("Jane", "Smith");
        // if (isDeletedByName) {
        //     System.out.println("Le contact a été supprimé avec succès.");
        // } else {
        //     System.out.println("Erreur lors de la suppression du contact.");
        // }

        // // Suppression d'un contact par ID
        // boolean isDeletedById = dao.deleteById(2); // ID à ajuster
        // if (isDeletedById) {
        //     System.out.println("Le contact a été supprimé avec succès.");
        // } else {
        //     System.out.println("Erreur lors de la suppression du contact.");
        // } 

        ConnectionPostgreSQL.close();
    }
}
