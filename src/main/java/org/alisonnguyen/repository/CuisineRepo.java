package org.alisonnguyen.repository;

import org.alisonnguyen.model.Cuisine;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CuisineRepo extends DataLoader{
    private Map<Integer, String> cuisineData = new HashMap<>();

    public CuisineRepo(String filePath) throws IOException{
        loadData(filePath);
    }

    @Override
    protected void processLine(String[]row){
        int cuisineId = Integer.parseInt(row[0]);
        String cuisineName = row[1].toLowerCase();

        Cuisine cuisine = new Cuisine(cuisineId,cuisineName);
        cuisineData.put(cuisineId,cuisineName);
    }

    @Override
    public Map<Integer, String> getAllData(){
        return cuisineData;
    }
}
