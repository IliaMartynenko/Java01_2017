package com.epam.likeit.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by mts7072572 on 27.05.2017.
 */
public class BannedUser implements Serializable {
    private int idBannedUser;
    private int idUser;
    private int idAdmin;
    private String reasonOfBan;
    private Date dateOfBan;
    private int banDuration;

    public BannedUser() {
    }

    public int  getIdBannedUser() {
        return  idBannedUser;
    }

    public void setIdBannedUser(int idQuestion) {
        this. idBannedUser = idQuestion;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getReasonOfBan() {
        return reasonOfBan;
    }

    public void setReasonOfBan(String reasoOfBan) {
        this.reasonOfBan = reasoOfBan;
    }

    public Date getDateOfBan() {
        return dateOfBan;
    }

    public void setDateOfBan(Date dateOfBan) {
        this.dateOfBan = dateOfBan;
    }

    public int getBanDuration() {
        return banDuration;
    }

    public void setBanDuration(int banDuration) {
        this.banDuration = banDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BannedUser that = (BannedUser) o;

        if (idBannedUser != that.idBannedUser) return false;
        if (idUser != that.idUser) return false;
        if (idAdmin != that.idAdmin) return false;
        if (banDuration != that.banDuration) return false;
        if (reasonOfBan != null ? !reasonOfBan.equals(that.reasonOfBan) : that.reasonOfBan != null) return false;
        return dateOfBan != null ? dateOfBan.equals(that.dateOfBan) : that.dateOfBan == null;
    }

    @Override
    public int hashCode() {
        int result = idBannedUser;
        result = 31 * result + idUser;
        result = 31 * result + idAdmin;
        result = 31 * result + (reasonOfBan != null ? reasonOfBan.hashCode() : 0);
        result = 31 * result + (dateOfBan != null ? dateOfBan.hashCode() : 0);
        result = 31 * result + banDuration;
        return result;
    }

    @Override
    public String toString() {
        return "BannedUser{" +
                "idBannedUser=" + idBannedUser +
                ", idUser=" + idUser +
                ", idAdmin=" + idAdmin +
                ", reasonOfBan='" + reasonOfBan + '\'' +
                ", dateOfBan=" + dateOfBan +
                ", banDuration=" + banDuration +
                '}';
    }
}
