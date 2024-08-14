// Ex03
const addBtn = document.querySelector('.add-btn');
const resetBtn = document.querySelector('.reset-btn');
const textCounter = document.querySelector('.counter');


let count = 0;

addBtn.addEventListener('click', () => {
    count += 1
    textCounter.innerHTML = count;
})

resetBtn.addEventListener('click', () => {
    count = 0;
    textCounter.innerHTML = count;
})