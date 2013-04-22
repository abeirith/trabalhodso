package controller;

import view.JanelaPrincipal;
import persistencia.Persistencia;

public class Programa {

    public static void main(String args[]) {
        JanelaPrincipal jp;
        Persistencia persistencia;
        Controller logica;
        Estoque estoque;

        persistencia = new Persistencia();
        estoque = new Estoque(persistencia);
        logica = new Controller(estoque);
        jp = new JanelaPrincipal(logica);

        jp.interaja();
    }
}
