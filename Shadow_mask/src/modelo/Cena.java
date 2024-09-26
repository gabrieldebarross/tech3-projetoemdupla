package modelo;

public class Cena {
    private int id;
    private String descricao;
    private String objetivo;

    public Cena(int id, String descricao, String objetivo) {
        this.id = id;
        this.descricao = descricao;
        this.objetivo = objetivo;
    }

    public String getDescricao() {
        return descricao;
    }
}
