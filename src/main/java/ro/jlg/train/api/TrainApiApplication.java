package ro.jlg.train.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class TrainApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(TrainApiApplication.class, args);
	}

}
