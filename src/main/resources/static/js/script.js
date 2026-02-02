document.addEventListener("DOMContentLoaded", function () {

    /* ===============================
       Theme Toggle + Back Button
    ================================ */
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

        backBtn?.classList.toggle("btn-dark");
        backBtn?.classList.toggle("btn-light");
    });

    backBtn?.addEventListener("click", () => {
        window.history.back();
    });

    /* ===============================
       Edit Event Modal Logic
    ================================ */
    const editModal = document.getElementById('editEventModal');

    if (editModal) {
        editModal.addEventListener('show.bs.modal', function (event) {

            const button = event.relatedTarget;
            const id = button.getAttribute('data-id');

            // Set form action dynamically
            const form = document.getElementById('editEventForm');
            form.action = `/index/update/${id}`;

            // Populate fields (match NAME attributes)
            form.querySelector('[name="eventCode"]').value = button.getAttribute('data-code');
            form.querySelector('[name="eventName"]').value = button.getAttribute('data-name');
            form.querySelector('[name="venue"]').value = button.getAttribute('data-venue');
            form.querySelector('[name="startDate"]').value = button.getAttribute('data-start');
            form.querySelector('[name="endDate"]').value = button.getAttribute('data-end');
            form.querySelector('[name="status"]').value = button.getAttribute('data-status');
        });
    }

});
