package model;

public class Produto {

	String tipo;
	String marca;
	String titulo;
        String localNoArquivo;
	
	public Produto(String tipo,  String marca, String titulo ) {
		this.tipo = tipo;
		this.marca = marca;
		this.titulo = titulo;	
	}
        
        public Produto(String localNoArquivo ) {
		this.localNoArquivo = localNoArquivo;
	}
        
        public void setTipo(String tipo){
            this.tipo = tipo;
        }
        
        public void setMarca(String marca){
            this.marca = marca;
        }
        
        public void setTitulo(String titulo){
            this.titulo = titulo;
        }
        
        public String getTipo(){
            return tipo;
        }
        
        public String getMarca(){
            return marca;
        }
        
        public String getTitulo(){
            return titulo;
        }

        public String getlocalNoArquivo(){
            return localNoArquivo;
        }
}