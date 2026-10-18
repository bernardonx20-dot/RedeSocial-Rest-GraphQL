package br.ufs.redesocial.rede_social.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ufs.redesocial.rede_social.domain.Perfil;
import br.ufs.redesocial.rede_social.domain.Usuario;
import br.ufs.redesocial.rede_social.service.PerfilService;
import br.ufs.redesocial.rede_social.service.UsuarioService;

@Controller
public class UsuarioResolver {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PerfilService perfilService;

    @QueryMapping
    public Usuario usuario(@Argument Long id) {
        return usuarioService.buscar(id);
    }

    @MutationMapping
    public Boolean criarUsuario(@Argument String nome, @Argument String email,
                                @Argument String senha, @Argument Long perfilId) {
        Perfil perfil = perfilService.buscar(perfilId);
        usuarioService.criarUsuario(nome, email, senha, perfil);
        return true;
    }
}
