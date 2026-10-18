package br.ufs.redesocial.rede_social.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.redesocial.rede_social.domain.Curtida;

public interface CurtidaRepository extends JpaRepository<Curtida, Long> {

    long countByPostId(Long postId);

    boolean existsByAutorIdAndPostId(Long autorId, Long postId);
}
