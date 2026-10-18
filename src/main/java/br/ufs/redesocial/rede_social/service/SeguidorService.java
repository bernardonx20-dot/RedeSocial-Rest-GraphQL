package br.ufs.redesocial.rede_social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufs.redesocial.rede_social.domain.Seguidor;
import br.ufs.redesocial.rede_social.domain.Usuario;
import br.ufs.redesocial.rede_social.repository.SeguidorRepository;

@Service
public class SeguidorService {

    @Autowired
    private SeguidorRepository seguidorRepository;

    public void seguirUsuario(Usuario seguidor, Usuario seguido) {
        if (seguidor == null || seguido == null)
            throw new IllegalArgumentException("Seguidor ou seguido não podem ser nulos");
        Seguidor seguidorObjeto = new Seguidor(seguidor, seguido);
        seguidorRepository.save(seguidorObjeto);
    }

    public Seguidor buscar(Long id) {
        return seguidorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Seguidor não encontrado com id: " + id));
    }

    public List<Seguidor> seguidoresDe(Long usuarioId) {
        return seguidorRepository.findBySeguidoId(usuarioId);
    }

    public List<Seguidor> seguindoDe(Long usuarioId) {
        return seguidorRepository.findBySeguidorId(usuarioId);
    }
}
