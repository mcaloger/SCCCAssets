package com.sccc.caloger.SCCCAssets.DataConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {

    public static Connection getSQLConnection () throws SQLException {
        // Exposing database secrets only for testing, will pull out into env variables later.
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:32768/SCCCAssets", "root", "password1");
        return conn;
    }
}
