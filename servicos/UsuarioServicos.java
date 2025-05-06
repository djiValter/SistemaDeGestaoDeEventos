package servicos;
import modelo.Evento;
import modelo.Usuario;
import modelo.TipoUsuario;
import java.util.ArrayList;
import java.util.List;


public class UsuarioServicos {
    private static List<Usuario> usuariosComuns = new ArrayList<>();
    private static List<Usuario> promotores = new ArrayList<>();
    //private List<Usuario> usuarios = new ArrayList<>();
    private int proximoId = 1;

    public Usuario cadastrarUsuario(String nome, String email, String senha, TipoUsuario tipo) {
        for (Usuario u : getTodosUsuarios()) {
            if (u.getEmail().equals(email)) {
                throw new IllegalArgumentException("E-mail já cadastrado.");
            }
        }
        Usuario NovoUsuario = new Usuario(proximoId++, nome, email, senha, tipo);

        if (tipo == TipoUsuario.PROMOTOR) {
            promotores.add(NovoUsuario);
        } else {
            usuariosComuns.add(NovoUsuario);
        }

        return NovoUsuario;
    }

    public List<Usuario> getTodosUsuarios() {
        List<Usuario> todos = new ArrayList<>();
        todos.addAll(usuariosComuns);
        todos.addAll(promotores);
        return todos;
    }


    public Usuario login(String email, String senha) {
        for (Usuario u : getTodosUsuarios()) {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null;
    }
}