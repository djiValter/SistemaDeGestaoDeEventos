package janelas;
import modelo.TipoUsuario;
import servicos.UsuarioServicos;
import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {
    private UsuarioServicos usuarioServicos;
    private JTextField campoNome;
    private JTextField campoEmail;
    private JPasswordField campoSenha;
    private JButton botaoEntrar;

    public TelaCadastro(UsuarioServicos usuarioServicos){
        this.usuarioServicos = usuarioServicos;
        setTitle("Tela de Cadastro");
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

        campoNome = criarCampoUsuario();
        campoNome.setBounds(100, 160, 338, 30);
        add(campoNome);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(100, 230, 100, 25);
        add(labelEmail);

        campoEmail = criarCampoUsuario();
        campoEmail.setBounds(100, 260, 338, 30);
        add(campoEmail);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(100, 320, 100, 25);
        add(labelSenha);

        campoSenha = criarCampoSenha();
        campoSenha.setBounds(100, 350, 338, 30);
        add(campoSenha);

        botaoEntrar = criarBotaoCadastrar();
        botaoEntrar.setBounds(160, 420, 200, 30);
        add(botaoEntrar);
    }

    private JTextField criarCampoUsuario() {
        return new JTextField();
    }

    private JPasswordField criarCampoSenha() {
        return new JPasswordField();
    }


    private JButton criarBotaoCadastrar() {
        JButton botao = new JButton("Cadastrar");

        botao.addActionListener(e -> {
            String nome = campoNome.getText();
            String email = campoEmail.getText();
            String senha = new String(campoSenha.getPassword());

            if (!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty()) {
                String[] opcoes = {"Usuário", "Promotor"};
                int escolha = JOptionPane.showOptionDialog(
                        this,
                        "Selecione o tipo de usuário:",
                        "Tipo de Cadastro",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]
                );

                TipoUsuario tipo = (escolha == 1) ? TipoUsuario.PROMOTOR : TipoUsuario.USUARIO;

                try {
                    usuarioServicos.cadastrarUsuario(nome, email, senha, tipo);
                    JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso como " + tipo + "!");
                    dispose(); // Fecha a janela após o cadastro
                    new MenuPrincipal();
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.");
            }
        });

        return botao;
    }
}
