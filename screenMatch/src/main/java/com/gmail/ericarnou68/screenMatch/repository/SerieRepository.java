package com.gmail.ericarnou68.screenMatch.repository;

import com.gmail.ericarnou68.screenMatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTitleContainingIgnoreCase(String title);

}
