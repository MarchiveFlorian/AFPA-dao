package fr.afpa.models;

import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Contact {

    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthdate;
    private String pseudo;
    private String address;
    private String personalPhoneNumber;
    private String professionnalPhoneNumber;
    private String email;
    private String linkedInLink;
    private String gitLink;

    public Contact(String firstName, String lastName, String gender, LocalDate birthdate, String pseudo, String address,
            String personalPhoneNumber, String professionnalPhoneNumber, String email, String linkedInLink,
            String gitLink) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdate = birthdate;
        this.pseudo = pseudo;
        this.address = address;
        this.personalPhoneNumber = personalPhoneNumber;
        this.professionnalPhoneNumber = professionnalPhoneNumber;
        this.email = email;
        this.linkedInLink = linkedInLink;
        this.gitLink = gitLink;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonalPhoneNumber() {
        return personalPhoneNumber;
    }

    public void setPersonalPhoneNumber(String personalPhoneNumber) {
        this.personalPhoneNumber = personalPhoneNumber;
    }

    public String getProfessionnalPhoneNumber() {
        return professionnalPhoneNumber;
    }

    public void setProfessionnalPhoneNumber(String professionnalPhoneNumber) {
        this.professionnalPhoneNumber = professionnalPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedInLink() {
        return linkedInLink;
    }

    public void setLinkedInLink(String linkedInLink) {
        this.linkedInLink = linkedInLink;
    }

    public String getGitLink() {
        return gitLink;
    }

    public void setGitLink(String gitLink) {
        this.gitLink = gitLink;
    }

    @Override
    public String toString() {
        return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", birthdate="
                + birthdate + ", pseudo=" + pseudo + ", address=" + address + ", personalPhoneNumber="
                + personalPhoneNumber + ", professionnalPhoneNumber=" + professionnalPhoneNumber + ", email=" + email
                + ", linkedInLink=" + linkedInLink + ", gitLink=" + gitLink + "]";
    }

    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        String url = "jdbc:postgresql://localhost:5432/jdbc";
        String user = "postgres";
        String password = "B@nLgU4qz*9?D~3n83";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM contacts");

            while (result.next()) {
                Contact contact = new Contact(
                        result.getString("firstName"),
                        result.getString("lastName"),
                        result.getString("gender"),
                        result.getDate("birthdate").toLocalDate(),
                        result.getString("pseudo"),
                        result.getString("address"),
                        result.getString("personalPhoneNumber"),
                        result.getString("professionnalPhoneNumber"),
                        result.getString("email"),
                        result.getString("linkedInLink"),
                        result.getString("gitLink"));
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

    public Contact getContactById(int id) {
        Contact contact = null;
        String url = "jdbc:postgresql://localhost:5432/jdbc";
        String user = "postgres";
        String password = "B@nLgU4qz*9?D~3n83";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM contacts WHERE id = " + id;
            ResultSet result = stmt.executeQuery(query);

            if (result.next()) {
                contact = new Contact(
                        result.getString("firstName"),
                        result.getString("lastName"),
                        result.getString("gender"),
                        result.getDate("birthdate").toLocalDate(),
                        result.getString("pseudo"),
                        result.getString("address"),
                        result.getString("personalPhoneNumber"),
                        result.getString("professionnalPhoneNumber"),
                        result.getString("email"),
                        result.getString("linkedInLink"),
                        result.getString("gitLink"));
            }

            result.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return contact;
    }

    public boolean deleteContactById(int id) {
        String url = "jdbc:postgresql://localhost:5432/jdbc";
        String user = "postgres";
        String password = "B@nLgU4qz*9?D~3n83";
        boolean isDeleted = false;

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            String query = "DELETE FROM contacts WHERE id = " + id;
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
        String url = "jdbc:postgresql://localhost:5432/jdbc";
        String user = "postgres";
        String password = "B@nLgU4qz*9?D~3n83";
        boolean isDeleted = false;

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            String query = "DELETE FROM contacts WHERE firstName = '" + firstName + "' AND lastName = '" + lastName
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

    public boolean addContact(Contact contact) {
        String url = "jdbc:postgresql://localhost:5432/jdbc";
        String user = "postgres";
        String password = "B@nLgU4qz*9?D~3n83";
        boolean isInserted = false;

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            String query = String.format(
                    "INSERT INTO contacts (firstName, lastName, gender, birthdate, pseudo, address, personalPhoneNumber, professionnalPhoneNumber, email, linkedInLink, gitLink) "
                            + "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
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

    public boolean updateContactById(int id, Contact updatedContact) {
        String url = "jdbc:postgresql://localhost:5432/jdbc";
        String user = "postgres";
        String password = "B@nLgU4qz*9?D~3n83";
        boolean isUpdated = false;

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            String query = String.format(
                    "UPDATE contacts SET firstName = '%s', lastName = '%s', gender = '%s', birthdate = '%s', pseudo = '%s', address = '%s', "
                            + "personalPhoneNumber = '%s', professionnalPhoneNumber = '%s', email = '%s', linkedInLink = '%s', gitLink = '%s' "
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
