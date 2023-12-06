(function(){
    window.addEventListener('load', () => {
        let formCadastroUsuario = document.getElementById("formCadastroUsuario")
        formCadastroUsuario.addEventListener('submit', event => {
            if (!formCadastroUsuario.checkValidity()) {
              event.preventDefault();
              event.stopPropagation();
              // submit
            }

            formCadastroUsuario.classList.add("was-validated");
        }, false)
    })
})();