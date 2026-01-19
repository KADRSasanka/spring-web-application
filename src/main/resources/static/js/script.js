const toggleBtn = document.getElementById('themeToggle');
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
});