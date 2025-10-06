package com.anurag.anurag_portfolio.Controller;

import com.anurag.anurag_portfolio.Entities.Feedback;
import com.anurag.anurag_portfolio.Service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/api/feedback")
public class FeedbackController {

    @Autowired
    private EmailService emailService;

    @Value("${mail.username}")
    private String emailAddress;

    @PostMapping
    public String submitFeedback(@RequestBody Feedback feedback) {
        // Prepare HTML email
        String userEmail = (feedback.getEmail() == null || feedback.getEmail().isEmpty())
                ? "Not provided"
                : feedback.getEmail();

        String htmlBody = "<h2>New Feedback Received</h2>"
                + "<p><strong>Name:</strong> " + feedback.getName() + "</p>"
                + "<p><strong>Email:</strong> " + userEmail + "</p>"
                + "<p><strong>Subject:</strong> " + feedback.getSubject() + "</p>"
                + "<p><strong>Message:</strong><br/>" + feedback.getMessage() + "</p>";

        // Send email
        try {
            emailService.sendHtmlEmail(emailAddress,
                    "New Feedback from " + feedback.getName(),
                    htmlBody);
        }
        catch (Exception e) {
            return "false";
        }

        return "true";
    }
}

