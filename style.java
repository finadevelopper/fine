document.addEventListener('DOMContentLoaded', function() {
    const sleepText = document.querySelector('.sleep-text');

    // Détecte la fin de l'animation et redirige vers une autre page
    sleepText.addEventListener('animationend', function() {
        window.location.href = "acceuille.html"; // Remplacez par l'URL de votre nouvelle page
    });
});
document.addEventListener('DOMContentLoaded', function() {
    const postForm = document.getElementById('post-form');
    const fileInput = document.getElementById('file-input');
    const postsContainer = document.getElementById('posts-container');

    postForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Empêche le formulaire de se soumettre normalement

        const file = fileInput.files[0]; // Récupère le fichier téléchargé
        const caption = document.getElementById('caption').value.trim(); // Récupère la légende du post

        if (file) {
            // Créer un objet URL pour afficher l'image
            const imageUrl = URL.createObjectURL(file);

            // Créer un nouvel élément de publication
            const postElement = document.createElement('div');
            postElement.classList.add('post');
            postElement.innerHTML = `
                <img src="${imageUrl}" alt="Posted Image">
                <p>${caption}</p>
            `;
            postsContainer.prepend(postElement);

            // Réinitialiser le formulaire après la publication
            postForm.reset();
        } else {
            alert('Veuillez sélectionner une image à publier.');
        }
    });
});
