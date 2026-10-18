package br.ufs.redesocial.rede_social.rest.dto;

public class CriarPostRequest {

    private String texto;
    private String urlFoto;
    private Long autorId;

    public CriarPostRequest() {}

    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

    public String getUrlFoto() { return urlFoto; }
    public void setUrlFoto(String urlFoto) { this.urlFoto = urlFoto; }

    public Long getAutorId() { return autorId; }
    public void setAutorId(Long autorId) { this.autorId = autorId; }
}
