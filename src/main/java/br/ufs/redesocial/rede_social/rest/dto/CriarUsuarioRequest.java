package br.ufs.redesocial.rede_social.rest.dto;

public class CriarUsuarioRequest {

    private String nome;
    private String email;
    private String senha;
    private Long perfilId;

    public CriarUsuarioRequest() {}

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public Long getPerfilId() { return perfilId; }
    public void setPerfilId(Long perfilId) { this.perfilId = perfilId; }
}
