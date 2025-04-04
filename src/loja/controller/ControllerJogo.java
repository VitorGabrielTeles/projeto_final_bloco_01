package loja.controller;

import loja.model.Jogo;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class ControllerJogo {

    private List<Jogo> jogosDisponiveis = new ArrayList<>();
    private List<Jogo> carrinho = new ArrayList<>();

    public ControllerJogo() {
        // Jogos pré-definidos
        jogosDisponiveis.add(new Jogo(1, "FIFA 23", 199.90, "Esporte"));
        jogosDisponiveis.add(new Jogo(2, "The Witcher 3", 99.90, "RPG"));
        jogosDisponiveis.add(new Jogo(3, "Minecraft", 79.90, "Aventura"));
        jogosDisponiveis.add(new Jogo(4, "GTA V", 89.99, "Ação"));
    }

    public void listarJogos() {
        for (Jogo j : jogosDisponiveis) {
            System.out.println(j);
        }
    }

    public void adicionarAoCarrinho(int id) {
        try {
            Jogo jogo = buscarJogoPorId(id);
            carrinho.add(jogo);
            System.out.println("Jogo adicionado ao carrinho!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar: " + e.getMessage());
        }
    }

    public void removerDoCarrinho(int id) {
        try {
            Jogo jogo = buscarNoCarrinhoPorId(id);
            carrinho.remove(jogo);
            System.out.println("Jogo removido do carrinho.");
        } catch (Exception e) {
            System.out.println("Erro ao remover: " + e.getMessage());
        }
    }

    public void visualizarCarrinho() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho está vazio.");
        } else {
            for (Jogo j : carrinho) {
                System.out.println(j);
            }
        }
    }

    public void finalizarCompra() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho está vazio. Adicione jogos antes de finalizar.");
            return;
        }

        double total = carrinho.stream().mapToDouble(Jogo::getPreco).sum();
        System.out.printf("Compra finalizada! Valor total: R$ %.2f%n", total);
        carrinho.clear();
    }

    private Jogo buscarJogoPorId(int id) throws Exception {
        return jogosDisponiveis.stream()
            .filter(j -> j.getId() == id)
            .findFirst()
            .orElseThrow(() -> new Exception("Jogo com ID " + id + " não encontrado."));
    }

    private Jogo buscarNoCarrinhoPorId(int id) throws Exception {
        return carrinho.stream()
            .filter(j -> j.getId() == id)
            .findFirst()
            .orElseThrow(() -> new Exception("Jogo com ID " + id + " não está no carrinho."));
    }

    public double getTotal() {
        return carrinho.stream().mapToDouble(Jogo::getPreco).sum();
    }
}