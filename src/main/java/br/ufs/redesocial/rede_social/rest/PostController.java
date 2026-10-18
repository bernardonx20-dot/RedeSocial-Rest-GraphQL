package br.ufs.redesocial.rede_social.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufs.redesocial.rede_social.domain.Post;
import br.ufs.redesocial.rede_social.domain.Usuario;
import br.ufs.redesocial.rede_social.rest.dto.CriarPostRequest;
import br.ufs.redesocial.rede_social.service.PostService;
import br.ufs.redesocial.rede_social.service.UsuarioService;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public void criarPost(@RequestBody CriarPostRequest request) {
        Usuario autor = usuarioService.buscar(request.getAutorId());
        postService.criarPost(request.getTexto(), autor, request.getUrlFoto());
    }
}
