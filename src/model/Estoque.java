/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author beirith
 */
public class Estoque {

    public Estoque() {
    }

    public void AlterarQuantidadeEmEstoque(Produto produto, int quantidade) {

        produto.setQuantidade(quantidade);
    }

    public int VerificarQuantidadeEmEstoque(Produto produto) {

        return produto.getQuantidade();
    }
}