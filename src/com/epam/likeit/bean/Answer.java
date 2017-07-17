package com.epam.likeit.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by mts7072572 on 27.05.2017.
 */
public class Answer implements Serializable {
    private int idAnswer;
    private int idQuestion;
    private int idUser;
    private String answerText;
    private Date dateOfAnswer;
    private int sumOfRatings;

    public Answer() {
    }

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Date getDateOfAnswer() {
        return dateOfAnswer;
    }

    public void setDateOfAnswer(Date dateOfAnswer) {
        this.dateOfAnswer = dateOfAnswer;
    }

    public int getSumOfRatings() {
        return sumOfRatings;
    }

    public void setSumOfRatings(int sumOfRatings) {
        this.sumOfRatings = sumOfRatings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (idAnswer != answer.idAnswer) return false;
        if (idQuestion != answer.idQuestion) return false;
        if (idUser != answer.idUser) return false;
        if (sumOfRatings != answer.sumOfRatings) return false;
        if (answerText != null ? !answerText.equals(answer.answerText) : answer.answerText != null) return false;
        return dateOfAnswer != null ? dateOfAnswer.equals(answer.dateOfAnswer) : answer.dateOfAnswer == null;
    }

    @Override
    public int hashCode() {
        int result = idAnswer;
        result = 31 * result + idQuestion;
        result = 31 * result + idUser;
        result = 31 * result + (answerText != null ? answerText.hashCode() : 0);
        result = 31 * result + (dateOfAnswer != null ? dateOfAnswer.hashCode() : 0);
        result = 31 * result + sumOfRatings;
        return result;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "idAnswer=" + idAnswer +
                ", idQuestion=" + idQuestion +
                ", idUser=" + idUser +
                ", answerText='" + answerText + '\'' +
                ", dateOfAnswer=" + dateOfAnswer +
                ", sumOfRatings=" + sumOfRatings +
                '}';
    }
}

