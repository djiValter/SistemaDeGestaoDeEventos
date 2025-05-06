/*package janelas;
import modelo.Evento;
import servicos.UsuarioServicos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TelaCriarEvento extends JFrame {
    private int escolha;
    private String numeroDigitado;
    private JTextField campoTexto;
    private JTextField campoId, campoTitulo, campoDescricao, campoData, campoLocal, campoIdPromotor;
    private JButton botaoCriar;

    private static List<Evento> listaEventos = new ArrayList<>();

    public TelaCriarEvento() {
        setTitle("Criar Evento");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        inicializarComponentes();
        setVisible(true);
    }

    private void inicializarComponentes() {
        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(50, 30, 100, 25);
        add(labelId);

        campoId = new JTextField();
        campoId.setBounds(150, 30, 250, 25);
        add(campoId);

        JLabel labelTitulo = new JLabel("Título:");
        labelTitulo.setBounds(50, 70, 100, 25);
        add(labelTitulo);

        campoTitulo = new JTextField();
        campoTitulo.setBounds(150, 70, 250, 25);
        add(campoTitulo);

        JLabel labelDescricao = new JLabel("Descrição:");
        labelDescricao.setBounds(50, 110, 100, 25);
        add(labelDescricao);

        campoDescricao = new JTextField();
        campoDescricao.setBounds(150, 110, 250, 25);
        add(campoDescricao);

        JLabel labelData = new JLabel("Data:");
        labelData.setBounds(50, 150, 100, 25);
        add(labelData);

        campoData = new JTextField();
        campoData.setBounds(150, 150, 250, 25);
        add(campoData);

        JLabel labelLocal = new JLabel("Local:");
        labelLocal.setBounds(50, 190, 100, 25);
        add(labelLocal);

        campoLocal = new JTextField();
        campoLocal.setBounds(150, 190, 250, 25);
        add(campoLocal);

        JLabel labelIdPromotor = new JLabel("ID Promotor:");
        labelIdPromotor.setBounds(50, 230, 100, 25);
        add(labelIdPromotor);

        campoIdPromotor = new JTextField();
        campoIdPromotor.setBounds(150, 230, 250, 25);
        add(campoIdPromotor);

        botaoCriar = new JButton("Criar");
        botaoCriar.setBounds(150, 280, 100, 30);
        add(botaoCriar);


        private JButton criarBotaoEntrar() {
            JButton botao = new JButton("ENTRAR");
            botao.addActionListener(e -> {
                numeroDigitado = campoTexto.getText();
                try {
                    escolha = Integer.parseInt(numeroDigitado); // ← agora atualiza o campo corretamente
                    dispose(); // fecha a janela ao clicar
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Digite um número válido.");
                }

                UsuarioServicos usuarioServicos = new UsuarioServicos();
                switch (escolha) {
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
    }

    // Opcional: método para acessar eventos salvos
    public static List<Evento> getEventosCriados() {
        return listaEventos;
    }
}
