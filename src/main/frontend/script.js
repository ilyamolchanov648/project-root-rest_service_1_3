document.addEventListener('DOMContentLoaded', function() {
    fetch('http://localhost:8080/api/users')
        .then(response => response.json())
        .then(data => {
            const userTable = document.getElementById('userTable');
            data.users.forEach(user => {
                const row = userTable.insertRow();
                const idCell = row.insertCell(0);
                const nameCell = row.insertCell(1);
                idCell.textContent = user.id;
                nameCell.textContent = user.name;
            });
        })
        .catch(error => console.error('Error:', error));
});

