package janelas;

import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private JButton botaoEntrar;

    public TelaCadastro(){
        setTitle("Login");
        setSize(526, 641);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        JLabel labelCadastro = new JLabel("CADASTRO:");
        labelCadastro.setBounds(220, 30, 100, 25);
        labelCadastro.setForeground(Color.BLUE);
        add(labelCadastro);

        JLabel labelUsuario = new JLabel("Nome:");
        labelUsuario.setBounds(100, 130, 100, 25);
        add(labelUsuario);

        campoUsuario = criarCampoUsuario();
        campoUsuario.setBounds(100, 160, 338, 30);
        add(campoUsuario);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(100, 230, 100, 25);
        add(labelEmail);

        campoUsuario = criarCampoUsuario();
        campoUsuario.setBounds(100, 260, 338, 30);
        add(campoUsuario);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(100, 320, 100, 25);
        add(labelSenha);

        campoSenha = criarCampoSenha();
        campoSenha.setBounds(100, 350, 338, 30);
        add(campoSenha);

        botaoEntrar = criarBotaoEntrar();
        botaoEntrar.setBounds(160, 420, 200, 30);
        add(botaoEntrar);
    }

    private JTextField criarCampoUsuario() {
        return new JTextField();
    }

    private JPasswordField criarCampoSenha() {
        return new JPasswordField();
    }

    //Em construção
    private JButton criarBotaoEntrar() {
        JButton botao = new JButton("Cadastrar");
        botao.addActionListener(e -> {
            String nome = campoUsuario.getText();
            String email = campoUsuario.getText();
            String senha = new String(campoSenha.getPassword());
            System.out.println("Login de: " + nome);
        });
        return botao;
    }
}
