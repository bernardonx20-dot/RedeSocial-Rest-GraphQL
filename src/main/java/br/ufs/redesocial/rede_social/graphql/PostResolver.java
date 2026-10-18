package br.ufs.redesocial.rede_social.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ufs.redesocial.rede_social.domain.Post;
import br.ufs.redesocial.rede_social.domain.Usuario;
import br.ufs.redesocial.rede_social.service.PostService;
import br.ufs.redesocial.rede_social.service.UsuarioService;

@Controller
public class PostResolver {

    @Autowired
    private PostService postService;

    @Autowired
    private UsuarioService usuarioService;

    @QueryMapping
    public Post post(@Argument Long id) {
        return postService.buscar(id);
    }

    @MutationMapping
    public Boolean criarPost(@Argument String texto, @Argument String urlFoto,
                             @Argument Long autorId) {
        Usuario autor = usuarioService.buscar(autorId);
        postService.criarPost(texto, autor, urlFoto);
        return true;
    }

    @QueryMapping
    public List<Post> postsDoUsuario(@Argument Long usuarioId) {
        return postService.postsDoUsuario(usuarioId);
    }

    @QueryMapping
    public List<Post> feedDoUsuario(@Argument Long usuarioId) {
        return postService.feedDoUsuario(usuarioId);
    }
}
