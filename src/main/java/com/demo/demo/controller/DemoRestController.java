package com.demo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.model.DataModel;
import com.demo.demo.repository.DataRepository;

@RestController
@RequestMapping("/api/data")
public class DemoRestController {
    private final DataRepository dataRepository;

    public DemoRestController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @GetMapping
    public List<DataModel> getAllData() {
        return dataRepository.getAllData();
    }

    @PostMapping
    public ResponseEntity<String> addData(@RequestBody DataModel data) {
        dataRepository.addData(data);
        return ResponseEntity.status(HttpStatus.CREATED).body("Post successfully");
    }


    @PutMapping("/{index}")
    public void editData(@PathVariable int index, @RequestBody DataModel newData) {
        dataRepository.editData(index, newData);
    }

    @DeleteMapping("/{index}")
    public void deleteData(@PathVariable int index) {
        dataRepository.deleteData(index);
    }

}
