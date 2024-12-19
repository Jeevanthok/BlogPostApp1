package com.blogpost.blogpost10.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Table(name ="user_details")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the UUID
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_name",nullable = false,length =100)
    private String name;
    @Column(name = "user_email",nullable = false,length =100)
    private String email;
    @Column(name = "user_password",nullable = false,length =100)
    private String password;
    @Column(name = "user_about",nullable = true,length =100)
    private String about;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
