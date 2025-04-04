package loja.model;

public class Jogo extends Produto {
    private String genero;

    public Jogo(int id, String nome, double preco, String genero) {
        super(id, nome, preco);
        this.genero = genero;
    }

    // Sobrecarga
    public Jogo(int id, String nome) {
        super(id, nome, 0.0);
        this.genero = "Indefinido";
    }

    @Override
    public void visualizar() {
        System.out.println("ID: " + id + " | Nome: " + nome + " | Preço: R$" + preco + " | Gênero: " + genero);
    }
}