package br.com.eduardo.springcrud.controller;


import br.com.eduardo.springcrud.model.Game;
import br.com.eduardo.springcrud.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game/v1")
public class GameControllerV1 {

    @Autowired
    private GameService service;

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

}
