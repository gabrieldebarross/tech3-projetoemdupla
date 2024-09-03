<!DOCTYPE html>
<html lang="pt-br">

<head>
    <!-- Créditos:
    Image usada como favicon: https://www.flaticon.com/free-icons/ui" title="ui icons">Ui icons created by Rakib Hassan Rahim - Flaticon 
    -->

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../styles/style.css">
    <link rel="shortcut icon" href="../images/favicon.png" type="image/x-icon">
    <script src="../scripts/main.js" defer></script>
    <title>TextAdventure</title>
</head>

<body>
<?php 
    echo '<header class="header">
    <div class="width">
    <div class="container">
        <a href="#" class="brand">TextAdventure</a>
        <nav class="navbar">
            <ul>
                <li><a class="navbar-link save" href="#">Salvar</a></li>
                <li><a class="navbar-link load" href="#">Carregar sessão</a></li>
                <li><input type="color" id="stylecolor" value="#FFFFFF" readonly></li>
            </ul>
        </nav>
    </div>
    </div>
</header>';
    echo '<main class="main">
    <div class="width_main">
        <div class="main_info">
            <p class="introducion">Você se aventura na floresta enigmática em busca de um artefato lendário perdido há séculos. À medida que avança, encontra uma bifurcação: uma trilha à esquerda leva a uma pequena casa onde um sábio eremita pode oferecer um valioso mapa; a trilha à direita conduz a uma caverna obscura onde, ao acender uma tocha, você descobre um baú escondido. Sua escolha determinará se você encontrará a saída da floresta com riqueza e sabedoria, ou se sua jornada terminará em frustração.
            </p>
        </div>
    </div>
</main>';
    echo '<footer class="footer">
    <form action="" class="dataentry container" autocomplete="off">
        <input type="text" id="input-dataentry" name="Input entrada de dados" class="input-dataentry" placeholder="Mensagem TextAdventure">
        <button type="submit" class="submit"></button>
    </form>
</footer>';
?>

</body>

</html>