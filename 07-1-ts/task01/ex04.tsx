const queijos: string[] = ['Mussarela', 'Minas', 'Parmesão', 'Prato', 'Gorgonzola'];

console.log(`Cardápio de queijos: ${queijos.join(', ')}.`);


queijos.push('Mascarpone', 'Ricota', 'Provolone');
console.log(`Lista atualizada: ${queijos.join(', ')}.`);


queijos.sort()
console.log(`Lista atualizada em ordem alfabética: ${queijos.join(', ')}.`);


const indexCottage:number = queijos.findIndex(queijo => queijo > "Cottage");
queijos.splice(indexCottage, 0, "Cottage");
console.log(`Lista atualizada: ${queijos.join(', ')}.`);