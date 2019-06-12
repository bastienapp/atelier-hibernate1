package com.example.shoesfactory.controllers;

import com.example.shoesfactory.entities.Shoes;
import com.example.shoesfactory.repositories.ShoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShoesController {

    @Autowired
    ShoesRepository repository;

    // create
    @PostMapping("/shoes")
    public Shoes create(@RequestBody Shoes item) {
        return repository.save(item);
    }

    // read
    @GetMapping("/shoes")
    public List<Shoes> readAll() {
        return repository.findAll();
    }

    @GetMapping("/shoes/{id}")
    public Optional<Shoes> read(@PathVariable("id") long id) {
        return repository.findById(id);
    }

    // update
    @PutMapping("/shoes/{id}")
    public Optional<Shoes> update(@PathVariable("id") long id,
                                  @RequestBody Shoes update) {
        return repository.findById(id).map(item -> {
            if (update.getPrice() != null) {
                item.setPrice(update.getPrice());
            }
            if (update.getName() != null) {
                item.setName(update.getName());
            }
            return repository.save(item);
        });
    }

    // delete
    @DeleteMapping("/shoes/{id}")
    public void delete(@PathVariable("id") long id) {
        repository.deleteById(id);
    }
}
