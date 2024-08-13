const livros = [
    { id: "01", categoria: "Terror", titulo: "It" },
    { id: "02", categoria: "Terror", titulo: "O Exorcista" },
    { id: "03", categoria: "Terror", titulo: "Drácula" },
    { id: "04", categoria: "Romance", titulo: "O Morro dos Ventos Uivantes" },
    { id: "05", categoria: "Policial", titulo: "O Silêncio dos Inocentes" },
    { id: "06", categoria: "Suspense", titulo: "Boneco de Neve" },
    { id: "07", categoria: "Suspense", titulo: "Bird Box" },
    { id: "08", categoria: "Romance", titulo: "Orgulho e Preconceito" }
];


console.log('O catálogo de livros é composto por:')
for (let livro of livros) {
    console.log(livro.titulo)
}



let livrosTerror = livros.filter((livro) => livro.categoria === 'Terror');

console.log('Os livros de categoria de Terror da biblioteca, são:')
for (let livro of livrosTerror) {
    console.log(livro.titulo)
}