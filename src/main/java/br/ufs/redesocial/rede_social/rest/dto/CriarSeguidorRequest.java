package br.ufs.redesocial.rede_social.rest.dto;

public class CriarSeguidorRequest {

    private Long seguidorId;
    private Long seguidoId;

    public CriarSeguidorRequest() {}

    public Long getSeguidorId() { return seguidorId; }
    public void setSeguidorId(Long seguidorId) { this.seguidorId = seguidorId; }

    public Long getSeguidoId() { return seguidoId; }
    public void setSeguidoId(Long seguidoId) { this.seguidoId = seguidoId; }
}
