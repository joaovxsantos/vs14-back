// Ex06

let tela = document.getElementById('tela');
let operacaoAtual = '';
let operacaoAnterior = '';
let operacao;

document.querySelectorAll('.button').forEach(button => {
    button.addEventListener('click', () => {
        if (button.hasAttribute('data-number')) {
            appendNumber(button.getAttribute('data-number'));
        } else if (button.hasAttribute('data-operation')) {
            escolherOperacao(button.getAttribute('data-operation'));
        } else if (button.classList.contains('equal')) {
            executar();
        } else if (button.classList.contains('clear')) {
            limparTela();
        } else if (button.classList.contains('delete')) {
            deleteDigito();
        }
    });
});

function appendNumber(num) {
    operacaoAtual += num;
    tela.value = operacaoAtual;
}


function limparTela() {
    operacaoAtual = '';
    operacaoAnterior = '';
    operacao = '';
    tela.value = operacaoAtual;
}

function escolherOperacao(op) {
    if (operacaoAtual === '') return;
    executar();
    operacao = op;
    operacaoAnterior = operacaoAtual;
    operacaoAtual = '';
}

function executar() {
    let exec;
    const anterior = parseFloat(operacaoAnterior);
    const atual = parseFloat(operacaoAtual);

    switch (operacao) {
        case '+':
            exec = anterior + atual;
            break;
        case '-':
            exec = anterior - atual;
            break;
        case '*':
            exec = anterior * atual;
            break;
        case '/':
            exec = anterior / atual;
            break;
        default:
            return;
    }
    operacaoAtual = exec.toString();
    operacao = '';
    operacaoAnterior = '';
    tela.value = operacaoAtual;
}

function deleteDigito() {
    operacaoAtual = operacaoAtual.slice(0, -1);
    tela.value = operacaoAtual;
}