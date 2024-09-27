package shadowmask;

import java.sql.Connection;
import java.util.Scanner;

public class RodarJogo {
    private static Connection connection;

    public static void main(String[] args) {
        connection = ConexaoBanco.conectar();
        if (connection == null) {
            System.out.println("Jogo encerrado.");
            return;
        }

        System.out.println("Bem-vindo à busca pela Máscara das Sombras!");
        Cenas cenas = new Cenas(connection);
        cenas.exibirCena(); // Inicia na primeira cena

        Scanner scanner = new Scanner(System.in);
        String comando;

        while (true) {
            System.out.print("Digite seu comando: ");
            comando = scanner.nextLine().toLowerCase();
            if (comando.equals("sair")) {
                System.out.println("Jogo encerrado. Até a próxima!");
                break;
            }
            Comandos comandos = new Comandos();
            comandos.processarComando(comando);
        }

        scanner.close();
    }
}
