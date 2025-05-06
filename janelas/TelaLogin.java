package janelas;
import servicos.UsuarioServicos;
import modelo.*;
import javax.swing.*;
import java.awt.*;

public class TelaLogin extends JFrame {
    private UsuarioServicos usuarioServicos;
    private JTextField campoEmail;
    private JPasswordField campoSenha;
    private JButton botaoEntrar;
    private Usuario usuario;

    public TelaLogin(UsuarioServicos usuarioServicos){
        this.usuarioServicos = usuarioServicos;
        setTitle("Login");
        setSize(526, 641);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        JLabel labellogin = new JLabel("LOGIN");
        labellogin.setBounds(220, 30, 100, 25);
        labellogin.setForeground(Color.BLUE);
        add(labellogin);


        JLabel labelUsuario = new JLabel("Usuário:");
        labelUsuario.setBounds(100, 130, 100, 25);
        add(labelUsuario);

        campoEmail = criarCampoEmail();
        campoEmail.setBounds(100, 160, 338, 30);
        add(campoEmail);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(100, 230, 100, 25);
        add(labelSenha);

        campoSenha = criarCampoSenha();
        campoSenha.setBounds(100, 260, 338, 30);
        add(campoSenha);

        botaoEntrar = criarBotaoEntrar(usuarioServicos);
        botaoEntrar.setBounds(160, 340, 200, 30);
        add(botaoEntrar);
    }

    private JTextField criarCampoEmail() {
        return new JTextField();
    }

    private JPasswordField criarCampoSenha() {
        return new JPasswordField();
    }

    private JButton criarBotaoEntrar(UsuarioServicos usuarioServicos) {
        JButton botao = new JButton("Entrar");
        botao.addActionListener(e -> {
            String email = campoEmail.getText();
            String senha = new String(campoSenha.getPassword());

            Usuario usuario = usuarioServicos.login(email, senha);

            if (usuario != null) {
                JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
                dispose(); // Fecha a tela de login

                if (usuario.getTipo() == TipoUsuario.PROMOTOR) {
                    new TelaPromotor(usuario); // Exibe interface para promotor
                } else {
                    new TelaUsuario(usuario); // Exibe interface para usuário comum
                }
            } else {
                JOptionPane.showMessageDialog(this, "Email ou senha inválidos.");
                new MenuPrincipal(); // Se falhar, retorna ao menu principal
                dispose();
            }
        });
        return botao;
    }

}
