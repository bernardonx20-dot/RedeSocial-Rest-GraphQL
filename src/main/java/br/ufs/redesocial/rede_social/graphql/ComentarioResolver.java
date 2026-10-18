package br.ufs.redesocial.rede_social.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ufs.redesocial.rede_social.domain.Comentario;
import br.ufs.redesocial.rede_social.domain.Post;
import br.ufs.redesocial.rede_social.domain.Usuario;
import br.ufs.redesocial.rede_social.service.ComentarioService;
import br.ufs.redesocial.rede_social.service.PostService;
import br.ufs.redesocial.rede_social.service.UsuarioService;

@Controller
public class ComentarioResolver {

    @Autowired
    private ComentarioService comentarioService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PostService postService;

    @QueryMapping
    public Comentario comentario(@Argument Long id) {
        return comentarioService.buscar(id);
    }

    @MutationMapping
    public Boolean criarComentario(@Argument String texto, @Argument Long autorId,
                                   @Argument Long postId) {
        Usuario autor = usuarioService.buscar(autorId);
        Post post = postService.buscar(postId);
        comentarioService.criarComentario(texto, autor, post);
        return true;
    }
}
