package model;

import java.util.List;

public class ServicosLogica {

    ServicosPersistencia persistencia;
    Produto produto;
    Mapeamentos mapeamentos;

    public ServicosLogica(ServicosPersistencia persistencia) {
        this.persistencia = persistencia;
    }

    public void adicionarProduto(Produto produto) throws ExcecaoErroDePersistencia {
        persistencia.armazenarInformacoesProduto(produto);

    }

    public void removerProduto(Produto produto, Long posicaoProdutoNoAquivo) throws ExcecaoErroDePersistencia {
        persistencia.removerProduto(produto, posicaoProdutoNoAquivo);
    }

    public List<Produto> localizarProduto(String produtoRequisitado, String tagRequisitada) throws ExcecaoErroDePersistencia {
        return persistencia.localizarProduto(produtoRequisitado, tagRequisitada);
    }
}