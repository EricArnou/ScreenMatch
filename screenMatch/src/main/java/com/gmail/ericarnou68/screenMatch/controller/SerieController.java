package com.gmail.ericarnou68.screenMatch.controller;

import com.gmail.ericarnou68.screenMatch.dto.SerieDto;
import com.gmail.ericarnou68.screenMatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping("/series")
    public List<SerieDto> getSeries(){
        return serieService.getSeries();
    }
}
