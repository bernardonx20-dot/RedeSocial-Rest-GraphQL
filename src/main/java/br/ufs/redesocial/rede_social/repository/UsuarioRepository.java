package br.ufs.redesocial.rede_social.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufs.redesocial.rede_social.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);
}
