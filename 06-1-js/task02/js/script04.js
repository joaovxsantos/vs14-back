// Ex04
const images = ['./assets/img.jpg', './assets/img_edited1.png', './assets/img_edited2.png'];
const imageElement = document.querySelector('.img');

const butons = document.querySelectorAll('.btn');
butons.forEach((btn, indx) => {
    btn.addEventListener('click', (e) => {
        imageElement.src = images[indx]
    })
})