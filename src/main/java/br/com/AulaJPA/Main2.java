package br.com.AulaJPA;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        IdiomaDAO idiomaDAO = new IdiomaDAO();
        JogoDAO jogoDAO = new JogoDAO();

        // Cria e salva o usuário
        Usuario usuario = new Usuario();
        usuario.setNome("Leonardo Lucas");
        usuario.setEmail("leo@gmail.com");
        usuarioDAO.salvar(usuario);
        
        //Cria e salva os jogos
        Jogo jogo1 = new Jogo();
        jogo1.setNome("Super Mario");
        jogo1.setGenero("Aventura");
        jogo1.setUsuario(usuario);
        jogoDAO.salvar(jogo1);

        Jogo jogo2 = new Jogo();
        jogo2.setNome("Zelda");
        jogo2.setGenero("Aventura");
        jogo2.setUsuario(usuario);
        jogoDAO.salvar(jogo2);
        
        
        List<Usuario> usuarios = usuarioDAO.listar();

        // Para cada empresa, imprimir o nome, as plataformas e as categorias associadas
        for (Usuario user : usuarios) {
            // Imprimir o nome da empresa
            System.out.println("Usuario: " + user.getNome());
            // Imprimir as plataformas associadas à empresa
            for (Jogo jogos : user.getJogos()) {
                System.out.println("  Jogo: " + jogos.getNome());
            }
            System.out.println();  // Linha em branco entre as empresas
        }

    }
}