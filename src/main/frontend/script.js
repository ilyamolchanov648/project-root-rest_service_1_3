// script.js
document.addEventListener('DOMContentLoaded', function() {
    const recordsContainer = document.getElementById('records');

    function getRecords() {
        fetch('/api/records') // Замените на ваш путь к API
            .then(response => response.json())
            .then(data => {
                const records = data.records;

                // Очистка текущего содержимого
                recordsContainer.innerHTML = '';

                // Вставка новых записей
                records.forEach(record => {
                    const recordElement = document.createElement('div');
                    recordElement.classList.add('record');
                    recordElement.textContent = record.name; // Предполагаем, что у вас есть поле 'name' в записи
                    recordsContainer.appendChild(recordElement);
                });
            })
            .catch(error => console.error('Error:', error));
    }

    // Запрашиваем данные сразу после загрузки страницы
    getRecords();

    // Запрашиваем данные каждые 5 секунд
    setInterval(getRecords, 5000); // Интервал в миллисекундах
});
