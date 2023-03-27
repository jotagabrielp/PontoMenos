import javax.swing.*;
import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;

public class TelaPrincipal extends JFrame {

    private JLabel labelTitulo;
    private JLabel labelNome;
    private JLabel labelTotalHorasTrabalhadas;
    private JLabel campoNome;
    private JTable tabelaPontos;
    private JButton botaoRegistrarPonto;
    private JButton botaoSair;
    private JMenuBar menuBar;
    private JMenu menuPontos;
    private ModeloTabelaPontos modeloTabelaPontos;

    public TelaPrincipal(FuncionarioBase user, ModeloTabelaPontos modeloTabelaPontos, ArrayList<FuncionarioBase> users) {
        super("Sistema de Registro de Ponto");
        user.adicionarObservador(modeloTabelaPontos);

        this.labelTitulo = new JLabel("Registro de Ponto");
        this.labelNome = new JLabel("Nome:");
        this.labelTotalHorasTrabalhadas = new JLabel("Total de horas trabalhadas:");
        this.campoNome = new JLabel(user.getNome());
        this.tabelaPontos = new JTable(modeloTabelaPontos);
        this.botaoRegistrarPonto = new JButton("Registrar ponto");
        this.botaoSair = new JButton("Sair");

        // Configura a tabela de pontos
        this.modeloTabelaPontos = modeloTabelaPontos;
        this.tabelaPontos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(this.tabelaPontos);

        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        JPanel painelCampos = new JPanel(new GridLayout(3, 2, 5, 5));
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JPanel painelTabela = new JPanel(new BorderLayout(10, 10));

        botaoRegistrarPonto.addActionListener(e -> {
            user.baterPonto();
        });
        botaoSair.addActionListener(e -> {
            TelaLogin telaLogin = new TelaLogin(users);
            telaLogin.setVisible(true);
            dispose();
        });

        painelCampos.add(this.labelNome);
        painelCampos.add(this.campoNome);
        painelCampos.add(new JLabel(""));

        painelTabela.add(scrollPane, BorderLayout.CENTER);
        painelTabela.add(this.labelTotalHorasTrabalhadas, BorderLayout.SOUTH);

        painelBotoes.add(this.botaoRegistrarPonto);
        painelBotoes.add(this.botaoSair);

        painelPrincipal.add(this.labelTitulo, BorderLayout.NORTH);
        painelPrincipal.add(painelCampos, BorderLayout.WEST);
        painelPrincipal.add(painelTabela, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        this.menuBar = new JMenuBar();
        this.menuPontos = new JMenu("Pontos");
        JMenuItem menuVisualizarPontos = new JMenuItem("Visualizar pontos");
        this.menuPontos.add(menuVisualizarPontos);
        this.menuBar.add(this.menuPontos);
        this.setJMenuBar(this.menuBar);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(painelPrincipal);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
