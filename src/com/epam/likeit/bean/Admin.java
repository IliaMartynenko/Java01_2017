package com.epam.likeit.bean;

import java.io.Serializable;

/**
 * Created by mts7072572 on 27.05.2017.
 */

public class Admin implements Serializable {
    private int id;
    private String mail;
    private String login;
    private String password;
    private String name;
    private int yearOfBirthday;
    private String country;

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirthday() {
        return yearOfBirthday;
    }

    public void setYearOfBirthday(int yearOfBirthday) {
        this.yearOfBirthday = yearOfBirthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        if (id != admin.id) return false;
        if (yearOfBirthday != admin.yearOfBirthday) return false;
        if (mail != null ? !mail.equals(admin.mail) : admin.mail != null) return false;
        if (login != null ? !login.equals(admin.login) : admin.login != null) return false;
        if (password != null ? !password.equals(admin.password) : admin.password != null) return false;
        if (name != null ? !name.equals(admin.name) : admin.name != null) return false;
        return country != null ? country.equals(admin.country) : admin.country == null;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", yearOfBirthday=" + yearOfBirthday +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + yearOfBirthday;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
