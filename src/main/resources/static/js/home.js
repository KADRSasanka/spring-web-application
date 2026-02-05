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

// ===============================
// Doughnut Chart – Event Status
// ===============================

document.addEventListener("DOMContentLoaded", () => {

    const chartCanvas = document.getElementById("eventStatusChart");
    if (!chartCanvas) return;

    const upcoming = Number(chartCanvas.dataset.upcoming || 0);
    const ongoing = Number(chartCanvas.dataset.ongoing || 0);
    const completed = Number(chartCanvas.dataset.completed || 0);
    const postponed  = Number(chartCanvas.dataset.postponed || 0);
    const cancelled  = Number(chartCanvas.dataset.cancelled || 0);

    new Chart(chartCanvas, {
        type: "doughnut",
        data: {
            labels: ["Upcoming", "Ongoing", "Completed", "Postponed", "Cancelled"],
            datasets: [{
                data: [upcoming, ongoing, completed, postponed, cancelled],
                backgroundColor: [
                    "#0d6efd", // blue
                    "#20c997", // green
                    "#6f42c1",  // purple
                    "#ffc107", // Bootstrap warning (Postponed)
                    "#dc3545"  // Bootstrap danger (Cancelled)
                ],
                borderWidth: 0,
                hoverOffset: 12
            }]
        },
        options: {
            responsive: true,
            cutout: "70%",   // smaller hole → thicker doughnut
            radius: "90%",   // slightly smaller overall chart
            plugins: {
                legend: {
                    position: "bottom",
                    labels: {
                        padding: 15,
                        boxWidth: 14
                    }
                }
            }
        }
    });
});
