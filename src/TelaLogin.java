import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaLogin extends JFrame {

    private JLabel labelTitulo;
    private JLabel labelNome;
    private JTextField campoNome;
    private JButton botaoEntrar;

    public TelaLogin(ArrayList<FuncionarioBase> users) {
        super("Sistema de Registro de Ponto");

        this.labelTitulo = new JLabel("Login");
        this.labelNome = new JLabel("Nome:");
        this.campoNome = new JTextField(20);
        this.botaoEntrar = new JButton("Entrar");

        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));
        JPanel painelCampos = new JPanel(new GridLayout(2, 2, 5, 5));
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        botaoEntrar.addActionListener(e -> {
            dispose();

            FuncionarioBase usuarioLogado = null;
            for(FuncionarioBase user : users) {
                if (user.getNome().equals(campoNome.getText())) {
                    usuarioLogado = user;
                }
            }
            if(usuarioLogado != null) {
                ModeloTabelaPontos tabelaPontos = new ModeloTabelaPontos(usuarioLogado.getPontosRegistrados());
                TelaPrincipal telaPrincipal = new TelaPrincipal(usuarioLogado, tabelaPontos, users);
                telaPrincipal.setVisible(true);
            }

        });

        painelCampos.add(this.labelNome);
        painelCampos.add(this.campoNome);

        painelBotoes.add(this.botaoEntrar);

        painelPrincipal.add(this.labelTitulo, BorderLayout.NORTH);
        painelPrincipal.add(painelCampos, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(painelPrincipal);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}