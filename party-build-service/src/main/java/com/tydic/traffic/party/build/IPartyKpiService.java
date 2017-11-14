package com.tydic.traffic.party.build;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by lenovo on 2017/8/23.
 */
public interface IPartyKpiService {
    public void uploadKPIData(FileInputStream fileInputStream, Integer stationType, Integer excelType) throws IOException;
}
