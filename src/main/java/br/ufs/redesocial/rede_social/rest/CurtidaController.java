package br.ufs.redesocial.rede_social.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufs.redesocial.rede_social.domain.Post;
import br.ufs.redesocial.rede_social.domain.Usuario;
import br.ufs.redesocial.rede_social.rest.dto.CriarCurtidaRequest;
import br.ufs.redesocial.rede_social.service.CurtidaService;
import br.ufs.redesocial.rede_social.service.PostService;
import br.ufs.redesocial.rede_social.service.UsuarioService;

@RestController
@RequestMapping("/curtidas")
public class CurtidaController {

    @Autowired
    private CurtidaService curtidaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PostService postService;

    @PostMapping
    public void curtir(@RequestBody CriarCurtidaRequest request) {
        Usuario autor = usuarioService.buscar(request.getAutorId());
        Post post = postService.buscar(request.getPostId());
        curtidaService.criarCurtida(autor, post);
    }
}
