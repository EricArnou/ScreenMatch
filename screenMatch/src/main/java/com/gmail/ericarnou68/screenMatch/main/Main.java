package com.gmail.ericarnou68.screenMatch.main;

import com.gmail.ericarnou68.screenMatch.model.SeasonData;
import com.gmail.ericarnou68.screenMatch.model.SeriesData;
import com.gmail.ericarnou68.screenMatch.service.ApiConsumer;
import com.gmail.ericarnou68.screenMatch.service.DataConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        System.out.println(serieData);

        List<SeasonData> seasonsList = new ArrayList<>();

        for (int i = 1; i < serieData.totalSeasons(); i++) {
            json = apiConsumer.resquestData(URL + title.replace(" ", "+") + "&season=" + i + APIKEY);
            SeasonData seasonData = converter.extractData(json, SeasonData.class);
            seasonsList.add(seasonData);
        }
        seasonsList.forEach(System.out::println);
    }

}
