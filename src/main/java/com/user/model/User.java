package com.user.model;

public class User {
    private int Id;
    private String Name;
    private String Email;
    private String Passwrd; // Password field
    private int Rollno; // Roll number field

    // Default constructor
    public User() {
        super();
    }

    // Parameterized constructor
    public User(int Id, String Name, String Email, String Passwrd, int Rollno) {
        super();
        this.Id = Id;
        this.Name = Name;
        this.Email = Email;
        this.Passwrd = Passwrd;
        this.Rollno = Rollno;
    }

    // Getters and Setters
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPasswrd() {
        return Passwrd;
    }

    public void setPasswrd(String Passwrd) { // Correct setter name
        this.Passwrd = Passwrd;
    }

    public int getRollno() {
        return Rollno;
    }

    public void setRollno(int Rollno) {
        this.Rollno = Rollno;
    }

    @Override
    public String toString() {
        return "User [id=" + Id + ", name=" + Name + ", email=" + Email + ", passwrd=" + Passwrd + ", rollno="
                + Rollno + "]";
    }
}
