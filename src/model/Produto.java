package model;

public class Produto implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    String tipo, marca, titulo;
    int quantidade;
    int valor;

    public Produto(String tipo, String marca, String titulo, int quantidade, int valor) {
        this.tipo = tipo;
        this.marca = marca;
        this.titulo = titulo;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public int getValor() {
        return valor;
    }    
}