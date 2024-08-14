// Ex05
const btnCalc = document.querySelector('.btn-calc');
const operacao = document.querySelector('#operacao');


btnCalc.addEventListener('click', () => {

    const val1 = parseFloat(document.getElementById('val1').value);
    const val2 = parseFloat(document.getElementById('val2').value);
    const operacaoEscolhida = operacao.value;
    const textResutl = document.querySelector('#resultado');
    let result = 0;


    switch (operacaoEscolhida) {
        case 'add':
            result = val1 + val2;
            break;
        case 'sub':
            result = val1 - val2;
            break;
        case 'mult':
            result = val1 * val2;
            break;
        case 'div':
            result = val1 / val2;
            break;
        default:
            console.log("Operação inválida.");
            return;
    }

    textResutl.innerHTML = result;
})
