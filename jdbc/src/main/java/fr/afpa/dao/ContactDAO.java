package fr.afpa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.afpa.models.Contact;

public class ContactDAO extends DAO<Contact>{


    public List<Contact> getAll() {
        List<Contact> contacts = new ArrayList<>();

        try {
            Connection con = ConnectionPostgreSQL.getInstance();
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM contact");

            while (result.next()) {
                Contact contact = new Contact(
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("gender"),
                        result.getDate("birth_date").toLocalDate(),
                        result.getString("pseudo"),
                        result.getString("address"),
                        result.getString("personal_phone_number"),
                        result.getString("professionnal_phone_number"),
                        result.getString("email"),
                        result.getString("linkedIn_link"),
                        result.getString("git_link"));
                contacts.add(contact);
            }

            result.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return contacts;
    }

    public Contact getById(int id) {
        Contact contact = null;

        try {
            Connection con = ConnectionPostgreSQL.getInstance();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM contact WHERE id = " + id;
            ResultSet result = stmt.executeQuery(query);

            if (result.next()) {
                contact = new Contact(
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("gender"),
                        result.getDate("birth_date").toLocalDate(),
                        result.getString("pseudo"),
                        result.getString("address"),
                        result.getString("personal_phone_number"),
                        result.getString("professionnal_phone_number"),
                        result.getString("email"),
                        result.getString("linkedIn_link"),
                        result.getString("git_link"));
            }

            result.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return contact;
    }

    public boolean deleteById(int id) {
        boolean isDeleted = false;

        try {
            Connection con = ConnectionPostgreSQL.getInstance();
            Statement stmt = con.createStatement();
            String query = "DELETE FROM contact WHERE id = " + id;
            int rowsAffected = stmt.executeUpdate(query);

            isDeleted = rowsAffected > 0;

            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isDeleted;
    }

    public boolean deleteContactByName(String firstName, String lastName) {
        boolean isDeleted = false;

        try {
            Connection con = ConnectionPostgreSQL.getInstance();
            Statement stmt = con.createStatement();
            String query = "DELETE FROM contact WHERE first_name = '" + firstName + "' AND last_name = '" + lastName
                    + "'";
            int rowsAffected = stmt.executeUpdate(query);

            isDeleted = rowsAffected > 0;

            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isDeleted;
    }

    public boolean insert(Contact contact) {
        boolean isInserted = false;

        try {
            Connection con = ConnectionPostgreSQL.getInstance();
            Statement stmt = con.createStatement();
            String query = String.format(
                    "INSERT INTO contact (first_name, last_name, gender, birth_date, pseudo, address, personal_phone_number, professionnal_phone_number, email, linkedIn_link, git_link) "
                            + "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    contact.getFirstName(), contact.getLastName(), contact.getGender(), contact.getBirthdate(),
                    contact.getPseudo(), contact.getAddress(), contact.getPersonalPhoneNumber(),
                    contact.getProfessionnalPhoneNumber(), contact.getEmail(), contact.getLinkedInLink(),
                    contact.getGitLink());

            int rowsAffected = stmt.executeUpdate(query);
            isInserted = rowsAffected > 0;

            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isInserted;
    }

    public boolean updateById(int id, Contact updatedContact) {
        boolean isUpdated = false;

        try {
            Connection con = ConnectionPostgreSQL.getInstance();
            Statement stmt = con.createStatement();
            String query = String.format(
                    "UPDATE contact SET first_name = '%s', last_name = '%s', gender = '%s', birth_date = '%s', pseudo = '%s', address = '%s', "
                            + "personal_phone_number = '%s', professionnal_phone_number = '%s', email = '%s', linkedIn_link = '%s', git_link = '%s' "
                            + "WHERE id = %d",
                    updatedContact.getFirstName(), updatedContact.getLastName(), updatedContact.getGender(),
                    updatedContact.getBirthdate(), updatedContact.getPseudo(), updatedContact.getAddress(),
                    updatedContact.getPersonalPhoneNumber(), updatedContact.getProfessionnalPhoneNumber(),
                    updatedContact.getEmail(), updatedContact.getLinkedInLink(), updatedContact.getGitLink(), id);

            int rowsAffected = stmt.executeUpdate(query);
            isUpdated = rowsAffected > 0;

            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isUpdated;
    }
}
