package uk.org.pentlandscouts.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "uk.org.pentlandscouts.events","uk.org.pentlandscouts.events.qrcode.controller","uk.org.pentlandscouts.events.qrcode.controller" })
@EntityScan(basePackages = {"uk.org.pentlandscouts.events.security.model"})
public class EventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsApplication.class, args);
	}

}
