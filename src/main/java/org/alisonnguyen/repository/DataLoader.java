package org.alisonnguyen.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public abstract class DataLoader<T> {
    protected abstract void processLine(String[]values) throws IOException;

    protected void loadData(String filePath) throws IOException{
        String row;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine(); // Skip header line
            while ((row = reader.readLine()) != null) {
                String[] values = row.split(",");
                processLine(values);
            }
        }
    }

    public abstract Map<T, T> getAllData();
}
