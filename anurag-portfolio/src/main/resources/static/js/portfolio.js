document.addEventListener("DOMContentLoaded", function () {
    const skills = [
        "Java Developer  ",
        "Full Stack Developer  ",
        "Spring Boot Expert  ",
        "Python Programmer  ",
        "AI & Deep Learning  ",
        "Android App Developer  ",
        "MongoDB & SQL  ",
        "Web Technologies "
    ];

    // Add this at the top with skills[]
    const colors = [
        "#fc5476", // Pinkish Red
        "#ff9f40", // Orange
        "#ffcd53", // Yellow
        "#48c2c2", // Teal
        "#e32f85",  // Magenta
        "#34a9f4", // Blue
        "#00c59f", // Green
        "#e53e8e"  // Magenta
    ];



    const tagline = document.getElementById("tagline");
    let skillIndex = 0;
    let charIndex = 0;
    let isDeleting = false;

    function typeEffect() {
        const current = skills[skillIndex];

        // add a span with class="cursor"
        if (isDeleting) {
            tagline.innerHTML = current.substring(0, charIndex--) + `<span class="cursor">|</span>`;
        } else {
            tagline.innerHTML = current.substring(0, charIndex++) + `<span class="cursor">|</span>`;
        }

        // after inserting, now select the cursor
        const cursor = document.querySelector(".cursor");

        // apply colors only while typing
        if (!isDeleting && cursor) {
            tagline.style.color = colors[skillIndex];
            cursor.style.color = colors[skillIndex];
            cursor.style.backgroundColor = colors[skillIndex];
        }

        let speed = isDeleting ? 70 : 120; // delete faster

        if (!isDeleting && charIndex === current.length) {
            // pause before deleting
            setTimeout(() => {
                isDeleting = true;
                typeEffect();
            }, 1500);
            return;
        }

        if (isDeleting && charIndex === 0) {
            isDeleting = false;
            skillIndex = (skillIndex + 1) % skills.length;
        }

        setTimeout(typeEffect, speed);
    }

    typeEffect();

});



