package com.gmail.ericarnou68.screenMatch.main;

import com.gmail.ericarnou68.screenMatch.model.Episode;
import com.gmail.ericarnou68.screenMatch.model.SeasonData;
import com.gmail.ericarnou68.screenMatch.model.Serie;
import com.gmail.ericarnou68.screenMatch.model.SeriesData;
import com.gmail.ericarnou68.screenMatch.repository.SerieRepository;
import com.gmail.ericarnou68.screenMatch.service.ApiConsumer;
import com.gmail.ericarnou68.screenMatch.service.DataConverter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private ApiConsumer apiConsumer = new ApiConsumer();
    private DataConverter converter = new DataConverter();
    private List<Serie> seriesList = new ArrayList<>();
    private SerieRepository serieRepository;
    private final String URL = "https://www.omdbapi.com/?t=";
    private final String APIKEY = "&apikey=231837db";

    public Main(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
        seriesList = serieRepository.findAll();
    }

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
        seriesList = serieRepository.findAll();
        seriesList.stream().forEach(System.out::println);
    }

    private void getEpisodesList(){
        seriesList.forEach(System.out::println);
        System.out.println("Enter with serie's name");
        String name_serie = scanner.nextLine();

        Optional<Serie> serie = serieRepository.findByTitleContainingIgnoreCase(name_serie);

        if(serie.isPresent()){
            Serie serieFound = serie.get();
            List<SeasonData> seasonData = new ArrayList<>();

            for (int i = 1; i < serieFound.getTotalSeasons(); i++) {
                String json = apiConsumer.resquestData(URL + serieFound.getTitle().replace(" ", "+")+"&season="+ i + APIKEY);
                SeasonData season = converter.extractData(json, SeasonData.class);
                seasonData.add(season);
            }
            seasonData.forEach(System.out::println);
            List<Episode> episodes = seasonData.stream()
                    .flatMap(d -> d.episodes().stream()
                            .map(e -> new Episode(d.season(), e)))
                    .collect(Collectors.toList());
            serieFound.setEpisodeList(episodes);
            serieRepository.save(serieFound);
        } else {
            System.out.println("Serie não encontrada!");
        }
    }

    private void getSerieWeb() {
        SeriesData data = getSerieData();
        Serie serie = new Serie(data);
        serieRepository.save(serie);
        System.out.println(serie);
    }

    private SeriesData getSerieData(){
        System.out.println("Write the name's serie: ");
        String title = scanner.nextLine();
        String json = apiConsumer.resquestData(URL + title.replace(" ", "+") + APIKEY);
        SeriesData data = converter.extractData(json, SeriesData.class);
        return data;
    }
}
