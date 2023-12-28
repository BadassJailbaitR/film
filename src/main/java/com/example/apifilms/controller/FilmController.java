package com.example.apifilms.controller;


import com.example.apifilms.entities.Film;
import com.example.apifilms.repositories.FilmRep;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class FilmController {

    @Autowired
    private FilmRep filmRep;


    @CrossOrigin(origins = "*")
    @GetMapping("/films/{ref}")
    List<Film> getFilms(@PathVariable Long ref){
        return filmRep.getAllByRef(ref);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/films/{id}/{ref}")
    @Transactional
    public void deleteFilms(@PathVariable("id") Long id, @PathVariable("ref") Long ref){
        filmRep.deleteByIdAndRef(id,ref);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/films/favorite/{ref}/{id}")
    Film addFilm(@RequestBody Film film,@PathVariable("ref") Long ref,@PathVariable("id") Long id){
        film.setRef(ref);
        film.setReference(id);
        System.out.println(film);
        return filmRep.save(film);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/films/find/{ref}/{id}")
    boolean isFilmExist(@PathVariable("ref") Long ref,@PathVariable("id") Long id) {
        return filmRep.existsFilmByRefAndId(ref,id);
    }

}
