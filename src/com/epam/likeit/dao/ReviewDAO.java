package com.epam.likeit.dao;

import com.epam.likeit.bean.Review;
import com.epam.likeit.dao.exception.DAOException;

import java.util.List;

/**
 * Created by mts7072572 on 01.06.2017.
 */
public interface ReviewDAO {
    void createReview(Review Review) throws DAOException;
    Review read(int id) throws DAOException;
    void update(Review review) throws DAOException;
    void deleteReview(int idReview) throws DAOException;
    List<Review> getAll() throws DAOException;
}
