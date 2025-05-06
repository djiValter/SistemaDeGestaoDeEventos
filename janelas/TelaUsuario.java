package janelas;
import modelo.Usuario;
import javax.swing.*;
import java.awt.*;

public class TelaUsuario extends JFrame {
    private JTextField campo;
    private JButton botaoEntrar;

    public TelaUsuario(Usuario usuario){
        setTitle("Tela do Usuário");
        setSize(526, 641);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        JLabel labelCadastro = new JLabel("TELA USUÁRIO");
        labelCadastro.setBounds(220, 30, 100, 25);
        labelCadastro.setForeground(Color.BLUE);
        add(labelCadastro);

        JLabel criarEvento = new JLabel("1 - Ver lista de Eventos Disponíveis");
        criarEvento.setBounds(100, 138, 327, 37);
        add(criarEvento);

        JLabel editarEvento = new JLabel("2 - Meus Eventos");
        editarEvento.setBounds(100, 205, 327, 37);
        add(editarEvento);

        JLabel removerEvento = new JLabel("3 - Confirmar presença ");
        removerEvento.setBounds(100, 273, 327, 37);
        add(removerEvento);

        JLabel meusEventos = new JLabel("0 - Sair");
        meusEventos.setBounds(100, 332, 327, 37);
        add(meusEventos);

        campo = criarCampo();
        campo.setBounds(100, 481, 132, 25);
        add(campo);

        botaoEntrar = criarBotaoEntrar();
        botaoEntrar.setBounds(259, 481, 132, 25);
        add(botaoEntrar);
    }

    private JTextField criarCampo() {
        return new JTextField();
    }

    //Em construção
    private JButton criarBotaoEntrar() {
        JButton botao = new JButton("Entrar");
        botao.addActionListener(e -> {
            System.out.println("Login de: ");
        });
        return botao;
    }
}
