package com.gmail.ericarnou68.screenMatch.service;

import com.gmail.ericarnou68.screenMatch.dto.SerieDto;
import com.gmail.ericarnou68.screenMatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepository;

    public List<SerieDto> getSeries(){
        return serieRepository.findAll()
                .stream()
                .map(s -> new SerieDto(s.getId(),s.getTitle(),s.getTotalSeasons(),s.getAssessment(),s.getGenre(),s.getActors(), s.getPoster(), s.getSynopsis()))
                .collect(Collectors.toList());
    }
}
