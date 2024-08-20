package com.gmail.ericarnou68.screenMatch.main;

import com.gmail.ericarnou68.screenMatch.model.Episode;
import com.gmail.ericarnou68.screenMatch.model.SeasonData;
import com.gmail.ericarnou68.screenMatch.model.SeriesData;
import com.gmail.ericarnou68.screenMatch.service.ApiConsumer;
import com.gmail.ericarnou68.screenMatch.service.DataConverter;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private ApiConsumer apiConsumer = new ApiConsumer();
    private DataConverter converter = new DataConverter();
    private final String URL = "https://www.omdbapi.com/?t=";
    private final String APIKEY = "&apikey=231837db";
    public void showMenu(){
        System.out.println("Digite o nome da série para busca: ");
        String title = scanner.nextLine();
        String json = apiConsumer.resquestData(URL + title.replace(" ", "+") + APIKEY);

        SeriesData serieData = converter.extractData(json, SeriesData.class);
        System.out.println("Title: " + serieData.title() +
                " Total seasons: " + serieData.totalSeasons() +
                " Assessment: " + serieData.assessment()
        );

        List<SeasonData> seasonsList = new ArrayList<>();

        for (int i = 1; i < serieData.totalSeasons(); i++) {
            json = apiConsumer.resquestData(URL + title.replace(" ", "+") + "&season=" + i + APIKEY);
            SeasonData seasonData = converter.extractData(json, SeasonData.class);
            seasonsList.add(seasonData);
        }

        System.out.println("\nAll episodes:\n");
        List<Episode> episodeList = seasonsList.stream()
                .flatMap(s -> s.episodes().stream()
                        .map(e -> new Episode(s.season(), e)))
                .collect(Collectors.toList());
        episodeList.forEach(System.out::println);

        Map<Integer, Double> seasonsAverageAssessent = episodeList.stream()
                .filter(e -> e.getAssessment() > 0.0)
                .collect(Collectors.groupingBy(Episode::getSeason, Collectors.averagingDouble(Episode::getAssessment)));
        System.out.println("\nAverage assessment per season:\n");
        seasonsAverageAssessent.forEach((s,a) -> System.out.println("Season: "+ s + ", assessment: " + a));
    }
}
