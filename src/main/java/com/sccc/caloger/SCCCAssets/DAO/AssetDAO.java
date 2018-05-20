package com.sccc.caloger.SCCCAssets.DAO;

import com.sccc.caloger.SCCCAssets.DataConnection.MySQLConnector;
import com.sccc.caloger.SCCCAssets.Models.AssetModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AssetDAO {
    public static ArrayList<AssetModel> getAll() throws SQLException{
        ArrayList<AssetModel> output = new ArrayList<>();
        String query = "SELECT * FROM Assets";
        try(
                Connection conn = MySQLConnector.getSQLConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
        ) {
            while(rs.next()){
                AssetModel assetModel = new AssetModel();
                assetModel.setId(rs.getInt("id"));
                assetModel.setSerialNumber(rs.getString("SerialNumber"));
                assetModel.setBuilding(rs.getString("Building"));
                assetModel.setRoom(rs.getString("Room"));
                assetModel.setCategory(rs.getString("Category"));
                assetModel.setHostname(rs.getString("Hostname"));

                output.add(assetModel);
            }
        } catch (SQLException e) {
            System.out.println("SQLException on AssetDAO.getAll():");
            System.out.println(e);
            output = new ArrayList<>();
        }
        return output;
    }
}
