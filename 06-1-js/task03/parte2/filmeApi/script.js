const SEARCH_API = 'https://api.themoviedb.org/3/search/movie?api_key=3fd2be6f0c70a2a598f084ddfb75487c&query="'
const IMG_PATH = 'https://image.tmdb.org/t/p/w1280'
const container = document.querySelector('.container-films');
const search = document.querySelector('#search');
const form = document.querySelector('#form');


//Fazendo requisição de acordo com o link e passando para a função createFilms


// Com async await
const getDates = async (url) => {
    let response = await axios.get(url)
    createFilms(response.data.results)
}



// Com then e catch
// const getDates = (url) => {
//     axios.get(url)
//         .then(response => {
//             createFilms(response.data.results);
//         })
//         .catch(error => {
//             console.error('Erro na requisição:', error);
//         });
// };



//Função que poe os elementos na tela
const createFilms = (url) => {

    container.innerHTML = ''

    url.forEach(element => {
        let { poster_path, original_title, vote_average, overview } = element

        let filmEl = document.createElement('div')
        filmEl.classList.add('film')

        filmEl.innerHTML = `<img src="${IMG_PATH + poster_path}" alt="" id="img">
                                <span id="title">${original_title}</span>
                                <span id="note" class="${defineColor(vote_average)}">${vote_average}</span>
                                <div class="overview">
                                <h3>Overview</h3>
                                <p>${overview}</p>
                                </div>`
        container.appendChild(filmEl)
    })
}

//Função que define a cor de acordo com a avaliação do filme
const defineColor = (vote) => {
    if (vote >= 8) {
        return 'green'
    } else if (vote >= 5) {
        return 'orange'
    } else {
        return 'red'
    }
}

//Função que faz a busca de filmes de acordo com a API
form.addEventListener('submit', (e) => {
    e.preventDefault()

    let searchTerm = search.value


    if (searchTerm) {
        getDates(SEARCH_API + searchTerm)
        search.value = ''
    } else {
        window.location.reload()
    }
})
getDates('https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=a3b8454a6b0a044977e0baa531133612&page=1')