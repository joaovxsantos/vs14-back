// Ex01
const butons = document.querySelectorAll('.btn');
butons.forEach((btn, indx) => {
    btn.addEventListener('click', (e) => {
        if (indx === 0) {
            document.querySelector('.texto-trocar').innerText = 'O texto foi alterado.'
        } else if (indx === 1) {
            location.reload();
        }
    })
})