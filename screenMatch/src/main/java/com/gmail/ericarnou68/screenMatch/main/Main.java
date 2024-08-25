package com.gmail.ericarnou68.screenMatch.main;

import com.gmail.ericarnou68.screenMatch.model.Serie;
import com.gmail.ericarnou68.screenMatch.model.SeriesData;
import com.gmail.ericarnou68.screenMatch.service.ApiConsumer;
import com.gmail.ericarnou68.screenMatch.service.DataConverter;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private ApiConsumer apiConsumer = new ApiConsumer();
    private DataConverter converter = new DataConverter();
    private List<SeriesData> seriesDataList = new ArrayList<>();
    private List<Serie> seriesList = new ArrayList<>();
    private final String URL = "https://www.omdbapi.com/?t=";
    private final String APIKEY = "&apikey=231837db";
    public void showMenu(){
        String menu = """
                1 - Search serie
                2 - Search episode
                3 - List series
                0 - Exit
                """;

        Integer option = -1;

        do {
            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    getSerieWeb();
                    break;
                case 2:
                    getEpisodesList();
                    break;
                case 3:
                    getSeries();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("invalid option");
            }
        } while (option != 0);
    }

    private void getSeries() {
        seriesList = seriesDataList.stream()
                .map(s -> new Serie(s)).collect(Collectors.toList());

        seriesList.forEach(System.out::println);
    }

    private void getEpisodesList() {
    }

    private void getSerieWeb() {
        SeriesData data = getSerieData();
        seriesDataList.add(data);
        System.out.println(data);
    }

    private SeriesData getSerieData() {
        System.out.println("Write the name's serie: ");
        String title = scanner.nextLine();
        String json = apiConsumer.resquestData(URL + title.replace(" ", "+")+ APIKEY);
        SeriesData data =  converter.extractData(json, SeriesData.class);
        return data;
    }
}
