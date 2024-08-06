function escopo() {
    const header = document.querySelector('.header'); 
    const input = document.querySelector('#stylecolor');
    input.readOnly = true; // Deixei como somente para leitura para o usuário não poder alterar o valor do input
    const brand = document.querySelector('.brand');


    function appplySaveSettings(){ // Função irá aplicar as configurações salvas no localStorage
        const isActive = localStorage.getItem('isActive') === 'true'; // Vai recuperar o valor do 'isActive' do localStorage e compara com 'true
        const color = localStorage.getItem('color') || '#FFFFFF'; // Recupera o valor de 'color' do localStorage ou usa '#FFFFFF' se não encontrar

        if (isActive) { // Se o 'isActive' for true, vai adicionar a classe 'active' aos elementos
            header.classList.add('active');
            brand.classList.add('active');
            input.classList.add('active');
        } else { // Se o 'isActive' for false, vai remover a classe 'active' aos elementos
            header.classList.remove('active');
            brand.classList.remove('active');
            input.classList.remove('active');
        }

        input.value = color; // Define o valor do input com a cor recuperada do localStorage
    }

    function activeClass() { // Função para alternar a classe 'active' e salvar a configuração
        const isActive = header.classList.contains('active') || brand.classList.contains('active'); // Aqui será verificado se algum dos elementos Header e Brand possuem a class 'active'

        if (isActive) { // Se 'active' existir, será removido a classe dos elementos
            header.classList.remove('active');
            brand.classList.remove('active');
            input.classList.remove('active');
            input.value = '#FFFFFF';

            localStorage.setItem('isActive', 'false'); // Salva no localStorage
            localStorage.setItem('color', '#FFFFFF');
            console.log('A classe active foi removida')
        } else { // Se 'active' existir, será adicionado a classe dos elementos
            header.classList.add('active');
            brand.classList.add('active');
            input.classList.add('active');
            input.value = '#0A74DA';

            localStorage.setItem('isActive', 'true'); // Salva no localStorage
            localStorage.setItem('color', '#0A74DA');
            console.log('A classe active foi adicionada')
        }
    }

    appplySaveSettings(); // Aplica as configurações salvas quando for carregada a página

    input.addEventListener('click', (e) => {
        e.preventDefault();
        activeClass(); // Após o evento de click, chama a função que vai alternar a classe active
    });
}

escopo(); // Produção desse comportamento foi de 4 horas e 16 minutos - Gabriel de Barros