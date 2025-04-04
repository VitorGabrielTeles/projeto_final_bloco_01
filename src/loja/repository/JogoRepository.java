package loja.repository;

import loja.model.Jogo;
import java.util.ArrayList;
import java.util.List;

public class JogoRepository implements Repository<Jogo> {
    private List<Jogo> listaJogos = new ArrayList<>();

    @Override
    public void listar() {
        if (listaJogos.isEmpty()) {
            System.out.println("Nenhum jogo disponível.");
        } else {
            for (Jogo j : listaJogos) {
                j.visualizar();
            }
        }
    }

    @Override
    public void adicionar(Jogo jogo) {
        listaJogos.add(jogo);
        System.out.println("Jogo adicionado ao carrinho!");
    }

    @Override
    public void remover(int id) {
        listaJogos.removeIf(j -> j.getId() == id);
        System.out.println("Jogo removido do carrinho!");
    }

    public List<Jogo> getCarrinho() {
        return listaJogos;
    }
    
    public double calcularTotalCompra() {
        double total = 0.0;
        for (Jogo jogo : getCarrinho()) {
            total += jogo.getPreco();
        }
        return total;
    }
}
