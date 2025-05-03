package servicos;

import modelo.Evento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventoServicos {
    private List<Evento> eventos = new ArrayList<>();
    private int proximoId = 1;

    public Evento criarEvento(String titulo, String descricao, LocalDate data, String local, int idPromotor) {
        Evento evento = new Evento(proximoId++, titulo, descricao, data, local, idPromotor);
        eventos.add(evento);
        return evento;
    }

    public List<Evento> listarEventosDoPromotor(int idPromotor) {
        List<Evento> lista = new ArrayList<>();
        for (Evento e : eventos) {
            if (e.getIdPromotor() == idPromotor) {
                lista.add(e);
            }
        }
        return lista;
    }

    public List<Evento> listarTodosEventos() {
        return eventos;
    }

    public boolean removerEvento(int idEvento, int idPromotor) {
        return eventos.removeIf(e -> e.getId() == idEvento && e.getIdPromotor() == idPromotor);
    }

    public boolean atualizarEvento(int idEvento, int idPromotor, String novoTitulo, String novaDescricao, LocalDate novaData, String novoLocal) {
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
}