package com.sccc.caloger.SCCCAssets.DAO;

import com.sccc.caloger.SCCCAssets.DataConnection.MySQLConnector;
import com.sccc.caloger.SCCCAssets.Models.CommentModel;
import com.sccc.caloger.SCCCAssets.Presentation.CommentPresentation;

import java.sql.*;
import java.util.ArrayList;

public class CommentDAO {

    public ArrayList<CommentPresentation> getAll() throws SQLException{
        MySQLConnector mySQLConnector = new MySQLConnector();
        ArrayList<CommentPresentation> output = new ArrayList<>();
        String query = "SELECT Comments.*, Users.RealName FROM Comments JOIN Users ON Comments.id = Users.id";
        try(
                Connection conn = mySQLConnector.getSQLConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
        ) {
            while(rs.next()){
                CommentPresentation commentPresentation = new CommentPresentation();
                commentPresentation.setId(rs.getInt("id"));
                commentPresentation.setAssetId(rs.getInt("assetId"));
                commentPresentation.setUserId(rs.getInt("userId"));
                commentPresentation.setComment(rs.getString("comment"));
                commentPresentation.setRealName(rs.getString("RealName"));

                output.add(commentPresentation);
            }
        } catch (SQLException e) {
            System.out.println("SQLException on CommentDAO.getAll():");
            System.out.println(e);
        }
        return output;
    }

    public ArrayList<CommentPresentation> getAllCommentsOnAsset(int assetId) throws SQLException {
        MySQLConnector mySQLConnector = new MySQLConnector();

        ArrayList<CommentPresentation> output = new ArrayList<>();

        String query = "SELECT Comments.*, Users.RealName FROM Comments JOIN Users ON Comments.id = Users.id WHERE Comments.assetId = ?";

        try (
                Connection conn = mySQLConnector.getSQLConnection();
                PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setInt(1, assetId);
            ResultSet rs = stmt.executeQuery();
            if(!rs.isBeforeFirst()) {
                return null;
            } else {
                while(rs.next()){
                    CommentPresentation commentPresentation = new CommentPresentation();

                    commentPresentation.setId(rs.getInt("id"));
                    commentPresentation.setAssetId(rs.getInt("assetId"));
                    commentPresentation.setUserId(rs.getInt("userId"));
                    commentPresentation.setComment(rs.getString("comment"));
                    commentPresentation.setRealName(rs.getString("RealName"));

                    output.add(commentPresentation);
                }
            }
        }

        return output;
    }

    public CommentPresentation getOne(int id) {
        MySQLConnector mySQLConnector = new MySQLConnector();
        CommentPresentation output = new CommentPresentation();
        String query = "SELECT * FROM Comments WHERE id = ?";
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

                    CommentPresentation commentModel = new CommentPresentation();

                    CommentPresentation commentPresentation = new CommentPresentation();
                    commentPresentation.setId(rs.getInt("id"));
                    commentPresentation.setAssetId(rs.getInt("assetId"));
                    commentPresentation.setUserId(rs.getInt("userId"));
                    commentPresentation.setComment(rs.getString("comment"));
                    commentPresentation.setRealName(rs.getString("RealName"));
                }
            }

        } catch (SQLException e) {
            System.out.println("SQLException on CommentDAO.getAll():");
            System.out.println(e);
            System.out.println();
        }
        return output;
    }

    public void updateOne (int id, CommentModel commentModel) {
        MySQLConnector mySQLConnector = new MySQLConnector();
        String query = "UPDATE Comments " +
                "SET " +
                "comment = ?, " +
                "WHERE id = ?";
        try(
                Connection conn = mySQLConnector.getSQLConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setString(1, commentModel.getComment());
            stmt.setInt(2, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQLException on CommentDAO.update():");
            System.out.println(e);
            System.out.println();
        }
    }

    public void create(CommentModel commentModel) {
        MySQLConnector mySQLConnector = new MySQLConnector();
        String query = "INSERT INTO COmments " +
                "(assetId, userId, comment) " +
                "VALUES (?, ?, ?)";

        try(
                Connection conn = mySQLConnector.getSQLConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
        ) {
            stmt.setInt(1, commentModel.getAssetId());
            stmt.setInt(2, commentModel.getUserId());
            stmt.setString(3, commentModel.getComment());

            System.out.println(stmt);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQLException on COmmentDAO.create():");
            System.out.println(e);
            System.out.println();
        }
    }
}
