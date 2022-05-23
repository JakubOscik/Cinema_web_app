package com.movietime.MovieTime.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "usersId")
public @Getter @Setter
class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId")
    private int       userId;

    @Column(name="email", nullable = false)
    private String    email;

    @Column(name="password", nullable = false)
    private String    password;

    @Column(name="phone", nullable = false)
    private String    phone;

    public Users(String email, String password, String phone) {
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
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

    public String getPhone() {return phone;}

    public void setPhoneNumber(String phoneNumber) {this.phone = phone;}
}