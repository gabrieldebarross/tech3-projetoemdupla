package shadowmask;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Comandos {
    private static Connection connection = ConexaoBanco.conectar();
    private static Cenas cenas = new Cenas(connection); // Cria uma instância da classe Cenas

    // Processa o comando digitado pelo jogador
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
        } else if (comando.equals("restart")) {
            reiniciarJogo();
        } else {
            System.out.println("Comando não reconhecido.");
        }
    }

    // Usar item em uma determinada cena
    private void usarItem(String itemNome) {
        if (itemNome.equals("chave") && cenas.getCenaAtual() == 1) {
            System.out.println("Você usou a chave na fechadura.");
            System.out.println("Você avança para a próxima cena...");
            cenas.proximaCena();
        } else if (itemNome.equals("camelo") && cenas.getCenaAtual() == 2) {
            System.out.println("Você usa o camelo para avançar para a próxima cena...");
            cenas.proximaCena();
        } else if (itemNome.equals("cimitarra") && cenas.getCenaAtual() == 4) {
            System.out.println("Você usou a cimitarra contra os guardiões.");
            System.out.println("Você avança para a próxima cena...");
            cenas.proximaCena();
        } else if (itemNome.equals("chave") && cenas.getCenaAtual() == 5) {
            System.out.println("Você usou a chave para abrir o cofre.");
            System.out.println("Você encontrou a Máscara das Sombras!");
            cenas.proximaCena();
        } else {
            System.out.println("Você não pode usar " + itemNome + " nesta cena.");
        }
    }

    // Exibe a descrição de um item
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

    // Pegar um item
    private void pegarItem(String itemNome) {
        if (itemNome.equals("chave") && cenas.getCenaAtual() == 1) {
            System.out.println("Você pegou a chave e a armazenou no inventário.");
        } else if (itemNome.equals("cimitarra") && cenas.getCenaAtual() == 3) {
            System.out.println("Você pegou a cimitarra.");
        } else {
            System.out.println("Não há " + itemNome + " para pegar nesta cena.");
        }
    }

    // Mostra os itens no inventário
    private void mostrarInventario() {
        System.out.println("Inventário: [Placeholder]");
    }

    // Exibe a lista de comandos disponíveis
    private void exibirHelp() {
        System.out.println("Comandos disponíveis:");
        System.out.println("HELP: exibe o menu de ajuda do jogo");
        System.out.println("USE [ITEM]: interage com o item da cena");
        System.out.println("CHECK [ITEM]: mostra a descrição do objeto na cena");
        System.out.println("GET [ITEM]: Se possível, adiciona o item ao inventário");
        System.out.println("INVENTORY: mostra os itens que estão no inventário");
        System.out.println("RESTART: reinicia o jogo");
    }

    // Reinicia o jogo, voltando à primeira cena
    private void reiniciarJogo() {
        cenas.reiniciarCena(); // Reinicia o jogo
    }
}
