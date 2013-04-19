package controller;

import view.JanelaPrincipal;
import model.ServicosLogica;
import model.ServicosPersistencia;

public class Programa {

	public static void main(String args[]) {
		JanelaPrincipal jp;
		ServicosLogica logica;
		ServicosPersistencia persistencia;
		
		persistencia = new ServicosPersistencia();
		logica = new ServicosLogica(persistencia);
		jp = new JanelaPrincipal(logica);
		
                System.out.println("Teste");
                
		jp.interaja();
	}
	
}
