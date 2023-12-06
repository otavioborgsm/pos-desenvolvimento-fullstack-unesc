(function(){
    window.addEventListener('load', () => {
        let formConsultaCep = document.getElementById("formConsultaCep")
        formConsultaCep.addEventListener('submit', async (event) => {
            event.preventDefault();
            event.stopPropagation();
            formConsultaCep.classList.add("was-validated");

            if (formConsultaCep.checkValidity()) {
                let cepInput = document.querySelector('input[name=cep]')

                let url = `https://viacep.com.br/ws/${cepInput.value}/json/`
                await fetch(url)
                    .then(response => {
                        return response.json()
                    })
                    .then((data) => {
                        let logradouroInput = document.querySelector('input[name=logradouro]')
                        let bairroInput = document.querySelector('input[name=bairro]')
                        let localidadeInput = document.querySelector('input[name=localidade]')
                        let ufInput = document.querySelector('input[name=uf]')

                        logradouroInput.value = data.logradouro
                        bairroInput.value = data.bairro
                        localidadeInput.value = data.localidade
                        ufInput.value = data.uf
                    })
                    .catch(error => {
                        console.error(error)
                    })
            }

        }, false)
    })
})();