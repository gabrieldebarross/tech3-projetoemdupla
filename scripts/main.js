function escopo() {
    const header = document.querySelector('.header');
    const input = document.querySelector('#stylecolor');
    input.readOnly = true;
    const brand = document.querySelector('.brand');

    function activeClass() { // Função para alternar a classe active
        const isActive = header.classList.contains('active') || brand.classList.contains('active'); // Aqui será verificado se as classes Header e Brand possuem a class active

        if (isActive) {
            header.classList.remove('active');
            brand.classList.remove('active');
            input.classList.remove('active');
            input.value = '#FFFFFF'
            console.log('A classe active foi removida')
        } else {
            header.classList.add('active');
            brand.classList.add('active');
            input.classList.add('active');
            input.value = '#0A74DA';
            console.log('A classe active foi adicionada')
        }
    }

    input.addEventListener('click', (e) => {
        e.preventDefault();
        activeClass(); // Após o evento de click, chama a função que vai alternar a classe active
    })
}

escopo();