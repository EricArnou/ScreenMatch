package com.gmail.ericarnou68.screenMatch.controller;

import com.gmail.ericarnou68.screenMatch.dto.EpisodeDto;
import com.gmail.ericarnou68.screenMatch.dto.SerieDto;
import com.gmail.ericarnou68.screenMatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("series")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping()
    public List<SerieDto> getSeries(){
        return serieService.getSeries();
    }

    @GetMapping("/top5")
    public List<SerieDto> getTop5Series(){
        return serieService.getTop5Series();
    }

    @GetMapping("/{id}")
    public SerieDto getSerieById(@PathVariable Long id){
        return serieService.getSerieById(id);
    }

    @GetMapping("/lancamentos")
    public List<SerieDto> getSerieByRealease(){
        return serieService.getSerieByRealese();
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodeDto> getAllSeasons(@PathVariable Long id){
        return serieService.getAllSeasons(id);
    }

    @GetMapping("/{id}/temporadas/{numero}")
    public List<EpisodeDto> getSeasonByNumber(@PathVariable Long id, @PathVariable Long numero){
        return serieService.getSeasonByNumber(id, numero);
    }

    @GetMapping("/categoria/{nome_categoria}")
    public List<SerieDto> getSerieBygenre(@PathVariable String nome_categoria){
        return serieService.getSerieByGenre(nome_categoria);
    }
}
