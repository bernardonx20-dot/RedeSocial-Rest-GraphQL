package br.ufs.redesocial.rede_social.rest.dto;

public class CriarComentarioRequest {

    private String texto;
    private Long autorId;
    private Long postId;

    public CriarComentarioRequest() {}

    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

    public Long getAutorId() { return autorId; }
    public void setAutorId(Long autorId) { this.autorId = autorId; }

    public Long getPostId() { return postId; }
    public void setPostId(Long postId) { this.postId = postId; }
}
