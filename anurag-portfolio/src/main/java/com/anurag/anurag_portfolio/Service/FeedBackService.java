package com.anurag.anurag_portfolio.Service;

import com.anurag.anurag_portfolio.Entities.Feedback;
import com.anurag.anurag_portfolio.Repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public void save(Feedback feedback) {
        feedbackRepository.save(feedback);
    }
}
