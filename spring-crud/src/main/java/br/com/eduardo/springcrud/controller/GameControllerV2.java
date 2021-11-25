package br.com.eduardo.springcrud.controller;


import br.com.eduardo.springcrud.model.Game;
import br.com.eduardo.springcrud.services.GameServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game/v2")
public class GameControllerV2 {

    @Autowired
    private GameServiceV2 service;

    @PostMapping
    public Game save(@RequestBody Game person){
        return service.save(person);
    }

    @GetMapping
    public List<Game> findALL(){
        return service.findALL();
    }

    @RequestMapping("/{id}")
    public Game findById(@PathVariable("id") long id) throws Exception{
        return service.findById(id);
    }

    @PutMapping
    public Game update(@RequestBody Game person) throws Exception{
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete( @PathVariable("id") long id) throws Exception{
        service.delete(id);
    }

    @GetMapping("/query/{name}")
    public List<Game> listByName(@PathVariable("name") String name){
        return service.listByName(name);
    }

}
