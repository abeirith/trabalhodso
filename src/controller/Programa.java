package controller;

import view.JanelaPrincipal;
import model.Persistencia;

public class Programa {

    public static void main(String args[]) {
        JanelaPrincipal jp;
        Persistencia persistencia;
        Controller logica;

        persistencia = new Persistencia();
        logica = new Controller(persistencia);
        jp = new JanelaPrincipal(logica);

        jp.interaja();
    }
}
