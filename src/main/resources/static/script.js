document.addEventListener("DOMContentLoaded", () => {
    const classSelection = document.getElementById('class-selection');
    const selectedClass = document.getElementById('selected-class');
    const scheduleBody = document.getElementById('schedule-body');

    classSelection.addEventListener('change', (event) => {
        const selectedValue = event.target.value;
        if (selectedValue !== "Select Class") {
            selectedClass.textContent = selectedValue;
            fetchSchedule(selectedValue);
        }
    });

    function fetchSchedule(className) {
        fetch(`/schedule/${className}`)
            .then(response => response.text())
            .then(data => {
                updateSchedule(data);
            })
            .catch(error => {
                console.error('Error fetching schedule:', error);
            });
    }

    function updateSchedule(data) {
        // For simplicity, assuming data is a simple text
        // In real scenario, it would be an object that you need to parse and use to update the schedule
        scheduleBody.innerHTML = `<tr><td colspan="6">${data}</td></tr>`;
    }
});
