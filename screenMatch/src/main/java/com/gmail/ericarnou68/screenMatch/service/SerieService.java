package com.gmail.ericarnou68.screenMatch.service;

import com.gmail.ericarnou68.screenMatch.dto.EpisodeDto;
import com.gmail.ericarnou68.screenMatch.dto.SerieDto;
import com.gmail.ericarnou68.screenMatch.model.Serie;
import com.gmail.ericarnou68.screenMatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepository;

    public List<SerieDto> getSeries(){
        return serieListConverterToDto(serieRepository.findAll());
    }

    public List<SerieDto> getTop5Series() {
        return serieListConverterToDto(serieRepository.findTop5ByOrderByAssessmentDesc());
    }

    private List<SerieDto> serieListConverterToDto(List<Serie> serie){
        return serie
                .stream()
                .map(s -> new SerieDto(s.getId(),s.getTitle(),s.getTotalSeasons(),s.getAssessment(),s.getGenre(),s.getActors(), s.getPoster(), s.getSynopsis()))
                .collect(Collectors.toList());
    }

    public SerieDto getSerieById(Long id) {
        Optional<Serie> serie =  serieRepository.findById(id);
        if (serie.isEmpty()) return null;
        Serie s = serie.get();
        return new SerieDto(s.getId(),s.getTitle(),s.getTotalSeasons(),s.getAssessment(),s.getGenre(),s.getActors(), s.getPoster(), s.getSynopsis());
    }

    public List<SerieDto> getSerieByRealese() {
        return serieListConverterToDto(serieRepository.findByLastRealeses());
    }

    public List<EpisodeDto> getAllSeasons(Long id) {
        Optional<Serie> serie =  serieRepository.findById(id);
        if (serie.isEmpty()) return null;
        Serie s = serie.get();
        return s.getEpisodeList()
                .stream()
                .map(e -> new EpisodeDto(e.getSeason(), e.getNumber(), e.getTitle()))
                .collect(Collectors.toList());
    }

    public List<EpisodeDto> getSeasonByNumber(Long id, Long number) {
        return serieRepository.getEpisodeBySeason(id, number)
                .stream()
                .map(e -> new EpisodeDto(e.getSeason(), e.getNumber(), e.getTitle()))
                .collect(Collectors.toList());
    }
}
