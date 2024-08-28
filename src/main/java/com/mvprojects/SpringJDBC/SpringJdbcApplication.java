package com.mvprojects.SpringJDBC;

import com.mvprojects.SpringJDBC.model.Idea;
import com.mvprojects.SpringJDBC.repository.IdeaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		IdeaRepository repo = context.getBean(IdeaRepository.class);

		//CREATE
		Idea idea1 = context.getBean(Idea.class);
		idea1.setTitle("Bring back Meritocracy");
		idea1.setHow("Working together");
		idea1.setWhy("Make a Better World");
		idea1.setCategory("Social");
		repo.save(idea1);

		//READ ALL
		repo.findAll().forEach(System.out::println);

		//UPDATE
		Idea idea2 = context.getBean(Idea.class);
		idea2.setIdeaId(11);
		idea2.setTitle("Bring back Meritocracy");
		idea2.setHow("Working together WITH TRANSPARENCY");
		idea2.setWhy("Make a Better World");
		idea2.setCategory("Social");
		repo.update(idea2);

		//READ BY ID
		System.out.println(repo.findById(11).toString());

		//DELETE BY ID
		repo.delete(11);
		repo.findAll().forEach(System.out::println);
	}
}
