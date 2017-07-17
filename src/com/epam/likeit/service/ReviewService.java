package com.epam.likeit.service;

import com.epam.likeit.bean.Review;
import com.epam.likeit.service.exception.ServiceException;

import java.util.List;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public interface ReviewService {
    void deleteReview(int id) throws ServiceException;
    void addReview(Review review) throws ServiceException;
    Review getReview(int id) throws ServiceException;
    List<Review> getAllReviews() throws ServiceException;
}
