package com.epam.likeit.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by mts7072572 on 27.05.2017.
 */
public class Question implements Serializable {
    private int idQuestion;
    private int idUser;
    private int idTopic;
    private String text;
    private Date dateOfCreate;
    private int sumOfanswers;

    private String allowed;

    public Question() {
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

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public int getSumOfanswers() {
        return sumOfanswers;
    }

    public void setSumOfanswers(int sumOfanswers) {
        this.sumOfanswers = sumOfanswers;
    }



    public String getAllowed() {
        return allowed;
    }

    public void setAllowed(String allowed) {
        this.allowed = allowed;
    }

    @Override
    public String toString() {
        return "Question{" +
                "idQuestion=" + idQuestion +
                ", idUser=" + idUser +
                ", idTopic=" + idTopic +
                ", text='" + text + '\'' +
                ", dateOfCreate=" + dateOfCreate +
                ", sumOfanswers=" + sumOfanswers +
                ", allowed='" + allowed + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (idQuestion != question.idQuestion) return false;
        if (idUser != question.idUser) return false;
        if (idTopic != question.idTopic) return false;
        if (sumOfanswers != question.sumOfanswers) return false;
        if (text != null ? !text.equals(question.text) : question.text != null) return false;
        if (dateOfCreate != null ? !dateOfCreate.equals(question.dateOfCreate) : question.dateOfCreate != null)
            return false;
        return allowed != null ? allowed.equals(question.allowed) : question.allowed == null;
    }

    @Override
    public int hashCode() {
        int result = idQuestion;
        result = 31 * result + idUser;
        result = 31 * result + idTopic;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (dateOfCreate != null ? dateOfCreate.hashCode() : 0);
        result = 31 * result + sumOfanswers;
        result = 31 * result + (allowed != null ? allowed.hashCode() : 0);
        return result;
    }
}
