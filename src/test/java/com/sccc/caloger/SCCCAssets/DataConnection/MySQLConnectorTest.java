package com.sccc.caloger.SCCCAssets.DataConnection;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class MySQLConnectorTest {

    @Test
    public void getSQLConnection() throws SQLException {
        MySQLConnector connector = new MySQLConnector();
        connector.getSQLConnection();
        System.out.println("test passed");
    }
}