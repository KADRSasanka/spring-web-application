const toggleBtn = document.getElementById('themeToggle');
const lefttoggleBtn = document.getElementById('leftThemeToggle');
const body = document.body;

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

    if (body.classList.contains('light-mode')) {
        lefttoggleBtn.textContent = "ADMIN";
        lefttoggleBtn.classList.remove("btn-light");
        lefttoggleBtn.classList.add("btn-dark");
    } else {
        lefttoggleBtn.textContent = "ADMIN";
        lefttoggleBtn.classList.remove("btn-dark");
        lefttoggleBtn.classList.add("btn-light");
    }
});

