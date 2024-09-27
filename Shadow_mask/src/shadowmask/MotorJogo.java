package shadowmask;

import java.sql.Connection;
import java.util.Scanner;

public class MotorJogo {
    public static void main(String[] args) {
        // Conectar ao banco de dados
        Connection conexao = ConexaoBanco.conectar();
        if (conexao == null) {
            System.out.println("Erro ao conectar ao banco de dados. Jogo encerrado.");
            return;
        }

        // Criar um objeto para lidar com comandos
        Comandos comandos = new Comandos(conexao);

        // Criar o scanner para receber comandos do usuário
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Shadowmask!");

        boolean jogando = true;
        while (jogando) {
            System.out.print("Digite um comando: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("help")) {
                comandos.ajuda();
            } else if (input.startsWith("check")) {
                String[] partes = input.split(" ");
                if (partes.length == 2) {
                    comandos.checarItem(partes[1]);
                } else {
                    System.out.println("Comando inválido.");
                }
            } else if (input.startsWith("get")) {
                String[] partes = input.split(" ");
                if (partes.length == 2) {
                    comandos.pegarItem(partes[1]);
                } else {
                    System.out.println("Comando inválido.");
                }
            } else if (input.equals("inventory")) {
                comandos.mostrarInventario();
            } else if (input.startsWith("use")) {
                String[] partes = input.split(" with ");
                if (partes.length == 2) {
                    comandos.usarItemCom(partes[0].replace("use ", ""), partes[1]);
                } else {
                    System.out.println("Comando inválido.");
                }
            } else if (input.equals("save")) {
                System.out.println("Jogo salvo! (placeholder)");
            } else if (input.equals("load")) {
                System.out.println("Jogo carregado! (placeholder)");
            } else if (input.equals("restart")) {
                System.out.println("Reiniciando o jogo...");
                jogando = false;
            } else {
                System.out.println("Comando desconhecido.");
            }
        }


        scanner.close();
    }
}
