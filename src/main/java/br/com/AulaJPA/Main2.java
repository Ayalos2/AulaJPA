package br.com.AulaJPA;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Cria e salva o usuário
        Usuario usuario = new Usuario();
        usuario.setNome("João Silva");
        usuario.setEmail("joao.silva@example.com");

        // Cria jogo e vincula ao usuario
        Jogo jogo1 = new Jogo();
        jogo1.setNome("Super Mario");
        jogo1.setGenero("Aventura");
        jogo1.setUsuario(usuario);

        Jogo jogo2 = new Jogo();
        jogo2.setNome("Zelda");
        jogo2.setGenero("Aventura");
        jogo2.setUsuario(usuario);

        usuario.setJogos(List.of(jogo1, jogo2));
        usuarioDAO.salvar(usuario);

        // Lista todos os usuários
        System.out.println("Usuários:");
        usuarioDAO.listar().forEach(u -> System.out.println(u.getNome() + ", " + u.getEmail()));

        // Buscar o usuário por ID
        Usuario usuarioBuscado = usuarioDAO.buscarPorId(usuario.getId());
        System.out.println("Usuário buscado: " + usuarioBuscado.getNome() + ", " + usuarioBuscado.getEmail());

        // Lista os jogos do usuário
        System.out.println("Jogos do usuário:");
        usuarioDAO.listarJogosDoUsuario(usuario.getId()).forEach(j -> System.out.println(j.getNome() + ", " + j.getGenero()));

        // Atualiza o usuário
        usuarioBuscado.setNome("João da Silva");
        usuarioDAO.atualizar(usuarioBuscado);
        System.out.println("Usuário atualizado: " + usuarioBuscado.getNome() + ", " + usuarioBuscado.getEmail());

        // Deleta o usuário
        usuarioDAO.deletar(usuarioBuscado.getId());
        System.out.println("Usuário deletado.");

    }
}
