package com.sccc.caloger.SCCCAssets.Presentation;

import com.sccc.caloger.SCCCAssets.Models.CommentModel;

public class CommentPresentation extends CommentModel{
    private int userId;
    private String realName;

    public CommentPresentation() {
    }

    public CommentPresentation(int userId, String realName) {
        this.userId = userId;
        this.realName = realName;
    }

    public CommentPresentation(int assetId, int userId, String comment, int userId1, String realName) {
        super(assetId, userId, comment);
        this.userId = userId1;
        this.realName = realName;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }


}
