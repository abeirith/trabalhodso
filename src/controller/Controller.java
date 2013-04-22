/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author beirith
 */
public class Controller {

    Produto produto;
    Estoque servicoEstoque;

    public Controller(Estoque estoque) {

        this.servicoEstoque = estoque;
    }

    public void adicionarProduto(Produto produto) {


        List<Produto> listaProdutos = servicoEstoque.conferirEstoque();

        if (listaProdutos == null) {
            listaProdutos = new ArrayList<Produto>();
            listaProdutos.add(produto);
        } else {

            boolean produtoEncontrado = false;
            for (Produto produtoExistente : listaProdutos) {
                int posicao = 0;
                if (produtoExistente.getMarca().equals(produto.getMarca())) {
                    int quantidadeAtualizada = produtoExistente.getQuantidade() + produto.getQuantidade();
                    produtoExistente.setQuantidade(quantidadeAtualizada);
                    listaProdutos.set(posicao, produtoExistente);
                    produtoEncontrado = true;
                    break;
                }
                posicao++;

            }
            if (produtoEncontrado == false) {
                listaProdutos.add(produto);
            }

        }

        servicoEstoque.atualizarEstoque(listaProdutos);
        servicoEstoque.registrarProdutoEmArquivo(listaProdutos);
    }

    public void venderProduto(Produto produto, int quantidade) throws Exception {

        List<Produto> listaProdutos = servicoEstoque.conferirEstoque();
 
        if (listaProdutos != null) {
            
             for (Produto produtoExistente : listaProdutos) {
                int posicao = 0;
                if (produtoExistente.getMarca().equals(produto.getMarca())) {
                    
                    if(quantidade > produtoExistente.getQuantidade() ){
                        throw  new Exception("Quantidade em estoque insuficiente");
                    }else{
                    int quantidadeAtualizada = produtoExistente.getQuantidade() - quantidade;
                    produtoExistente.setQuantidade(quantidadeAtualizada);
                    listaProdutos.set(posicao, produtoExistente);
                    posicao++;
                    break;
                    }
                }
                else{
                    throw new Exception("Produto Inexistente");
                }

            }
        }
        servicoEstoque.atualizarEstoque(listaProdutos);

    }
}