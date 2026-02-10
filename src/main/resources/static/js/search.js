document.addEventListener("DOMContentLoaded", () => {

    const searchInput = document.getElementById("eventSearch");
    const tableBody = document.getElementById("events-table-body");

    function fetchSearch() {
        const keyword = searchInput.value.trim();

        fetch(`/search?keyword=${encodeURIComponent(keyword)}`)
            .then(res => res.json())
            .then(data => {
                tableBody.innerHTML = "";

                data.forEach(event => {
                    const statusBadge = getStatusBadge(event.status);
                    const projectChair = event.projectChair
                        ? event.projectChair.firstName + " " + event.projectChair.lastName
                        : "N/A";

                    tableBody.innerHTML += `
<tr>
    <td>${event.id}</td>
    <td>${event.eventCode}</td>
    <td>${event.eventName}</td>
    <td>${event.venue}</td>
    <td>${projectChair}</td>
    <td>${event.startDate || ''} - ${event.endDate || ''}</td>
    <td>${statusBadge}</td>
    <td>...</td>
</tr>`;
                });
            });
    }

    searchInput.addEventListener("input", fetchSearch);

    searchInput.addEventListener("keypress", function(e) {
        if (e.key === "Enter") {
            e.preventDefault();
            fetchSearch();
        }
    });

    function getStatusBadge(status) {
        switch(status) {
            case "UPCOMING": return `<span class="badge bg-info">UPCOMING</span>`;
            case "ONGOING": return `<span class="badge bg-primary">ONGOING</span>`;
            case "COMPLETED": return `<span class="badge bg-success">COMPLETED</span>`;
            case "POSTPONED": return `<span class="badge bg-warning text-dark">POSTPONED</span>`;
            case "CANCELLED": return `<span class="badge bg-danger">CANCELLED</span>`;
            case "DRAFT": return `<span class="badge bg-secondary">DRAFT</span>`;
            default: return `<span class="badge bg-secondary">${status}</span>`;
        }
    }

});
