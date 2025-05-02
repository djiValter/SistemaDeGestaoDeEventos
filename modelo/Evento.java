package modelo;

import java.time.LocalDate;

public class Evento {
    private int id;
    private String titulo;
    private String descricao;
    private LocalDate data;
    private String local;
    private int idPromotor;

    public Evento(int id, String titulo, String descricao, LocalDate data, String local, int idPromotor){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.local = local;
        this.idPromotor = idPromotor;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getIdPromotor() {
        return idPromotor;
    }

    public void setIdPromotor(int idPromotor) {
        this.idPromotor = idPromotor;
    }

    @Override
    public String toString() {
        return "Evento\n" +
                "id=" + id +
                "\n titulo='" + titulo + '\'' +
                " \n descricao='" + descricao + '\'' +
                " \n data=" + data +
                " \n local='" + local + '\'' +
                " \n idPromotor=" + idPromotor;
    }
}

