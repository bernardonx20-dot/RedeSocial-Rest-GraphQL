package br.ufs.redesocial.rede_social.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.redesocial.rede_social.domain.Seguidor;

public interface SeguidorRepository extends JpaRepository<Seguidor, Long> {

    boolean existsBySeguidorIdAndSeguidoId(Long seguidorId, Long seguidoId);

    long countBySeguidoId(Long seguidoId);

    long countBySeguidorId(Long seguidorId);

    List<Seguidor> findBySeguidoId(Long seguidoId);

    List<Seguidor> findBySeguidorId(Long seguidorId);
}
