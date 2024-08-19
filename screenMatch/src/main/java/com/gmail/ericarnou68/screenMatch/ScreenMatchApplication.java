package com.gmail.ericarnou68.screenMatch;

import com.gmail.ericarnou68.screenMatch.model.EpisodeData;
import com.gmail.ericarnou68.screenMatch.model.SeasonData;
import com.gmail.ericarnou68.screenMatch.model.SeriesData;
import com.gmail.ericarnou68.screenMatch.service.ApiConsumer;
import com.gmail.ericarnou68.screenMatch.service.DataConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApiConsumer apiConsumer = new ApiConsumer();
		String json = apiConsumer.resquestData("https://www.omdbapi.com/?t=gilmore+girls&apikey=231837db");
		DataConverter converter = new DataConverter();
		SeriesData serieData = converter.extractData(json, SeriesData.class);
		System.out.println(serieData);

		json = apiConsumer.resquestData("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=231837db");
		EpisodeData episodeData = converter.extractData(json, EpisodeData.class);
		System.out.println(episodeData);

		json = apiConsumer.resquestData("https://www.omdbapi.com/?t=gilmore+girls&season=1&apikey=231837db");
		SeasonData seasonData = converter.extractData(json, SeasonData.class);
		System.out.println(seasonData);
	}
}
