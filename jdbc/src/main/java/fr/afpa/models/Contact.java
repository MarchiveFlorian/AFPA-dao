package fr.afpa.models;

import java.time.LocalDate;

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
}
