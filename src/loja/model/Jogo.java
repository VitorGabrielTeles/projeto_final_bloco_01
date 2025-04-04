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
    public String toString() {
        return "ID: " + this.id + " | Nome: " + this.nome + " | Preço: R$ " + String.format("%.2f", this.preco) + " | Gênero: " + this.genero;
    }

	@Override
	public void visualizar() {
		
	}

}