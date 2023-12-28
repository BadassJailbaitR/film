package com.example.apifilms.repositories;

import com.example.apifilms.entities.Film;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRep extends JpaRepository<Film, Long> {

    @Transactional
    void deleteByIdAndRef(Long id,Long ref);
    List<Film> getAllByRef(Long ref);
    boolean existsFilmByRefAndId(Long ref,Long id);
}
