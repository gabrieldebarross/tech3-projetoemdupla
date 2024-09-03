function escopo() {
    const form = document.querySelector('.dataentry');
    const inputEntry = document.querySelector('.input-dataentry')
    const cenaDois = 'Dentro da fortaleza, você chega a um salão empoeirado. O ambiente é iluminado por uma luz fraca que entra por pequenas janelas quebradas. O salão está repleto de LIVROS ANTIGOS e MESA DE ESTUDO, onde papéis antigos estão espalhados. No fundo do salão, um ARMÁRIO DE ARTEFATOS está trancado.';

    form.addEventListener('submit', (e) =>{
        e.preventDefault();
        const valueDigit = inputEntry.value;
        const valueDigitUpper = valueDigit.toUpperCase();
        const comands = ['PORTÃO', 'PORTAO'];
        const contemWord = comands.some(comands => valueDigitUpper.includes(comands));

        const info = document.querySelector('.main_info');
        const paragrafo = document.createElement('p') 
        paragrafo.className = 'text-e'; 
        const span = document.createElement('span'); 
        span.className = 'text-en';
        span.textContent = valueDigit; 
        paragrafo.appendChild(span);  
        info.appendChild(paragrafo);
        inputEntry.value = ' '; 
        
        if(contemWord){
            console.log("Mensagem possui comando");
        } else {
            console.log("Mensagem não possui comando");
        }

        if(contemWord){
            const paragrafo = document.createElement('p') 
            paragrafo.className = 'introducion'; 
            paragrafo.textContent = cenaDois;
            info.appendChild(paragrafo);
        }
    })
}

escopo();