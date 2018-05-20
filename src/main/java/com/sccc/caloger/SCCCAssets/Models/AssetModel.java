package com.sccc.caloger.SCCCAssets.Models;

public class AssetModel {
    private int id;
    private String serialNumber;
    private String building;
    private String room;
    private String category;
    private String hostname;

    public AssetModel() {
    }

    public AssetModel(int id, String serialNumber, String building, String room, String category, String hostname) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.building = building;
        this.room = room;
        this.category = category;
        this.hostname = hostname;
    }

    public AssetModel(String serialNumber, String building, String room, String category, String hostname) {
        this.serialNumber = serialNumber;
        this.building = building;
        this.room = room;
        this.category = category;
        this.hostname = hostname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
}
