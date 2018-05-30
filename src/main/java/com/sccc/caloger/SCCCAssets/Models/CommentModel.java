package com.sccc.caloger.SCCCAssets.Models;

public class CommentModel {
    protected int id;
    protected int assetId;
    protected int userId;
    protected String comment;

    public CommentModel() {
    }

    public CommentModel(int assetId, int userId, String comment) {
        this.assetId = assetId;
        this.userId = userId;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
