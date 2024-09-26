package controler;

import modelo.Cena;
import modelo.Item;

public class ControladorJogo {
    public void iniciarJogo() {
        System.out.println("Bem-vindo ao jogo!");

        Cena primeiraCena = new Cena(1, "Você está no deserto...", "Entrar na fortaleza.");
        System.out.println(primeiraCena.getDescricao());
    }


}
