package com.gmail.ericarnou68.screenMatch.repository;

import com.gmail.ericarnou68.screenMatch.model.Category;
import com.gmail.ericarnou68.screenMatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTitleContainingIgnoreCase(String title);
    List<Serie> findByActorsContainingIgnoreCase(String actor);
    List<Serie> findByGenre(Category genre);
}
