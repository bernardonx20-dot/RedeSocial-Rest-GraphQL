package br.ufs.redesocial.rede_social.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufs.redesocial.rede_social.domain.Curtida;
import br.ufs.redesocial.rede_social.domain.Post;
import br.ufs.redesocial.rede_social.domain.Usuario;
import br.ufs.redesocial.rede_social.repository.CurtidaRepository;

@Service
public class CurtidaService {

    @Autowired
    private CurtidaRepository curtidaRepository;

    public void criarCurtida(Usuario autor, Post post) {
        if (autor == null || post == null)
            throw new IllegalArgumentException("Autor ou post não podem ser nulos");
        Curtida curtida = new Curtida(autor, post);
        curtidaRepository.save(curtida);
    }

    public Curtida buscar(Long id) {
        return curtidaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curtida não encontrada com id: " + id));
    }
}
