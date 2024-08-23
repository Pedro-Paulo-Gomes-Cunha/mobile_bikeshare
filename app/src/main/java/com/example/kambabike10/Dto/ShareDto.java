package com.example.kambabike10.Dto;

public class ShareDto {

    private int ClienteId;
    private int DocaOrigemId;
    private int DocaDestinoId;
    private int BikeId;
    private int Status;

    public ShareDto() {

    }

    public ShareDto(int clienteId, int docaOrigemId, int docaDestinoId, int bikeId, int status) {
        ClienteId = clienteId;
        DocaOrigemId = docaOrigemId;
        DocaDestinoId = docaDestinoId;
        BikeId = bikeId;
        Status = status;
    }

    public int getClienteId() {
        return ClienteId;
    }

    public void setClienteId(int clienteId) {
        ClienteId = clienteId;
    }

    public int getDocaOrigemId() {
        return DocaOrigemId;
    }

    public void setDocaOrigemId(int docaOrigemId) {
        DocaOrigemId = docaOrigemId;
    }

    public int getDocaDestinoId() {
        return DocaDestinoId;
    }

    public void setDocaDestinoId(int docaDestinoId) {
        DocaDestinoId = docaDestinoId;
    }

    public int getBikeId() {
        return BikeId;
    }

    public void setBikeId(int bikeId) {
        BikeId = bikeId;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
