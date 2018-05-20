package com.sccc.caloger.SCCCAssets.Controllers;

import com.sccc.caloger.SCCCAssets.DAO.AssetDAO;
import com.sccc.caloger.SCCCAssets.Models.AssetModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/assets")
public class AssetController {

    @GetMapping("/all")
    ArrayList<AssetModel> getAll() throws SQLException {
        return AssetDAO.getAll();
    }

}
