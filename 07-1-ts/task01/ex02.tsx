const parOuImpar = (): void => {
    const numero: number = 12;

    if (numero % 2 === 0) {
        console.log(`O número ${numero} é par`)
    } else {
        console.log(`O número ${numero} é impar`)
    }
}

parOuImpar()