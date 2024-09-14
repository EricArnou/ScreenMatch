package com.gmail.ericarnou68.screenMatch.repository;

import com.gmail.ericarnou68.screenMatch.model.Category;
import com.gmail.ericarnou68.screenMatch.model.Episode;
import com.gmail.ericarnou68.screenMatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTitleContainingIgnoreCase(String title);
    List<Serie> findByActorsContainingIgnoreCase(String actor);
    List<Serie> findByGenre(Category genre);
    List<Serie> findTop5ByOrderByAssessmentDesc();

    @Query("SELECT s FROM Serie s JOIN s.episodeList e GROUP BY s ORDER BY MAX(e.realeseDate) DESC LIMIT 5")
    List<Serie> findByLastRealeses();

    @Query("SELECT e FROM Serie s JOIN s.episodeList e WHERE s.id = :id AND e.season = :number")
    List<Episode> getEpisodeBySeason(Long id, Long number);
}
