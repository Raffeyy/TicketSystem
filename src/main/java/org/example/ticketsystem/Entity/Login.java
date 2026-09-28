package org.example.ticketsystem.Entity;

import jakarta.persistence.*;

@Entity

public class Login {

    @Id
    private String email;
    private String password;

    public Login()
    {
    }

    public Login(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
