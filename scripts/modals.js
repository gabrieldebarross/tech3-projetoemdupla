// Gabriel de Barros The Creator 
function modallogin() {
    const modallogin = document.getElementById("modal-login");
    const openbtnmodallogin = document.getElementById("openmodallogin");
    const closebtnmodallogin = document.getElementById("closemodallogin");

    openbtnmodallogin.onclick = function () {
        modallogin.style.display = "block";
    }

    closebtnmodallogin.onclick = function () {
        modallogin.style.display = "none";
    }

    window.addEventListener('click', (e) => {
        if (e.target == modallogin) { // Quando houver um click no modal, na parte escura, o modal ficara "invisivel"
            modallogin.style.display = "none";
        }

    })
}

function modalcadastro() {
    const modalcadastro = document.getElementById("modal-cadastro");
    const openmodalcadastro = document.getElementById("openmodalcadastro");
    const closebtnmodalcadastro = document.getElementById("closemodalcadastro");

    openmodalcadastro.onclick = function () {
        modalcadastro.style.display = "block";
    }

    closebtnmodalcadastro.onclick = function () {1,41
        modalcadastro.style.display = "none";
    }

    window.addEventListener('click', (e) => {
        if(e.target == modalcadastro){ // Quando houver um click no modal, na parte escura, o modal ficara "invisivel", porque o evento target pegara o elemento dom onde houve o click, se for igual ao elemento modalcadastro = true, executara a acao do estilo
            modalcadastro.style.display = "none";
        }
    })
}


modallogin();
modalcadastro();