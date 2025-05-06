package janelas;
import modelo.Usuario;
import servicos.UsuarioServicos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Scanner;



public class MenuPrincipal extends JFrame {
    private JTextField campoTexto;
    private JLabel campoInfo;
    private JButton botaoEntrar;
    private static String numeroDigitado;
    private static int escolha;


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

        campoTexto = entrarTexto();
        campoTexto.setBounds(100, 380, 100, 25);
        add(campoTexto);

        botaoEntrar = criarBotaoEntrar();
        botaoEntrar.setBounds(320, 380, 100, 25);
        add(botaoEntrar);
    }

    private JTextField entrarTexto(){
        return new JTextField();
    }

    private JLabel criarInfo(){
        return new JLabel();
    }

    private JButton criarBotaoEntrar() {
        JButton botao = new JButton("ENTRAR");
        botao.addActionListener(e -> {
            numeroDigitado = campoTexto.getText();
            try {
                escolha = Integer.parseInt(numeroDigitado); // ← agora atualiza o campo estático corretamente
                dispose(); // fecha a janela ao clicar
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Digite um número válido.");
            }
            UsuarioServicos usuarioServicos = new UsuarioServicos();
            switch (escolha){
                case 1:
                    new TelaCadastro(usuarioServicos);
                    break;

                case 2:
                        new TelaLogin(usuarioServicos);
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }

        });
        return botao;
    }

    public static int getEscolha(){
        return escolha;
    }
}
