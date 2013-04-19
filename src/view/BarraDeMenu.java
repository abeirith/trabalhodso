package view;

import view.JanelaPrincipal;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class BarraDeMenu extends JMenuBar {

    private static final long serialVersionUID = 1L;
    private JMenuItem inserirProduto;
    private JMenuItem listarProdutos;
    private JMenuItem efetuarVenda;

    public BarraDeMenu(JanelaPrincipal janelaPrincipal) {

        JMenu menu;
        JMenuItem sair;

        menu = new JMenu("Arquivo");

        inserirProduto = new JMenuItem("Inserir produto");
        inserirProduto.setActionCommand(Opcao.INSERIR_PRODUTO.name());
        inserirProduto.addActionListener(janelaPrincipal);
        inserirProduto.setEnabled(true);
        menu.add(inserirProduto);

        listarProdutos = new JMenuItem("Listar produtos");
        listarProdutos.setActionCommand(Opcao.LISTAR_PRODUTOS.name());
        listarProdutos.addActionListener(janelaPrincipal);
        listarProdutos.setEnabled(true);
        menu.add(listarProdutos);

        efetuarVenda = new JMenuItem("Efetuar venda");
        efetuarVenda.setActionCommand(Opcao.EFETUAR_VENDA.name());
        efetuarVenda.addActionListener(janelaPrincipal);
        efetuarVenda.setEnabled(true);
        menu.add(efetuarVenda);

        menu.add(new JSeparator());

        sair = new JMenuItem("Sair");
        sair.setActionCommand(Opcao.SAIR.name());
        sair.addActionListener(janelaPrincipal);
        menu.add(sair);

        add(menu);
    }
}