package br.ufs.redesocial.rede_social.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufs.redesocial.rede_social.domain.Perfil;
import br.ufs.redesocial.rede_social.rest.dto.CriarUsuarioRequest;
import br.ufs.redesocial.rede_social.service.PerfilService;
import br.ufs.redesocial.rede_social.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PerfilService perfilService;

    @PostMapping
    public void criarUsuario(@RequestBody CriarUsuarioRequest request) {
        Perfil perfil = perfilService.buscar(request.getPerfilId());
        usuarioService.criarUsuario(request.getNome(), request.getEmail(), request.getSenha(), perfil);
    }
}