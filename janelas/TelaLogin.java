package janelas;

import javax.swing.*;

public class TelaLogin extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private JButton botaoEntrar;

    public TelaLogin(){
        setTitle("Login");
        setSize(526, 641);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        JLabel labelUsuario = new JLabel("Usuário:");
        labelUsuario.setBounds(100, 130, 100, 25);
        add(labelUsuario);

        campoUsuario = criarCampoUsuario();
        campoUsuario.setBounds(100, 160, 338, 30);
        add(campoUsuario);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(100, 230, 100, 25);
        add(labelSenha);

        campoSenha = criarCampoSenha();
        campoSenha.setBounds(100, 260, 338, 30);
        add(campoSenha);

        botaoEntrar = criarBotaoEntrar();
        botaoEntrar.setBounds(160, 340, 200, 30);
        add(botaoEntrar);
    }

    private JTextField criarCampoUsuario() {
        return new JTextField();
    }

    private JPasswordField criarCampoSenha() {
        return new JPasswordField();
    }

    private JButton criarBotaoEntrar() {
        JButton botao = new JButton("Entrar");
        botao.addActionListener(e -> {
            String usuario = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());
            System.out.println("Login de: " + usuario);
        });
        return botao;
    }
}
