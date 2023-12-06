(function(){
    window.addEventListener('load', () => {
        let formCadastraURL = document.getElementById("formCadastraURL")
        formCadastraURL.addEventListener('submit', async (event) => {
            event.preventDefault();
            event.stopPropagation();
            formCadastraURL.classList.add("was-validated");

            if (formCadastraURL.checkValidity()) {
                let targetInput = document.querySelector('input[name=target]')
                let descriptionInput = document.querySelector('input[name=description]')
                let customUrlInput = document.querySelector('input[name=customurl]')

                const body = {
                    target: targetInput.value,
                    description: descriptionInput.value,
                    customurl: customUrlInput.value
                }

                const headers = new Headers({
                    "X-API-KEY": "",
                    "Content-Type": "application/json"
                })

                const url = "https://kutt.it/api/v2/links"

                await fetch(url, {
                    method: "POST",
                    headers,
                    body: JSON.stringify(body),
                    mode: "no-cors"
                }).then((response) => {
                    let data = response.json()
                    console.log(data)

                    formCadastraURL.classList.remove("was-validated");
                    targetInput.value = ""
                    descriptionInput.value = ""
                    customUrlInput.value = ""
                }).catch(error => {
                    console.error("Ocorreu um erro: ", error);
                })

                fetch

                // após cadastrar
                
            }

        }, false)
    })
})();