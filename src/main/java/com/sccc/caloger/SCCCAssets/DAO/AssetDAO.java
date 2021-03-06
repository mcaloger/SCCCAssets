package com.sccc.caloger.SCCCAssets.DAO;

import com.sccc.caloger.SCCCAssets.DataConnection.MySQLConnector;
import com.sccc.caloger.SCCCAssets.Models.AssetModel;

import java.sql.*;
import java.util.ArrayList;

public class AssetDAO {

    public ArrayList<AssetModel> getAll() throws SQLException{
        MySQLConnector mySQLConnector = new MySQLConnector();
        ArrayList<AssetModel> output = new ArrayList<>();
        String query = "SELECT * FROM Assets";
        try(
                Connection conn = mySQLConnector.getSQLConnection();
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
                assetModel.setModel(rs.getString("Model"));

                output.add(assetModel);
            }
        } catch (SQLException e) {
            System.out.println("SQLException on AssetDAO.getAll():");
            System.out.println(e);
        }
        return output;
    }

    public AssetModel getOne(int id) {
        MySQLConnector mySQLConnector = new MySQLConnector();
        AssetModel output = new AssetModel();
        String query = "SELECT * FROM Assets WHERE id = ?";
        try(
                Connection conn = mySQLConnector.getSQLConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setInt(1, id);
            System.out.println("query:" + stmt);
            ResultSet rs = stmt.executeQuery();
            if (!rs.isBeforeFirst() ) {
                return null;
            } else {
                while(rs.next()){

                    AssetModel assetModel = new AssetModel();
                    assetModel.setId(rs.getInt("id"));
                    assetModel.setSerialNumber(rs.getString("SerialNumber"));
                    assetModel.setBuilding(rs.getString("Building"));
                    assetModel.setRoom(rs.getString("Room"));
                    assetModel.setCategory(rs.getString("Category"));
                    assetModel.setHostname(rs.getString("Hostname"));
                    assetModel.setModel(rs.getString("Model"));

                    output = assetModel;
                }
            }

        } catch (SQLException e) {
            System.out.println("SQLException on AssetDAO.getAll():");
            System.out.println(e);
            System.out.println();
        }
        return output;
    }

    public void updateOne (int id, AssetModel assetModel) {
        MySQLConnector mySQLConnector = new MySQLConnector();
        String query = "UPDATE Assets " +
                "SET " +
                "SerialNumber = ?, " +
                "Building = ?, " +
                "Room = ?, " +
                "Category = ?, " +
                "Hostname = ? " +
                "Model = ?" +
                "WHERE id = ?";
        try(
                Connection conn = mySQLConnector.getSQLConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setString(1, assetModel.getSerialNumber());
            stmt.setString(2, assetModel.getBuilding());
            stmt.setString(3, assetModel.getRoom());
            stmt.setString(4, assetModel.getCategory());
            stmt.setString(5, assetModel.getHostname());
            stmt.setString(6, assetModel.getModel());
            stmt.setInt(7, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQLException on AssetDAO.update():");
            System.out.println(e);
            System.out.println();
        }
    }

    public void create(AssetModel assetModel) {
        MySQLConnector mySQLConnector = new MySQLConnector();
        String query = "INSERT INTO Assets " +
                "(SerialNumber, Building, Room, Category, Hostname, Model) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try(
                Connection conn = mySQLConnector.getSQLConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setString(1, assetModel.getSerialNumber());
            stmt.setString(2, assetModel.getBuilding());
            stmt.setString(3, assetModel.getRoom());
            stmt.setString(4, assetModel.getCategory());
            stmt.setString(5, assetModel.getHostname());
            stmt.setString(6, assetModel.getModel());

            System.out.println(stmt);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQLException on AssetDAO.create():");
            System.out.println(e);
            System.out.println();
        }
    }
}
