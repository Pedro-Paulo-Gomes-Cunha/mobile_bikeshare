package com.example.kambabike10.Dto;

public class DocaDto2 {
    private int Id;
    private String Nome;
    private int Status;
    private String Estacao;
    private String Premio;

    private int EstacaoId;

    public DocaDto2() {

    }

    public DocaDto2(int id, String nome, int status, String estacao, String premio, int estacaoId) {
        Id = id;
        Nome = nome;
        Status = status;
        Estacao = estacao;
        Premio = premio;
        EstacaoId=estacaoId;
    }

    @Override
    public String toString() {
        return   "Id=" + Id +
                ", Nome='" + Nome + '\'' +
                ", Status=" + Status +
                ", Estacao='" + Estacao + '\'' +
                ", Premio='" + Premio + '\'' +
                ",EstacaoId='"+EstacaoId+'\'';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public String getEstacao() {
        return Estacao;
    }

    public void setEstacao(String estacao) {
        Estacao = estacao;
    }

    public int getEstacaoId() {
        return EstacaoId;
    }

    public void setEstacaoId(int estacaoId) {
        EstacaoId = estacaoId;
    }

    public String getPremio() {
        return Premio;
    }

    public void setPremio(String premio) {
        Premio = premio;
    }

    public DocaDto ToDto(){
        return new DocaDto(this.getNome(), this.getStatus(), this.getEstacaoId());
    }
}
