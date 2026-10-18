package br.ufs.redesocial.rede_social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufs.redesocial.rede_social.domain.Post;
import br.ufs.redesocial.rede_social.domain.Usuario;
import br.ufs.redesocial.rede_social.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void criarPost(String texto, Usuario autor, String urlFoto) {
        String textoFinal = (texto == null || texto.isBlank()) ? null : texto;
        String urlFinal = (urlFoto == null || urlFoto.isBlank()) ? null : urlFoto;
        if (textoFinal == null || autor == null || urlFinal == null)
            throw new IllegalArgumentException("Texto, autor ou urlFoto não podem ser nulos ou vazios");
        Post post = new Post(textoFinal, autor, urlFinal);
        postRepository.save(post);
    }

    public Post buscar(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post não encontrado com id: " + id));
    }

    public List<Post> postsDoUsuario(Long usuarioId) {
        return postRepository.findByAutorIdOrderByDataCriacaoDesc(usuarioId);
    }

    public List<Post> feedDoUsuario(Long usuarioId) {
        return postRepository.buscarFeed(usuarioId);
    }
}

