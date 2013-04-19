package model;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Produto;
import model.ExcecaoErroDePersistencia;

public class ServicosPersistencia {

    Produto produto, produtoParaExibicao;
    int posicaoProdutoNaLista;
    Map<String, List<String>> mapeamentoDeTipo;
    Map<String, List<String>> mapeamentoDeMarca;
    Map<String, List<String>> mapeamentoDeTitulo;
    Map<String, Long> mapeamentoProdutoPosicao;

    public ServicosPersistencia() {
        this.posicaoProdutoNaLista = 0;
        this.produtoParaExibicao = null;
        this.mapeamentoDeTipo = new HashMap<String, List<String>>();
        this.mapeamentoDeMarca = new HashMap<String, List<String>>();
        this.mapeamentoDeTitulo = new HashMap<String, List<String>>();
        this.mapeamentoProdutoPosicao = new HashMap<String, Long>();
    }

    public Produto cadastrarProduto(String localArquivoDoProduto) throws ExcecaoErroDePersistencia {
        try {
            File arquivo = new File(localArquivoDoProduto);
            arquivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExcecaoErroDePersistencia("Não foi possível criar o produto.");
        }



        return new Produto(localArquivoDoProduto);
    }

    public void armazenarInformacoesProduto(Produto produto) throws ExcecaoErroDePersistencia {

        RandomAccessFile raf = null;
        Long posicaoNovoProduto;

        try {
            raf = new RandomAccessFile(produto.getlocalNoArquivo(), "rw");

            posicaoNovoProduto = raf.length();
            raf.seek(posicaoNovoProduto);
            raf.writeUTF(produto.getTipo());
            raf.writeUTF(produto.getMarca());
            raf.writeUTF(produto.getTitulo());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ExcecaoErroDePersistencia("Produto " + produto.getlocalNoArquivo() + " não existe!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExcecaoErroDePersistencia("Erro ao armazenar informações do produto " + produto.getlocalNoArquivo());
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ExcecaoErroDePersistencia("Erro.");
                }
            }
        }
    }

    public void removerProduto(Produto produto, Long posicaoProdutoNoAquivo) throws ExcecaoErroDePersistencia {

        RandomAccessFile raf = null;

    }

    public List<Produto> localizarProduto(String produtoRequisitado, String tagRequisitada) throws ExcecaoErroDePersistencia {

        List<String> listaProdutoRequisitado = new ArrayList<String>();
        List<Produto> listaProdutos = new ArrayList<Produto>();

        Produto produto = null;

        return listaProdutos;
    }

    private Produto localizarProdutoNoArquivo(Long posicao) throws ExcecaoErroDePersistencia {
        RandomAccessFile rafExibicao = null;
        produtoParaExibicao = null;

        String tipo;
        String marca;
        String titulo;

        try {

            rafExibicao = new RandomAccessFile(produto.getlocalNoArquivo(), "r");

            try {
                rafExibicao.seek(posicao);
                tipo = rafExibicao.readUTF();
                marca = rafExibicao.readUTF();
                titulo = rafExibicao.readUTF();

                produtoParaExibicao = new Produto(tipo, marca, titulo);

            } catch (EOFException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                throw new ExcecaoErroDePersistencia("Erro ao ler informações do produto " + produto.getlocalNoArquivo());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ExcecaoErroDePersistencia("Produto " + produto.getlocalNoArquivo() + " não existe!");

        } finally {
            if (rafExibicao != null) {
                try {
                    rafExibicao.close();

                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ExcecaoErroDePersistencia("Erro.");
                }
            }
        }

        return produtoParaExibicao;
    }
}
