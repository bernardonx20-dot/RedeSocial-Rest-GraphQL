package br.ufs.redesocial.rede_social.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufs.redesocial.rede_social.domain.Comentario;
import br.ufs.redesocial.rede_social.domain.Post;
import br.ufs.redesocial.rede_social.domain.Usuario;
import br.ufs.redesocial.rede_social.repository.ComentarioRepository;

@Service 
public class ComentarioService {

    @Autowired 
    private ComentarioRepository comentarioRepository;

    public void criarComentario(String texto, Usuario autor, Post post) {
        String textoFinal = (texto == null || texto.isBlank()) ? null : texto;
        if (textoFinal == null || autor == null || post == null)
            throw new IllegalArgumentException("Texto, autor ou post não podem ser nulos ou vazios");
        Comentario comentario = new Comentario(textoFinal, autor, post);
        comentarioRepository.save(comentario);
    }

    public Comentario buscar(Long id) {
        return comentarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Comentário não encontrado com id: " + id));
    }
}