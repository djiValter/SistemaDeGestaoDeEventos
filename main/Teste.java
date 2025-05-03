package main;
import java.time.LocalDate;

import janelas.MenuPrincipal;
import janelas.TelaCadastro;
import janelas.TelaLogin;
import janelas.TelaPromotor;
import modelo.TipoUsuario;
import modelo.Usuario;
import servicos.UsuarioServicos;
import servicos.EventoServicos;
import modelo.Evento;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        UsuarioServicos usuarioService = new UsuarioServicos();
        EventoServicos eventoService = new EventoServicos();
        while (true) {
            System.out.println("\n=== Sistema de Gestão de Eventos ===");
            System.out.println("1. Cadastrar");
            System.out.println("2. Login");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scan.nextInt();
            scan.nextLine(); // limpar buffer

            switch (opcao) {
                //Cadastrar Usuário/Promotor
                case 1:
                    System.out.print("Nome: ");
                    String nome = scan.nextLine();
                    System.out.print("Email: ");
                    String email = scan.nextLine();
                    System.out.print("Senha: ");
                    String senha = scan.nextLine();
                    System.out.print("Tipo de usuário (1 - Promotor, 2 - Usuário): ");
                    int tipo = scan.nextInt();
                    scan.nextLine(); // limpar buffer

                    TipoUsuario tipoUsuario = (tipo == 1) ? TipoUsuario.PROMOTOR : TipoUsuario.USUARIO;
                    Usuario novo = usuarioService.cadastrarUsuario(nome, email, senha, tipoUsuario);
                    System.out.println("Usuário cadastrado com sucesso: " + novo);
                    break;

                case 2:
                    //Login do Usuário/Promotor
                    System.out.print("Email: ");
                    String emailLogin = scan.nextLine();
                    System.out.print("Senha: ");
                    String senhaLogin = scan.nextLine();

                    Usuario logado = usuarioService.login(emailLogin, senhaLogin);
                    if (logado != null) {
                        System.out.println("Login bem-sucedido como " + logado.getTipo());
                        if (logado.getTipo() == TipoUsuario.PROMOTOR) {
                            menuPromotor(logado, scan);
                        } else {
                            menuUsuario(logado, scan);
                        }
                    } else {
                        System.out.println("Email ou senha inválidos.");
                    }
                    break;

                case 0:
                    //Encerrar o programa
                    System.out.println("Encerrando...");
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }


    private static void menuPromotor(Usuario usuario, Scanner scan) {
        EventoServicos eventoService = new EventoServicos();

        while (true) {
            System.out.println("\n--- Menu do Promotor ---");
            System.out.println("1 - Criar evento");
            System.out.println("2 - Listar meus eventos");
            System.out.println("3 - Editar evento");
            System.out.println("4 - Remover evento");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scan.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scan.nextLine();
                    System.out.print("Data (yyyy-mm-dd): ");
                    LocalDate data = LocalDate.parse(scan.nextLine());
                    System.out.print("Local: ");
                    String local = scan.nextLine();

                    Evento novo = eventoService.criarEvento(titulo, descricao, data, local, usuario.getId());
                    System.out.println("Evento criado: " + novo);
                    break;

                case 2:
                    List<Evento> meusEventos = eventoService.listarEventosDoPromotor(usuario.getId());
                    if (meusEventos.isEmpty()) {
                        System.out.println("Você não tem eventos cadastrados.");
                    } else {
                        meusEventos.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("ID do evento para editar: ");
                    int idEditar = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Novo título: ");
                    String novoTitulo = scan.nextLine();
                    System.out.print("Nova descrição: ");
                    String novaDescricao = scan.nextLine();
                    System.out.print("Nova data (yyyy-mm-dd): ");
                    LocalDate novaData = LocalDate.parse(scan.nextLine());
                    System.out.print("Novo local: ");
                    String novoLocal = scan.nextLine();

                    boolean editado = eventoService.atualizarEvento(idEditar, usuario.getId(), novoTitulo, novaDescricao, novaData, novoLocal);
                    System.out.println(editado ? "Evento atualizado." : "Evento não encontrado ou sem permissão.");
                    break;

                case 4:
                    System.out.print("ID do evento para remover: ");
                    int idRemover = scan.nextInt();
                    scan.nextLine();

                    boolean removido = eventoService.removerEvento(idRemover, usuario.getId());
                    System.out.println(removido ? "Evento removido." : "Evento não encontrado ou sem permissão.");
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void menuUsuario(Usuario usuario, Scanner scan) {
        EventoServicos eventoServicos = new EventoServicos();
        while(true){
            System.out.println("\n--- Menu do Usuário ---");
            System.out.println("1 - Eventos disponíveis");
            System.out.println("2 - Filtrar eventos por categoria,");
            System.out.println("3 - Detalhes de um evento");
            System.out.println("4 - Confirmar presença ");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            int opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao){
                case 1:
                    List<Evento>listarEvento = eventoServicos.listarTodosEventos();
                    if(listarEvento.isEmpty()){
                        System.out.println("Infelizmente não há eventos disponíveis...!");
                    }
                    else {
                        listarEvento.forEach(System.out :: println);
                    }
                    break;

                case 2:


                case 0:
                    return;

                default:
                    System.out.println("Opção inválida...!");
            }
        }
    }
}