// admin.js - for admin.html only
/*
const toggleBtn = document.getElementById('themeToggle');
const body = document.body;

toggleBtn.addEventListener('click', () => {
    body.classList.toggle('light-mode');  // only toggles light-mode on admin page

    if (body.classList.contains('light-mode')) {
        toggleBtn.textContent = "☀️ Light Mode";
        toggleBtn.classList.remove("btn-light");
        toggleBtn.classList.add("btn-dark");
    } else {
        toggleBtn.textContent = "🌙 Dark Mode";
        toggleBtn.classList.remove("btn-dark");
        toggleBtn.classList.add("btn-light");
    }
});
document.getElementById("leftThemeToggle1").addEventListener("click", function () {
    window.history.back();
});*/
// admin.js - for admin.html only
document.addEventListener("DOMContentLoaded", function () {

    const toggleBtn = document.getElementById('themeToggle');
    const backBtn = document.getElementById("leftThemeToggle1");
    const body = document.body;

    // Theme toggle
    toggleBtn.addEventListener('click', () => {
        body.classList.toggle('light-mode');

        if (body.classList.contains('light-mode')) {
            toggleBtn.textContent = "☀️ Light Mode";
            toggleBtn.classList.remove("btn-light");
            toggleBtn.classList.add("btn-dark");
        } else {
            toggleBtn.textContent = "🌙 Dark Mode";
            toggleBtn.classList.remove("btn-dark");
            toggleBtn.classList.add("btn-light");
        }
    });

    // Back button
    backBtn.addEventListener("click", function () {
        window.history.back();
    });

});

