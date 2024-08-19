const converterTemperatura = (): void => {
    const tempCelsius: number = 30;
    let tempFahrenheit: number = (tempCelsius * 1.8) + 32;
    console.log(tempFahrenheit);
}
converterTemperatura()