document.addEventListener("DOMContentLoaded", function () {

    const toggleBtn = document.getElementById('themeToggle');
    const backBtn = document.getElementById('leftThemeToggle1');
    const body = document.body;

    toggleBtn?.addEventListener('click', () => {
        body.classList.toggle('light-mode');

        toggleBtn.textContent = body.classList.contains('light-mode')
            ? "☀️ Light Mode"
            : "🌙 Dark Mode";

        toggleBtn.classList.toggle("btn-dark");
        toggleBtn.classList.toggle("btn-light");

        backBtn.classList.toggle("btn-dark");
        backBtn.classList.toggle("btn-light");
    });


    // Back button
    backBtn.addEventListener("click", function () {
        window.history.back();
    });

});

document.addEventListener('DOMContentLoaded', () => {
    const editModal = document.getElementById('editEventModal');

    editModal.addEventListener('show.bs.modal', event => {
        const button = event.relatedTarget;

        document.getElementById('editId').value = button.dataset.id;
        document.getElementById('editEventCode').value = button.dataset.code;
        document.getElementById('editEventName').value = button.dataset.name;
        document.getElementById('editVenue').value = button.dataset.venue;
        document.getElementById('editProjectChair').value = button.dataset.chair;
        document.getElementById('editStatus').value = button.dataset.status;
        document.getElementById('editStartDate').value = button.dataset.start;
        document.getElementById('editEndDate').value = button.dataset.end;
    });
});
