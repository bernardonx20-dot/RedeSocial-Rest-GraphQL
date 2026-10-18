package br.ufs.redesocial.rede_social.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ufs.redesocial.rede_social.domain.Perfil;
import br.ufs.redesocial.rede_social.service.PerfilService;

@Controller
public class PerfilResolver {

    @Autowired
    private PerfilService perfilService;

    @QueryMapping
    public Perfil perfil(@Argument Long id) {
        return perfilService.buscar(id);
    }

    @MutationMapping
    public Long criarPerfil(@Argument String bio, @Argument String urlFotoPerfil) {
        return perfilService.criarPerfil(bio, urlFotoPerfil);
    }
}
