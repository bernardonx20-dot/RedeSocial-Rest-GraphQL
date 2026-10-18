package br.ufs.redesocial.rede_social.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufs.redesocial.rede_social.domain.Perfil;
import br.ufs.redesocial.rede_social.rest.dto.CriarPerfilRequest;
import br.ufs.redesocial.rede_social.service.PerfilService;

@RestController
@RequestMapping("/perfis")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @PostMapping
    public ResponseEntity<?> criarPerfil(@RequestBody CriarPerfilRequest request) {
        try {
            Long id = perfilService.criarPerfil(request.getBio(), request.getUrlFotoPerfil());
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Perfil> listarPerfis() {
        return perfilService.listarTodos();
    }
}
