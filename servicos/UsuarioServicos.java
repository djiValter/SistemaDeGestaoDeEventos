package servicos;
import modelo.Usuario;
import modelo.TipoUsuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioServicos {
    private List<Usuario> usuarios = new ArrayList<>();
    private int proximoId = 1;

    public Usuario cadastrarUsuario(String nome, String email, String senha, TipoUsuario tipo) {
        Usuario usuario = new Usuario(proximoId++, nome, email, senha, tipo);
        usuarios.add(usuario);
        return usuario;
    }

    public Usuario login(String email, String senha) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null;
    }

    public void listarUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }
}