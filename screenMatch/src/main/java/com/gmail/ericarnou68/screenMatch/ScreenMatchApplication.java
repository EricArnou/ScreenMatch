package com.gmail.ericarnou68.screenMatch;

import com.gmail.ericarnou68.screenMatch.main.Main;
import com.gmail.ericarnou68.screenMatch.model.EpisodeData;
import com.gmail.ericarnou68.screenMatch.model.SeasonData;
import com.gmail.ericarnou68.screenMatch.model.SeriesData;
import com.gmail.ericarnou68.screenMatch.service.ApiConsumer;
import com.gmail.ericarnou68.screenMatch.service.DataConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.objenesis.instantiator.sun.MagicInstantiator;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.showMenu();
	}
}
