package shadowmask;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Comandos {
    private static Connection connection = ConexaoBanco.conectar();
    private static Cenas cenas = new Cenas(connection); // Cria uma instância da classe Cenas

    public void processarComando(String comando) {
        if (comando.equals("help")) {
            exibirHelp();
        } else if (comando.startsWith("use ")) {
            String itemNome = comando.split(" ")[1];
            usarItem(itemNome);
        } else if (comando.startsWith("check ")) {
            String itemNome = comando.split(" ")[1];
            examinarItem(itemNome);
        } else if (comando.startsWith("get ")) {
            String itemNome = comando.split(" ")[1];
            pegarItem(itemNome);
        } else if (comando.equals("inventory")) {
            mostrarInventario();
        } else if (comando.startsWith("use ") && comando.contains(" with ")) {
            String[] partes = comando.split(" with ");
            String itemInventario = partes[0].substring(4); // remove "use "
            String itemCena = partes[1];
            usarComandoCombinado(itemInventario, itemCena);
        } else {
            System.out.println("Comando não reconhecido.");
        }
    }

    private void usarItem(String itemNome) {
        if (itemNome.equals("chave") && cenas.getCenaAtual() == 1) {
            System.out.println("Você usou a chave na fechadura.");
            System.out.println("Você avança para a próxima cena...");
            cenas.proximaCena(); // Chama o método para ir para a próxima cena
        } else if (itemNome.equals("cimitarra") && cenas.getCenaAtual() == 4) {
            System.out.println("Você usou a cimitarra contra os guardiões.");
            System.out.println("Você avança para a próxima cena...");
            cenas.proximaCena();
        } else {
            System.out.println("Você não pode usar " + itemNome + " nesta cena.");
        }
    }

    private void exibirHelp() {
        System.out.println("Comandos disponíveis:");
        System.out.println("HELP: exibe o menu de ajuda do jogo");
        System.out.println("USE [ITEM]: interage com o item da cena");
        System.out.println("CHECK [ITEM]: mostra a descrição do objeto na cena");
        System.out.println("GET [ITEM]: Se possível, adiciona o item ao inventário");
        System.out.println("INVENTORY: mostra os itens que estão no inventário");
        System.out.println("USE [INVENTORY_ITEM] WITH [SCENE_ITEM]: realiza a ação utilizando um item do inventário com um item da cena");
        System.out.println("SAVE: salva o jogo");
        System.out.println("LOAD: carrega um jogo salvo");
        System.out.println("RESTART: reinicia o jogo");
    }

    private void examinarItem(String itemNome) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT descricao FROM itens WHERE nome = '" + itemNome + "'");
            if (rs.next()) {
                System.out.println(rs.getString("descricao"));
            } else {
                System.out.println("Item não encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pegarItem(String itemNome) {
        System.out.println("Pegando " + itemNome);
        // Lógica para pegar o item deve ser implementada aqui.
    }

    private void mostrarInventario() {
        System.out.println("Itens no inventário:");
        // Exiba os itens armazenados
    }

    private void usarComandoCombinado(String itemInventario, String itemCena) {
        System.out.println("Usando " + itemInventario + " com " + itemCena);
        // Implementar lógica para usar um item do inventário com um item da cena
    }
}
