package janelas;

import javax.swing.*;
import java.awt.*;

public class TelaPromotor extends JFrame {
    private JTextField campo;
    private JButton botaoEntrar;

    public TelaPromotor(){
        setTitle("Login");
        setSize(526, 641);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        JLabel labelCadastro = new JLabel("CADASTRO");
        labelCadastro.setBounds(220, 30, 100, 25);
        labelCadastro.setForeground(Color.BLUE);
        add(labelCadastro);

        JLabel criarEvento = new JLabel("Criar Evento");
        criarEvento.setBounds(100, 138, 327, 37);
        add(criarEvento);

        JLabel editarEvento = new JLabel("Editar Evento");
        editarEvento.setBounds(100, 209, 327, 37);
        add(editarEvento);

        JLabel removerEvento = new JLabel("Remover Evento");
        removerEvento.setBounds(100, 273, 327, 37);
        add(removerEvento);

        JLabel meusEventos = new JLabel("Meus Eventos");
        meusEventos.setBounds(100, 332, 327, 37);
        add(meusEventos);

        JLabel sair = new JLabel("Sair");
        sair.setBounds(100, 396, 327, 37);
        add(sair);

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
        JButton botao = new JButton("Cadastrar");
        botao.addActionListener(e -> {
            System.out.println("Login de: ");
        });
        return botao;
    }
}
