package com.sccc.caloger.SCCCAssets.Controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sccc.caloger.SCCCAssets.DAO.AssetDAO;
import com.sccc.caloger.SCCCAssets.Models.AssetModel;
import netscape.javascript.JSObject;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/assets")
public class AssetController {

    @GetMapping("/all")
    ArrayList<AssetModel> getAll() throws SQLException {
        return AssetDAO.getAll();
    }

    @GetMapping("/{assetId}")
    private AssetModel getOne(@PathVariable("assetId") int id) throws SQLException {
        return AssetDAO.getOne(id);
    }

    @PostMapping("/{assetId}")
    private void update(@PathVariable("assetId") int id, @RequestBody Map<String, Object> payload) throws SQLException {
        AssetModel assetModel = new AssetModel();
        assetModel.setSerialNumber((String) payload.get("SerialNumber"));
        assetModel.setBuilding((String) payload.get("Building"));
        assetModel.setRoom((String) payload.get("Room"));
        assetModel.setCategory((String) payload.get("Category"));
        assetModel.setHostname((String) payload.get("Hostname"));
        assetModel.setModel((String) payload.get("Model"));

        AssetDAO.updateOne(id, assetModel);
    }

    @PostMapping("/create")
    private void create(@RequestBody Map<String, Object> payload) {
        AssetModel assetModel = new AssetModel();
        assetModel.setSerialNumber((String) payload.get("SerialNumber"));
        assetModel.setBuilding((String) payload.get("Building"));
        assetModel.setRoom((String) payload.get("Room"));
        assetModel.setCategory((String) payload.get("Category"));
        assetModel.setHostname((String) payload.get("Hostname"));
        assetModel.setModel((String) payload.get("Model"));

        AssetDAO.create(assetModel);
    }
}
