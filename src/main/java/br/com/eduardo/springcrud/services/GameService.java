package br.com.eduardo.springcrud.services;


import br.com.eduardo.springcrud.model.Game;
import br.com.eduardo.springcrud.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public Game save(Game person){
        return repository.save(person);
    }

    public Game findById(long id) throws Exception{
        return repository.findById(id).orElseThrow( () -> new Exception("Not Found!"));
    }

    public List<Game> findALL(){
        return  repository.findAll();
    }

    public Game update(Game person) throws Exception {
        Game p = repository.findById(person.getId()).orElseThrow( () -> new Exception("Not found"));
        p.setname(person.getname());
        p.setdeveloper(person.getdeveloper());
        p.setyear(person.getyear());
        return repository.save(p);
    }

    public void delete(long id) throws Exception {
        Game p = repository.findById(id).orElseThrow( () -> new Exception("Not Found"));
        repository.delete(p);
    }

}
