package br.ufs.redesocial.rede_social.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.redesocial.rede_social.domain.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Comentario> findByPostIdOrderByDataCriacaoAsc(Long postId);

    long countByPostId(Long postId);
}
