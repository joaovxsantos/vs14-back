const numerosPrimos = (numero) => {

    for (let i = 2; i <= Math.sqrt(numero); i++) {
        if (numero % i === 0) return false;
    }
    return true;
}


function numerosPrimosGemeos(max) {
    let gemeosPrimos = [];

    for (let i = 2; i <= max - 2; i++) {
        if (numerosPrimos(i) && numerosPrimos(i + 2)) {
            gemeosPrimos.push([i, i + 2]);
        }
    }
    return gemeosPrimos;
}


console.log(numerosPrimosGemeos(200));