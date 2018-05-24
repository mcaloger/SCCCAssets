package com.sccc.caloger.SCCCAssets.DataConnection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class DataConfigurationTest {


    @Test
    public void getUrl() {

        String url = DataConfiguration.url;

        System.out.println(url);
    }
}