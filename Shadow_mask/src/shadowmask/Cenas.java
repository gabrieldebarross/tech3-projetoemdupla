package shadowmask;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Cenas {
    private Connection connection;
    private int cenaAtual;

    public Cenas(Connection connection) {
        this.connection = connection;
        this.cenaAtual = 1;
    }

    // Método para exibir a cena atual
    public void exibirCena() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT descricao FROM cenas WHERE id = " + cenaAtual);
            if (rs.next()) {
                System.out.println(rs.getString("descricao"));
            } else {
                System.out.println("Cena não encontrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para avançar para a próxima cena
    public void proximaCena() {
        if (cenaAtual < 5) {
            cenaAtual++;
            exibirCena(); // Exibe a nova cena
        } else {
            System.out.println("Você completou o jogo! Parabéns!");
        }
    }


    public int getCenaAtual() {
        return cenaAtual;
    }

    // Reinicia o jogo a partir da primeira cena
    public void reiniciarCena() {
        cenaAtual = 1;
        exibirCena();
    }
}
