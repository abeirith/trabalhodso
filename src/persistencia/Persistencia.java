package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class Persistencia {

    public void registrarEmArquivo(List<Produto> listaProdutos) {

        serializarListaProdutos(listaProdutos, "C:\\DSO\\produtos.txt");

    }

    public ArrayList<Produto> abrirArquivo(String arquivo) {
         ArrayList<Produto> listaProdutos = deserializarListaProdutos(arquivo);
         return listaProdutos;
    }

    private static void serializarListaProdutos(List<Produto> listaProdutos, String arquivo) {

        FileOutputStream arq = null;
        ObjectOutputStream out = null;

        try {
//arquivo no qual os dados vao ser gravados
            arq = new FileOutputStream(arquivo);

//objeto que vai escrever os dados
            out = new ObjectOutputStream(arq);

//escreve todos os dados
            out.writeObject(listaProdutos);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                arq.close();
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static ArrayList<Produto> deserializarListaProdutos(String arquivo) {
        FileInputStream arqLeitura = null;
        ObjectInputStream in = null;
        ArrayList<Produto> lista = null;
        try {

            arqLeitura = new FileInputStream(arquivo);
            in = new ObjectInputStream(arqLeitura);
            lista = (ArrayList<Produto>) in.readObject();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                arqLeitura.close();
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return lista;
    }
}