/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Produto;
import persistencia.Persistencia;

/**
 *
 * @author beirith
 */
public class Estoque {

    Persistencia persistencia;
    
    public Estoque() {
    }

    public Estoque(Persistencia persistencia) {
                this.persistencia = persistencia;
    }
    

    public void AlterarQuantidadeEmEstoque(Produto produto, int quantidade) {

        produto.setQuantidade(quantidade);
    }

    public int VerificarQuantidadeEmEstoque(Produto produto) {

        return produto.getQuantidade();
    }

    public void registrarProdutoEmArquivo(List<Produto> listaProdutos) {
        persistencia.registrarEmArquivo(listaProdutos);
    }

    public void atualizarEstoque(List<Produto> listaProdutos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Produto> conferirEstoque() {
        return persistencia.abrirArquivo("C:\\DSO\\produtos.txt");
    }
}