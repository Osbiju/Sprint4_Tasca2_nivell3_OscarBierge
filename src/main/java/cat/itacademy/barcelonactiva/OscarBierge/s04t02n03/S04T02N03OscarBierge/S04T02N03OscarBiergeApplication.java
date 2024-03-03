package cat.itacademy.barcelonactiva.OscarBierge.s04t02n03.S04T02N03OscarBierge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class S04T02N03OscarBiergeApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T02N03OscarBiergeApplication.class, args);
	}

}
