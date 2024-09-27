package shadowmask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Comandos {
    private Connection conexao;

    public Comandos(Connection conexao) {
        this.conexao = conexao;
    }

    // Exibe a ajuda do jogo
    public void ajuda() {
        System.out.println("Comandos disponíveis:");
        System.out.println("HELP: Exibe este menu de ajuda.");
        System.out.println("USE [ITEM]: Interage com o item da cena.");
        System.out.println("CHECK [ITEM]: Mostra a descrição do item.");
        System.out.println("GET [ITEM]: Adiciona o item ao inventário.");
        System.out.println("INVENTORY: Exibe os itens no seu inventário.");
        System.out.println("USE [INVENTORY_ITEM] WITH [SCENE_ITEM]: Usa um item do inventário com um item na cena.");
        System.out.println("SAVE: Salva o jogo.");
        System.out.println("LOAD: Carrega um jogo salvo.");
        System.out.println("RESTART: Reinicia o jogo.");
    }

    // Exibe a descrição de um item
    public void checarItem(String nomeItem) {
        try {
            String sql = "SELECT descricao FROM itens WHERE nome = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeItem);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("descricao"));
            } else {
                System.out.println("Item não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Adiciona um item ao inventário
    public void pegarItem(String nomeItem) {
        try {
            String sql = "SELECT * FROM itens WHERE nome = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nomeItem);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Você pegou o item: " + nomeItem);
                // Aqui você pode adicionar lógica para armazenar o item no inventário
            } else {
                System.out.println("Item não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Exibe os itens no inventário
    public void mostrarInventario() {
        try {
            String sql = "SELECT nome FROM inventario";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("Itens no inventário:");
            while (rs.next()) {
                System.out.println(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Usa um item do inventário com um item na cena
    public void usarItemCom(String itemInventario, String itemCena) {
        try {
            // Verifica se o item está no inventário
            String sqlInventario = "SELECT * FROM inventario WHERE nome = ?";
            PreparedStatement stmtInventario = conexao.prepareStatement(sqlInventario);
            stmtInventario.setString(1, itemInventario);
            ResultSet rsInventario = stmtInventario.executeQuery();

            if (rsInventario.next()) {
                System.out.println("Você usou o item " + itemInventario + " com " + itemCena);
                // Aqui você pode adicionar lógica para remover o item do inventário ou continuar a história
            } else {
                System.out.println("Item " + itemInventario + " não encontrado no inventário.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
