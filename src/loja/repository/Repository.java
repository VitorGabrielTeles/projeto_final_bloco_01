package loja.repository;

import loja.model.Produto;

public interface Repository<T extends Produto> {
    void listar();
    void adicionar(T item);
    void remover(int id);
}
