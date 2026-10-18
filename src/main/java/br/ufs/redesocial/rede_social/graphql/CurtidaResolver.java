package br.ufs.redesocial.rede_social.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ufs.redesocial.rede_social.domain.Curtida;
import br.ufs.redesocial.rede_social.domain.Post;
import br.ufs.redesocial.rede_social.domain.Usuario;
import br.ufs.redesocial.rede_social.service.CurtidaService;
import br.ufs.redesocial.rede_social.service.PostService;
import br.ufs.redesocial.rede_social.service.UsuarioService;

@Controller
public class CurtidaResolver {

    @Autowired
    private CurtidaService curtidaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PostService postService;

    @QueryMapping
    public Curtida curtida(@Argument Long id) {
        return curtidaService.buscar(id);
    }

    @MutationMapping
    public Boolean curtir(@Argument Long autorId, @Argument Long postId) {
        Usuario autor = usuarioService.buscar(autorId);
        Post post = postService.buscar(postId);
        curtidaService.criarCurtida(autor, post);
        return true;
    }
}
