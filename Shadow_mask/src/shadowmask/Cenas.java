package shadowmask;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Cenas {
    private Connection connection;
    private int cenaAtual;

    public Cenas(Connection connection) {
        this.connection = connection;
        this.cenaAtual = 1; // Começa na cena 1
    }

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

    public void proximaCena() {
        cenaAtual++;
        exibirCena(); // Exibe a nova cena
    }

    public int getCenaAtual() {
        return cenaAtual;
    }
}
