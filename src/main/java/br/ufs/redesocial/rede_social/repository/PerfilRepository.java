package br.ufs.redesocial.rede_social.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.redesocial.rede_social.domain.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    // Métodos adicionais podem ser adicionados aqui conforme necessário
}
