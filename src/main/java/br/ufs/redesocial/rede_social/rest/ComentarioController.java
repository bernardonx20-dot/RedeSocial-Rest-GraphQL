package br.ufs.redesocial.rede_social.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufs.redesocial.rede_social.domain.Post;
import br.ufs.redesocial.rede_social.domain.Usuario;
import br.ufs.redesocial.rede_social.rest.dto.CriarComentarioRequest;
import br.ufs.redesocial.rede_social.service.ComentarioService;
import br.ufs.redesocial.rede_social.service.PostService;
import br.ufs.redesocial.rede_social.service.UsuarioService;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PostService postService;

    @PostMapping
    public void criarComentario(@RequestBody CriarComentarioRequest request) {
        Usuario autor = usuarioService.buscar(request.getAutorId());
        Post post = postService.buscar(request.getPostId());
        comentarioService.criarComentario(request.getTexto(), autor, post);
    }
}
