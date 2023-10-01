package com.demo.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.demo.model.DataModel;

@Repository
public class DataRepository {
    private final List<DataModel> dataStorage = new ArrayList<>();

    public List<DataModel> getAllData() {
        return dataStorage;
    }

    public void addData(DataModel data) {
        dataStorage.add(data);
    }

    public void editData(int index, DataModel newData) {
        if (index >= 0 && index < dataStorage.size()) {
            dataStorage.set(index, newData);
        }
    }

    public void deleteData (int index) {
         if (index >= 0 && index < dataStorage.size()) {
            dataStorage.remove(index);
        }
    }
}
