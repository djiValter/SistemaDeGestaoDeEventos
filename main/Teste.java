package main;
import java.time.LocalDate;

import janelas.*;
import modelo.TipoUsuario;
import modelo.Usuario;
import servicos.UsuarioServicos;
import servicos.EventoServicos;
import modelo.Evento;
import java.util.ArrayList;
import java.util.*;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioServicos usuarioService = new UsuarioServicos();
        EventoServicos eventoService = new EventoServicos();

        while (true) {
            new MenuPrincipal();
            int opcao = MenuPrincipal.getEscolha();
            System.out.println("\n=== Sistema de Gestão de Eventos ===");
            System.out.println("1. Cadastrar");
            System.out.println("2. Login");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();
                    System.out.print("Tipo de usuário (1 - Promotor, 2 - Usuário): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

                    TipoUsuario tipoUsuario = (tipo == 1) ? TipoUsuario.PROMOTOR : TipoUsuario.USUARIO;
                    Usuario novo = usuarioService.cadastrarUsuario(nome, email, senha, tipoUsuario);
                    System.out.println("Usuário cadastrado com sucesso: " + novo);
                    break;

                case 2:
                    System.out.print("Email: ");
                    String emailLogin = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senhaLogin = scanner.nextLine();

                    Usuario logado = usuarioService.login(emailLogin, senhaLogin);
                    if (logado != null) {
                        System.out.println("Login bem-sucedido como " + logado.getTipo());
                        if (logado.getTipo() == TipoUsuario.PROMOTOR) {
                            menuPromotor(logado, scanner);
                        } else {
                            menuUsuario(logado, scanner);
                        }
                    } else {
                        System.out.println("Email ou senha inválidos.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuPromotor(Usuario usuario, Scanner scanner) {
        EventoServicos eventoService = new EventoServicos();

        while (true) {
            System.out.println("\n--- Menu do Promotor ---");
            System.out.println("1. Criar evento");
            System.out.println("2. Listar meus eventos");
            System.out.println("3. Editar evento");
            System.out.println("4. Remover evento");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Data (yyyy-mm-dd): ");
                    String data = scanner.nextLine();
                    System.out.print("Local: ");
                    String local = scanner.nextLine();

                    Evento novo = eventoService.criarEvento(titulo, descricao, data, local, usuario.getId());
                    System.out.println("Evento criado: " + novo);
                    break;

                case 2:
                    /*List<Evento> meusEventos = eventoService.listarEventosDoPromotor(usuario.getId());
                    if (meusEventos.isEmpty()) {
                        System.out.println("Você não tem eventos cadastrados.");
                    } else {
                        meusEventos.forEach(System.out::println);
                    }*/
                    break;

                case 3:
                    System.out.print("ID do evento para editar: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo título: ");
                    String novoTitulo = scanner.nextLine();
                    System.out.print("Nova descrição: ");
                    String novaDescricao = scanner.nextLine();
                    System.out.print("Nova data (yyyy-mm-dd): ");
                    String novaData = scanner.nextLine();
                    System.out.print("Novo local: ");
                    String novoLocal = scanner.nextLine();

                    boolean editado = eventoService.atualizarEvento(idEditar, usuario.getId(), novoTitulo, novaDescricao, novaData, novoLocal);
                    System.out.println(editado ? "Evento atualizado." : "Evento não encontrado ou sem permissão.");
                    break;

                case 4:
                    System.out.print("ID do evento para remover: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();

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

    private static void menuUsuario(Usuario usuario, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n*** Menu do Usuário ***");
            System.out.println("1. Ver todos os eventos");
            System.out.println("2. Ver meus eventos");
            System.out.println("3. Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Lista de todos os eventos ---");
                    List<Evento> eventos = EventoServicos.listarTodosEventos();
                    if (eventos.isEmpty()) {
                        System.out.println("Nenhum evento disponível.");
                    } else {
                        for (Evento e : eventos) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 2:
                    // Exibir eventos que o usuário participou ou criou
                    System.out.println("\n--- Meus eventos ---");
                    // Exemplo: eventoServicos.listarEventosDoUsuario(usuario);
                    break;

                case 3:
                    System.out.println("Saindo do menu do usuário.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
    }
}
