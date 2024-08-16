const buttonStart = document.querySelector("#sortButton");


buttonStart.addEventListener('click', () => {

    const nomesInput = document.querySelector('#nameInput').value.split(',');
    const velocidade = document.querySelector("#speedInput").value;
    const duracao = document.querySelector("#durationInput").value;
    const tela = document.querySelector("#selectedName");
    let index = 0;

    const intervalo = setInterval(() => {
        tela.innerHTML = nomesInput[index]
        index = index + 1;
    }, velocidade)


    setTimeout(() => {
        clearInterval(intervalo);
        const nomeSorteado = nomesInput[Math.floor((Math.random() * nomesInput.length))];
        tela.innerHTML = nomeSorteado;
    }, duracao)
})