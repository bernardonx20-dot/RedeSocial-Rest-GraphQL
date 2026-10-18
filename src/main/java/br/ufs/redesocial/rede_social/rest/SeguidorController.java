package br.ufs.redesocial.rede_social.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufs.redesocial.rede_social.domain.Usuario;
import br.ufs.redesocial.rede_social.rest.dto.CriarSeguidorRequest;
import br.ufs.redesocial.rede_social.service.SeguidorService;
import br.ufs.redesocial.rede_social.service.UsuarioService;

@RestController
@RequestMapping("/seguidores")
public class SeguidorController {

    @Autowired
    private SeguidorService seguidorService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public void seguir(@RequestBody CriarSeguidorRequest request) {
        Usuario seguidor = usuarioService.buscar(request.getSeguidorId());
        Usuario seguido = usuarioService.buscar(request.getSeguidoId());
        seguidorService.seguirUsuario(seguidor, seguido);
    }
}
