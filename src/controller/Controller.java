/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Produto;
import model.Estoque;
import java.util.ArrayList;

import model.Persistencia;

/**
 *
 * @author beirith
 */
public class Controller {
    
    Persistencia persistencia;
    ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
    Produto produto;
    Estoque estoque;

    public Controller(Persistencia persistencia) {

        this.persistencia = persistencia;
    }

    public void abrirArquivo(String arquivo) {
        persistencia.abrirArquivo(arquivo);
    }

    public void adicionarProduto(Produto produto) {

        int quantidadeEmEstoque;

// se o produto não existir adiciona-lo... {
        estoque.AlterarQuantidadeEmEstoque(produto, produto.getQuantidade());
// }
// else {
        quantidadeEmEstoque = estoque.VerificarQuantidadeEmEstoque(produto);
        quantidadeEmEstoque += produto.getQuantidade();
        estoque.AlterarQuantidadeEmEstoque(produto, quantidadeEmEstoque);
// }

        listaProdutos.add(produto);
        persistencia.registrarEmArquivo(listaProdutos);
    }

    public void venderProduto(Produto produto, int quantidade) {

        int quantidadeEmEstoque;

        quantidadeEmEstoque = estoque.VerificarQuantidadeEmEstoque(produto);
        quantidadeEmEstoque -= quantidade;
        estoque.AlterarQuantidadeEmEstoque(produto, quantidadeEmEstoque);

// tem que atualizar array list ... listaProdutos.add(produto);

        persistencia.registrarEmArquivo(listaProdutos);

    }

    public void alterarQuantidadeEmEstoque(String descricao, int quantidade) {
    }
    
}