package view;

import java.awt.Dimension;
import javax.swing.JFrame;

import controller.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class JanelaPrincipal extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    Controller servicosLogica;
    BarraDeMenu barraDeMenu;

    public JanelaPrincipal(Controller logica) {
        super("SisCommerce");
        this.servicosLogica = logica;
        barraDeMenu = new BarraDeMenu(this);
        setResizable(false);
        setJMenuBar(barraDeMenu);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();
        setLocationRelativeTo(null);
    }

    public void interaja() {
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ev) {

        Opcao opcao = Opcao.valueOf(ev.getActionCommand());

        switch (opcao) {
            case INSERIR_PRODUTO:
                JanelaCadastrarProduto janela1 = new JanelaCadastrarProduto(servicosLogica, this);
                janela1.interaja();
                break;
            case LISTAR_PRODUTOS:
                JanelaListarProdutos janela2 = new JanelaListarProdutos(servicosLogica, this);
                janela2.interaja();
                break;
            case EFETUAR_VENDA:
                JanelaEfetuarVenda janela3 = new JanelaEfetuarVenda(servicosLogica, this);
                janela3.interaja();
                break;
            case SAIR:
                System.exit(0);
                break;

        }
        validate();
        pack();
    }
}