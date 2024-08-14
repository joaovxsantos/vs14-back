//Ex02
const inputColor = document.querySelector('.color_input');
const textColor = document.querySelector('.text-cor');


inputColor.addEventListener('input', (e) => {
    textColor.style.color = e.target.value;
})