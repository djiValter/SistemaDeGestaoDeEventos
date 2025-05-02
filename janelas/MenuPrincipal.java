package janelas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {
    private JTextField campoTexto;
    private JLabel campoInfo;
    private JButton botaoEntrar;


    public MenuPrincipal(){
        setTitle("MENU PRINCIPAL");
        setSize(523, 641);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        inicializarComponentes();
        setVisible(true);
    }

    public void inicializarComponentes(){
        campoInfo = criarInfo();
        campoInfo.setBounds(210, 70, 339, 37);
        campoInfo.setText("MENU PRINCIPAL");
        add(campoInfo);

        campoInfo = criarInfo();
        campoInfo.setText("1 - Cadastrar");
        campoInfo.setBounds(100, 176, 339, 37);
        add(campoInfo);

        campoInfo = criarInfo();
        campoInfo.setText("2 - Login");
        campoInfo.setBounds(100, 235, 339, 37);
        add(campoInfo);

        campoInfo = criarInfo();
        campoInfo.setText("0 - Sair");
        campoInfo.setBounds(100, 305, 339, 37);
        add(campoInfo);

        botaoEntrar = criarBotaoEntrar();
        botaoEntrar.setBounds(160, 380, 200, 30);
        add(botaoEntrar);
    }

    private JTextField criarTexto(){
        return new JTextField();
    }

    private JLabel criarInfo(){
        return new JLabel();
    }

    private JButton criarBotaoEntrar() {
        JButton botao = new JButton("ENTRAR");
        botao.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Entrando no sistema...");
            // Aqui você pode abrir uma nova janela, se quiser
        });
        return botao;
    }
}
