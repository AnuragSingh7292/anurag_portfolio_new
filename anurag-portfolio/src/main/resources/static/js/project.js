// Fetch projects from API
fetch('/Anurag/api/projects/all') // Replace with your Spring Boot API endpoint
    .then(response => response.json())
    .then(projects => {
        const grid = document.getElementById('projectsGrid');

        projects.forEach(project => {
            const card = document.createElement('div');
            card.className = 'project-card';
            card.setAttribute('data-category', project.category?.toLowerCase() || 'other');

            // Live link
            const liveLink = project.links?.live && project.links.live !== "#"
                ? project.links.live
                : "/Anurag/defaultpage.html";

// GitHub link
            const githubLink = project.links?.github && project.links.github !== "#"
                ? project.links.github
                : "/Anurag/defaultpage.html";
            card.innerHTML = `
                <div class="project-header">
                    <h3 class="project-title">${project.title || 'No Title'}</h3>
                    <span class="project-badge ${project.badge?.toLowerCase() || 'default'}">${project.badge || ''}</span>
                </div>
                <p class="project-description">
                    ${project.shortInfo || ''}
                </p>
                <div class="project-tech">
                    ${project.technologies ? project.technologies.map(tech => `<span>${tech}</span>`).join('') : ''}
                </div>
               
                <div class="project-links">
                    <a href="${liveLink}" class="project-link">
                        <i class="fas fa-external-link-alt"></i>
                        Live
                    </a>
                    <a href="${githubLink}" class="project-link">
                        <i class="fab fa-github"></i>
                        GitHub
                    </a>
                    <button class="project-link read-more-btn" data-project="${project.id || ''}">
                        <i class="fas fa-book-open"></i>
                        Read
                    </button>
                </div>
            `;

            grid.appendChild(card);
        });
    })
    .catch(err => console.error('Error fetching projects:', err));

document.addEventListener("click", function (e) {
    if (e.target.closest(".read-more-btn")) {
        const projectId = e.target.closest(".read-more-btn").dataset.project;
        console.log(projectId);
        window.location.href = `project.html?id=${projectId}`;
    }
});
