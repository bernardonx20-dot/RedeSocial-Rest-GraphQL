package br.ufs.redesocial.rede_social.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufs.redesocial.rede_social.domain.Perfil;
import br.ufs.redesocial.rede_social.domain.Usuario;
import br.ufs.redesocial.rede_social.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void criarUsuario(String nome, String email, String senha, Perfil perfil) {
        String nomeFinal = (nome == null || nome.isBlank()) ? null : nome;
        String emailFinal = (email == null || email.isBlank()) ? null : email;
        String senhaFinal = (senha == null || senha.isBlank()) ? null : senha;
        if (nomeFinal == null) throw new IllegalArgumentException("Nome não pode ser nulo");
        if (emailFinal == null) throw new IllegalArgumentException("Email não pode ser nulo");
        if (senhaFinal == null) throw new IllegalArgumentException("Senha não pode ser nula");
        if (perfil == null) throw new IllegalArgumentException("Perfil não pode ser nulo");
        Usuario usuario = new Usuario(nomeFinal, emailFinal, senhaFinal, perfil);
        usuarioRepository.save(usuario);
    }

    public Usuario buscar(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com id: " + id));
    }
}
