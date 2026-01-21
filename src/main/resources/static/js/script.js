const toggleBtn = document.getElementById('themeToggle');
const lefttoggleBtn1 = document.getElementById('leftThemeToggle1');
const lefttoggleBtn2 = document.getElementById('leftThemeToggle2');
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
        lefttoggleBtn1.textContent = "ADMIN";
        lefttoggleBtn1.classList.remove("btn-light");
        lefttoggleBtn1.classList.add("btn-dark");
    } else {
        lefttoggleBtn1.textContent = "ADMIN";
        lefttoggleBtn1.classList.remove("btn-dark");
        lefttoggleBtn1.classList.add("btn-light");
    }

    if (body.classList.contains('light-mode')) {
        lefttoggleBtn2.textContent = "ADMIN";
        lefttoggleBtn2.classList.remove("btn-light");
        lefttoggleBtn2.classList.add("btn-dark");
    } else {
        lefttoggleBtn2.textContent = "ADMIN";
        lefttoggleBtn2.classList.remove("btn-dark");
        lefttoggleBtn2.classList.add("btn-light");
    }
});

