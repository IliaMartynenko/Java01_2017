package com.epam.likeit.bean;

import java.io.Serializable;

/**
 * Created by mts7072572 on 27.05.2017.
 */
public class User implements Serializable {
    private int id;
    private String mail;
    private String login;
    private String password;
    private String name;
    private int age;
    private String country;
    private int numberOfQuestions;
    private int numberOfRatings;

    public User() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int yearOfBirthday) {
        this.age = yearOfBirthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }



    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", numberOfQuestions=" + numberOfQuestions +
                ", numberOfRatings=" + numberOfRatings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (age != user.age) return false;
        if (numberOfQuestions != user.numberOfQuestions) return false;
        if (numberOfRatings != user.numberOfRatings) return false;
        if (mail != null ? !mail.equals(user.mail) : user.mail != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return country != null ? country.equals(user.country) : user.country == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + numberOfQuestions;
        result = 31 * result + numberOfRatings;
        return result;
    }
}
