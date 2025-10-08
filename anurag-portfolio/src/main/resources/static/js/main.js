const hamburger = document.querySelector(".hamburger");
const navMenu = document.querySelector(".nav-links");

hamburger.addEventListener("click", () => {
    hamburger.classList.toggle("active");
    navMenu.classList.toggle("active");
});

document.querySelectorAll(".nav-links a").forEach(link => {
    link.addEventListener("click", () => {
        hamburger.classList.remove("active");
        navMenu.classList.remove("active");
    });
});


// Get the form element
const form = document.getElementById('contactForm');

// Create notification element
const notification = document.createElement('div');
notification.className = 'submit-notification';
notification.innerHTML = `
    <div class="notification-content">
        <div class="spinner"></div>
        <span class="notification-text">Submitting your message...</span>
    </div>
`;
document.body.appendChild(notification);

// Add CSS for notification
const style = document.createElement('style');
style.textContent = `
    .submit-notification {
        position: fixed;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background: rgba(255, 255, 255, 0.95);
        backdrop-filter: blur(10px);
        padding: 2rem;
        border-radius: 16px;
        box-shadow: 0 20px 40px rgba(0, 0, 0, 0.2);
        border: 1px solid #e2e8f0;
        z-index: 10000;
        display: none;
        align-items: center;
        gap: 1rem;
        min-width: 300px;
    }
    
    .submit-notification.show {
        display: flex;
        animation: fadeIn 0.3s ease;
    }
    
    .notification-content {
        display: flex;
        align-items: center;
        gap: 1rem;
    }
    
    .spinner {
        width: 24px;
        height: 24px;
        border: 3px solid #e2e8f0;
        border-top: 3px solid #2563eb;
        border-radius: 50%;
        animation: spin 1s linear infinite;
    }
    
    .notification-text {
        color: #1e293b;
        font-weight: 600;
        font-size: 1rem;
    }
    
    @keyframes spin {
        0% { transform: rotate(0deg); }
        100% { transform: rotate(360deg); }
    }
    
    @keyframes fadeIn {
        from { opacity: 0; transform: translate(-50%, -60%); }
        to { opacity: 1; transform: translate(-50%, -50%); }
    }
    
    .notification-overlay {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: rgba(0, 0, 0, 0.5);
        z-index: 9999;
        display: none;
    }
    
    .notification-overlay.show {
        display: block;
        animation: fadeInOverlay 0.3s ease;
    }
    
    @keyframes fadeInOverlay {
        from { opacity: 0; }
        to { opacity: 1; }
    }
    
    .submit-notification.success .spinner {
        border: 3px solid #10b981;
        border-top: 3px solid #10b981;
        animation: none;
    }
    
    .submit-notification.success .spinner::before {
        content: "✓";
        display: block;
        text-align: center;
        color: #10b981;
        font-weight: bold;
        font-size: 16px;
        line-height: 18px;
    }
    
    .submit-notification.error .spinner {
        border: 3px solid #dc2626;
        border-top: 3px solid #dc2626;
        animation: none;
    }
    
    .submit-notification.error .spinner::before {
        content: "✕";
        display: block;
        text-align: center;
        color: #dc2626;
        font-weight: bold;
        font-size: 16px;
        line-height: 18px;
    }
`;
document.head.appendChild(style);

// Create overlay
const overlay = document.createElement('div');
overlay.className = 'notification-overlay';
document.body.appendChild(overlay);

// Function to hide notification
function hideNotification() {
    notification.classList.remove('show', 'success', 'error');
    overlay.classList.remove('show');
}

form.addEventListener('submit', async (e) => {
    e.preventDefault(); // Prevent default form submission

    // Show notification
    notification.classList.add('show');
    overlay.classList.add('show');

    // Collect form data
    const data = {
        name: form.name.value,
        email: form.email.value,  // optional
        subject: form.subject.value,
        message: form.message.value
    };

    try {
        // Call your Spring Boot API
        const response = await fetch('/Anurag/user/api/feedback', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });
        const result = await response.text(); // get the response message
        if (result === "True") {
            // Show success notification
            notification.classList.add('success');
            notification.querySelector('.notification-text').textContent = 'Message sent successfully!';

            // Hide notification after 2 seconds and reset form
            setTimeout(() => {
                hideNotification();
                form.reset(); // clear form after successful submission
            }, 2000);

        } else {
            // Show error notification for false response
            notification.classList.add('error');
            notification.querySelector('.notification-text').textContent = 'Failed to send message. Please try again.';

            // Hide notification after 3 seconds
            setTimeout(() => {
                hideNotification();
            }, 2000);
        }


    } catch (error) {
        console.error('Error sending feedback:', error);

        // Show error notification
        notification.classList.add('error');
        notification.querySelector('.notification-text').textContent = 'Error sending message. Please try again.';

        // Hide notification after 3 seconds
        setTimeout(() => {
            hideNotification();
        }, 2000);
    }
});

// Close notification when clicking overlay
overlay.addEventListener('click', hideNotification);