package br.ufs.redesocial.rede_social.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufs.redesocial.rede_social.domain.Perfil;
import br.ufs.redesocial.rede_social.repository.PerfilRepository;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public Long criarPerfil(String bio, String urlFotoPerfil) {
        String bioFinal = (bio == null || bio.isBlank()) ? null : bio;
        String urlFinal = (urlFotoPerfil == null || urlFotoPerfil.isBlank()) ? null : urlFotoPerfil;
        if (bioFinal == null) throw new IllegalArgumentException("Bio não pode ser nula");
        Perfil perfil = new Perfil(bioFinal, urlFinal);
        perfilRepository.save(perfil);
        return perfil.getId();
    }
    public Perfil buscar(Long id) {
        return perfilRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Perfil não encontrado com id: " + id));
    }

    public List<Perfil> listarTodos() {
        return perfilRepository.findAll();
    }
}
