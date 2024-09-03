var modal = document.getElementById("modal-login");
        var openModalBtn = document.getElementById("openModalBtn");
        var closeModalBtn = document.getElementById("closeModalBtn");

        // Quando o usuário clicar no botão, abre o modal
        openModalBtn.onclick = function() {
            modal.style.display = "block";
        }

        // Quando o usuário clicar no botão de fechar, esconde o modal
        closeModalBtn.onclick = function() {
            modal.style.display = "none";
        }

        // Quando o usuário clicar fora do modal, também esconde o modal
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }