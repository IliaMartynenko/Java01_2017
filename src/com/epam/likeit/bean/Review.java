package com.epam.likeit.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by mts7072572 on 27.05.2017.
 */
public class Review implements Serializable {
    private int idReviews;
    private int idUser;
    private Date date;
    private String textOfReview;
    private double rating;

    public Review() {
    }

    public int getIdReviews() {
        return idReviews;
    }

    public void setIdReviews(int idReviews) {
        this.idReviews = idReviews;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTextOfReview() {
        return textOfReview;
    }

    public void setTextOfReview(String textOfReview) {
        this.textOfReview = textOfReview;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


}


