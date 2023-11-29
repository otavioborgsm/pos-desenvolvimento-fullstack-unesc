window.onload = () => {

    let btnExecutar = document.getElementById('btnExecutar')
    btnExecutar.onclick = () => {
        let listaImg = document.getElementsByTagName('img')

        for (let item of listaImg) {
            item.classList.add('destaque')            
        }
    }

    let btnRemover = document.getElementById('btnRemover')
    btnRemover.onclick = () => {
        let listaImg = document.getElementsByTagName('img')

        for (let item of listaImg) {
            item.classList.remove('destaque')            
        }
    }
}