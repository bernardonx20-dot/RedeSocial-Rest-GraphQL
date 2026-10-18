package br.ufs.redesocial.rede_social.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufs.redesocial.rede_social.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByAutorIdOrderByDataCriacaoDesc(Long autorId);

    @Query("""
            SELECT p FROM Post p
            WHERE p.autor.id IN (
                SELECT s.seguido.id FROM Seguidor s
                WHERE s.seguidor.id = :usuarioId
            )
            ORDER BY p.dataCriacao DESC
            """)
    List<Post> buscarFeed(@Param("usuarioId") Long usuarioId);
}
