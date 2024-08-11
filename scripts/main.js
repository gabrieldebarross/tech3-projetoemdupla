function escopo() {
    const header = document.querySelector('.header');
    const input = document.querySelector('#stylecolor');
    input.readOnly = true; // Deixei como somente para leitura para o usuário não poder alterar o valor do input
    const brand = document.querySelector('.brand');
    const footer = document.querySelector('.footer');
    const savebutton = document.querySelector('.save')


    function appplySaveSettings() { // Função irá aplicar as configurações salvas no localStorage
        const isActive = localStorage.getItem('isActive') === 'true'; // Vai recuperar o valor do 'isActive' do localStorage e compara com 'true
        const color = localStorage.getItem('color') || '#FFFFFF'; // Recupera o valor de 'color' do localStorage ou usa '#FFFFFF' se não encontrar

        if (isActive) { // Se o 'isActive' for true, vai adicionar a classe 'active' aos elementos
            header.classList.add('active');
            brand.classList.add('active');
            input.classList.add('active');
            footer.classList.add('active');
            savebutton.classList.add('active');
        } else { // Se o 'isActive' for false, vai remover a classe 'active' aos elementos
            header.classList.remove('active');
            brand.classList.remove('active');
            input.classList.remove('active');
            footer.classList.remove('active');
            savebutton.classList.remove('active');
        }

        input.value = color; // Define o valor do input com a cor recuperada do localStorage
    }

    function activeClass() { // Função para alternar a classe 'active' e salvar a configuração
        const isActive = header.classList.contains('active') || brand.classList.contains('active'); // Aqui será verificado se algum dos elementos Header e Brand possuem a class 'active'

        if (isActive) { // Se 'active' existir, será removido a classe dos elementos
            header.classList.remove('active');
            brand.classList.remove('active');
            input.classList.remove('active');
            footer.classList.remove('active');
            savebutton.classList.remove('active');
            input.value = '#FFFFFF';

            localStorage.setItem('isActive', 'false'); // Salva no localStorage
            localStorage.setItem('color', '#FFFFFF');
            console.log('A classe active foi removida')
        } else { // Se 'active' existir, será adicionado a classe dos elementos
            header.classList.add('active');
            brand.classList.add('active');
            input.classList.add('active');
            footer.classList.add('active');
            savebutton.classList.add('active');
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

function getdatainput() {
    const form = document.querySelector('.dataentry');
    const input = document.querySelector('#input-dataentry');

    form.addEventListener('submit', (e) => { // Função para prevenir o evento padrao
        e.preventDefault();
        console.log('Evento submit prevenido, input.value default.')

        const info = document.querySelector('.main_info'); // Seleciona o container onde vai ser adiciona o valor digitado pelo usuario dentro do input
        const paragrafo = document.createElement('p') // Cria paragrafo
        paragrafo.className = 'text-e'; // Adiciona uma tag ao p criado

        const span = document.createElement('span'); // Cria span
        span.className = 'text-en'; // Adicionei uma classe para o span
        span.textContent = input.value; // Peguei o valor enviado pelo usuário e adicionei dentro do span como conteudo

        paragrafo.appendChild(span); // Adiciona o span dentro do p 

        info.appendChild(paragrafo); // Adiciona o p dentro do container info

        input.value = ''; // Zero do valor do input 
    });
}

getdatainput(); // Produção desse comportamento e toda a estrutura do front foi de 3 horas e 48 minutos - Gabriel de Barros