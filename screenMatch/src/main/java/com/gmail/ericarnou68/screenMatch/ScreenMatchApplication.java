package com.gmail.ericarnou68.screenMatch;

import com.gmail.ericarnou68.screenMatch.model.DataSeries;
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
		DataSeries data = converter.extractData(json, DataSeries.class);
		System.out.println(data);
	}
}
