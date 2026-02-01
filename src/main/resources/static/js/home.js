const toggleBtn = document.getElementById('themeToggle');
const leftBtn1 = document.getElementById('leftThemeToggle1');
const leftBtn2 = document.getElementById('leftThemeToggle2');
const body = document.body;

toggleBtn?.addEventListener('click', () => {
    body.classList.toggle('light-mode');

    toggleBtn.textContent = body.classList.contains('light-mode')
        ? "☀️ Light Mode"
        : "🌙 Dark Mode";

    toggleBtn.classList.toggle("btn-dark");
    toggleBtn.classList.toggle("btn-light");

    leftBtn1?.classList.toggle("btn-dark");
    leftBtn1?.classList.toggle("btn-light");

    leftBtn2?.classList.toggle("btn-dark");
    leftBtn2?.classList.toggle("btn-light");
});
