package com.ssk.ecommerce.Service;

import java.util.List;

import com.ssk.ecommerce.Exception.ReviewException;
import com.ssk.ecommerce.Model.Review;

public interface ReviewService {
	
	 public Review addReviewToProduct(Integer productId, Integer UserId,Review review) 
			 throws ReviewException;
	 
	 public Review updateReviewToProduct(Integer reviewId,Review review)
			 throws ReviewException;
	 
	 public void deleteReview(Integer reviewId) throws ReviewException;
	 
	 public List<Review> getAllReviewOfProduct(Integer productId)throws ReviewException;

}
