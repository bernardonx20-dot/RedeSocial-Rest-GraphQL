package br.ufs.redesocial.rede_social.rest.dto;

public class CriarPerfilRequest {

    private String bio;
    private String urlFotoPerfil;

    public CriarPerfilRequest() {}

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getUrlFotoPerfil() { return urlFotoPerfil; }
    public void setUrlFotoPerfil(String urlFotoPerfil) { this.urlFotoPerfil = urlFotoPerfil; }
}
