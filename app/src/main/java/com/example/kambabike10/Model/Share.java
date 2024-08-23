package com.example.kambabike10.Model;

import com.example.kambabike10.Dto.ShareDto;

import java.time.LocalDateTime;

public class Share {
    private int  Id;

    private int ClienteId;

    private int DocaOrigemId;

    private int DocaDestinoId;

    private int BikeId;

    private int Status;

    private String Data;

    public Share() {

    }

    public Share(int id, int clienteId, int docaOrigemId, int docaDestinoId, int bikeId, int status, String data) {
        Id = id;
        ClienteId = clienteId;
        DocaOrigemId = docaOrigemId;
        DocaDestinoId = docaDestinoId;
        BikeId = bikeId;
        Status = status;
        Data = data;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public ShareDto ToDto(){
        return new ShareDto(this.getClienteId(), this.getDocaOrigemId(),this.getDocaDestinoId(),this.getBikeId(),this.getStatus());
    }
}
