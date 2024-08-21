type Pedidos = {
    nome: String;
    lanche: String;
    bebida: String;
}


const pedidos: Pedidos[] = [
    { nome: 'João', lanche: 'Pizza Calabresa', bebida: 'Refrigerante' },
    { nome: 'Vitor', lanche: 'Pizza Portuguesa', bebida: 'Suco' },
    { nome: 'Ana', lanche: 'Pizza Frango', bebida: 'Cerveja' },
    { nome: 'Beatriz', lanche: 'Pizza Carne Seca', bebida: 'Refrigerante' },
    { nome: 'Carlos', lanche: 'Pizza Doce', bebida: 'Suco' }
];


console.log('Pizzaria Gula - Relatório diário\n')


// Pedidos Pizza
let pedidosPizza: String[] = pedidos.filter((pedido) => pedido.lanche.includes('Pizza')).map(p => p.lanche);
console.log(`No dia de hoje os pedidos de pizza foram: ${pedidosPizza.join(', ')}\n`)



// Pedidos com Refrigerante

let clientesRefri: String[] = pedidos.filter((pedido) => pedido.bebida.includes('Refrigerante')).map(p => p.nome);
console.log(`Os clientes que fizeram pedido com refrigerante foram: ${clientesRefri.join(', ')}\n`)


// Pedidos com Suco

let clientesSuco: String[] = pedidos.filter((pedido) => pedido.bebida.includes('Suco')).map(p => p.nome);
console.log(`Os clientes que fizeram pedido com suco foram: ${clientesSuco.join(', ')}\n`)



// Pedidos com Cerveja

let clientesCerveja: String[] = pedidos.filter((pedido) => pedido.bebida.includes('Cerveja')).map(p => p.nome);
console.log(`Os clientes que fizeram pedido com suco foram: ${clientesCerveja.join(', ')}`)
