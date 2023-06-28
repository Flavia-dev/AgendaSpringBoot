package com.estudo.agendaSpring;

import com.estudo.agendaSpring.model.Contact;
import com.estudo.agendaSpring.repository.ContactRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.stream.LongStream;

@SpringBootApplication
@EnableWebMvc
@OpenAPIDefinition(info = @Info(title = "AGENDA", version = "1.0", description = "CRUD REST using Spring Boot 2, Hibernate, JPA, and MySQL"))
public class AgendaSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(AgendaSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ContactRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> {
						Contact c = new Contact();
						c.setName("Contact " + i);
						c.setEmail("contact" + i + "@email.com");
						c.setPhone("(111) 111-1111");
						return c;
					})
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};
	}

}
