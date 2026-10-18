package br.ufs.redesocial.rede_social.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.ufs.redesocial.rede_social.domain.Seguidor;
import br.ufs.redesocial.rede_social.domain.Usuario;
import br.ufs.redesocial.rede_social.service.SeguidorService;
import br.ufs.redesocial.rede_social.service.UsuarioService;

@Controller
public class SeguidorResolver {

    @Autowired
    private SeguidorService seguidorService;

    @Autowired
    private UsuarioService usuarioService;

    @QueryMapping
    public Seguidor seguidor(@Argument Long id) {
        return seguidorService.buscar(id);
    }

    @MutationMapping
    public Boolean seguir(@Argument Long seguidorId, @Argument Long seguidoId) {
        Usuario seguidor = usuarioService.buscar(seguidorId);
        Usuario seguido = usuarioService.buscar(seguidoId);
        seguidorService.seguirUsuario(seguidor, seguido);
        return true;
    }

    @QueryMapping
    public List<Seguidor> seguidoresDe(@Argument Long usuarioId) {
        return seguidorService.seguidoresDe(usuarioId);
    }

    @QueryMapping
    public List<Seguidor> seguindoDe(@Argument Long usuarioId) {
        return seguidorService.seguindoDe(usuarioId);
    }
}
