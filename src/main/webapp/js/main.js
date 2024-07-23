
function getCookie(name) {
    const nameEQ = name + "=";
    const ca = document.cookie.split(';');
    for(let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) === ' ') c = c.substring(1, c.length);
        if (c.indexOf(nameEQ) === 0) return c.substring(nameEQ.length, c.length);
    }
    return null;
}

function setCookie(name, value, days) {
    const date = new Date();
    date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
    const expires = "expires=" + date.toUTCString();
    document.cookie = name + "=" + value + ";" + expires + ";path=/";
}

function saveCredentials(username, password) {
    setCookie("username", username, 7); // Зберігати логін на 7 днів
    setCookie("password", password, 7); // Зберігати пароль на 7 днів
}

function autoLogin() {
    const username = getCookie("username");
    const password = getCookie("password");

    if (username && password) {
        // Відправка POST-запиту для автоматичного входу
        fetch('/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: `username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`
        })
            .then(response => {
                if (response.ok) {
                    // Якщо логін успішний, перенаправити на домашню сторінку або виконати інші дії
                    window.location.href = '/home.jsp';
                } else {
                    // Якщо логін не успішний, видалити куки
                    document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
                    document.cookie = "password=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }
}

document.addEventListener("DOMContentLoaded", function() {
    autoLogin();
});
