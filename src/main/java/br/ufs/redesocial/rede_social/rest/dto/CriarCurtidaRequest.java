package br.ufs.redesocial.rede_social.rest.dto;

public class CriarCurtidaRequest {

    private Long autorId;
    private Long postId;

    public CriarCurtidaRequest() {}

    public Long getAutorId() { return autorId; }
    public void setAutorId(Long autorId) { this.autorId = autorId; }

    public Long getPostId() { return postId; }
    public void setPostId(Long postId) { this.postId = postId; }
}
