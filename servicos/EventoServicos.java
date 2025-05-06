package servicos;

import modelo.Evento;
import modelo.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventoServicos {
    private static List<Evento> eventos = new ArrayList<>();
    private int proximoId = 1;

    public Evento criarEvento(String titulo, String descricao, String data, String local, int idPromotor) {
        Evento evento = new Evento(proximoId++, titulo, descricao, data, local, idPromotor);
        eventos.add(evento);
        return evento;
    }

    public static List<Evento> listarEventosDoPromotor(int idPromotor) {
        List<Evento> lista = new ArrayList<>();
        for (Evento e : eventos) {
            if (e.getIdPromotor() == idPromotor) {
                lista.add(e);
            }
        }
        return lista;
    }

    public static List<Evento> listarTodosEventos() {
        return eventos;
    }

    public boolean removerEvento(int idEvento, int idPromotor) {
        return eventos.removeIf(e -> e.getId() == idEvento && e.getIdPromotor() == idPromotor);
    }

    public boolean atualizarEvento(int idEvento, int idPromotor, String novoTitulo, String novaDescricao, String novaData, String novoLocal) {
        for (Evento e : eventos) {
            if (e.getId() == idEvento && e.getIdPromotor() == idPromotor) {
                e.setTitulo(novoTitulo);
                e.setDescricao(novaDescricao);
                e.setData(novaData);
                e.setLocal(novoLocal);
                return true;
            }
        }
        return false;
    }

    /*public void inscreverUsuarioEmEvento(int idEvento, Usuario usuario) {
        for (Evento e : eventos) {
            if (e.getId() == idEvento) {
                e.adicionarParticipante(usuario);
                return;
            }
        }
        System.out.println("Evento com ID " + idEvento + " não encontrado.");
    }*/
}