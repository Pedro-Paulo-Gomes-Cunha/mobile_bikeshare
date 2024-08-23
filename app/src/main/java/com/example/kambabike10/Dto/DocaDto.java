package com.example.kambabike10.Dto;

public class DocaDto {


   private String Nome;


   private int Status;

    private int EstacaoId;

    public DocaDto() {

    }

    public DocaDto(String nome, int status, int estacaoId) {
        Nome = nome;
        Status = status;
        EstacaoId = estacaoId;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getEstacaoId() {
        return EstacaoId;
    }

    public void setEstacaoId(int estacaoId) {
        EstacaoId = estacaoId;
    }
}
