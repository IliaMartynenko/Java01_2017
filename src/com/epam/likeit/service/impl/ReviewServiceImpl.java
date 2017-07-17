package com.epam.likeit.service.impl;

import com.epam.likeit.bean.Review;
import com.epam.likeit.dao.daofactory.DAOFactory;
import com.epam.likeit.dao.ReviewDAO;
import com.epam.likeit.dao.exception.DAOException;
import com.epam.likeit.service.exception.ServiceException;

import java.util.List;

/**
 * Created by mts7072572 on 13.07.2017.
 */
public class ReviewServiceImpl implements com.epam.likeit.service.ReviewService {
    private final DAOFactory daoObjectFactory= DAOFactory.getInstance();
    private final ReviewDAO reviewDAO=daoObjectFactory.getReviewDAO();
    @Override
    public void deleteReview(int id) throws ServiceException {
        try {
            reviewDAO.deleteReview(id);
        }
        catch(DAOException e){ throw new ServiceException(e);
        }

    }

    @Override
    public void addReview(Review review) throws ServiceException {
        try {
            reviewDAO.createReview(review);
        }
        catch(DAOException e){ throw new ServiceException(e);
        }

    }

    @Override
    public Review getReview(int id) throws ServiceException {
        Review review;
        try {
            review = reviewDAO.read(id);
        }
        catch(DAOException e){ throw new ServiceException(e);
        }
        return review;
    }

    @Override
    public List<Review> getAllReviews() throws ServiceException {
        List<Review> reviews;
        try {
           reviews = reviewDAO.getAll();
        }
        catch(DAOException e){ throw new ServiceException(e);
        }
        return reviews;
    }
}
