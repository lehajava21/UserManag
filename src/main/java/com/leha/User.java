package com.leha;

import annotations.*;

import java.io.Serializable;

public class User implements Serializable {

    @Valid
    @DisplayName(name = "USER NAME")
    @NotBlank
    private String username;

    @Valid
    @DisplayName(name = "PASSWORD")
    @NotBlank
    @Length(min = 6, max = 16)
    private String password;

    @Valid
    @DisplayName(name = "FIRST NAME")
    @NotBlank
    private String firstname;

    @Valid
    @DisplayName(name = "LAST NAME")
    @NotBlank
    private String lastname;

    @Valid
    @DisplayName(name = "EMAIL")
    @NotBlank
    @Email
    private String email;

    @Valid
    @DisplayName(name = "AGE")
    @NumberLength(min = 1, max = 100)
    private Integer age;

    private Integer id;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() { return lastname; }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    protected int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(String age) {
        try {
            this.age = Integer.parseInt(age);
        }catch (Exception e){
            this.age = Integer.parseInt("0");
        }
    }

    protected void setId(int id) {
        this.id = id;
    }
}
