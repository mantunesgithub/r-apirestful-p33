package com.kazale.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kazale.api.documents.Cliente;
import com.kazale.api.repositories.ClienteRepository;

@SpringBootApplication
public class P33Application {
	
	@Autowired
	private ClienteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(P33Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			repository.deleteAll();

			repository.save(new Cliente("Alice", 20));
			repository.save(new Cliente("João", 30));
			repository.save(new Cliente("Maria", 40));

			System.out.println("Lista todos com o findAll():");
			System.out.println("-------------------------------");
			repository.findAll().forEach(System.out::println);
			System.out.println();

			System.out.println("Busca um único cliente com o findByNome('Alice'):");
			System.out.println("--------------------------------");
			System.out.println(repository.findByNome("Alice"));
			System.out.println();
			
			System.out.println("Clientes com idade entre 18 and 35:");
			System.out.println("--------------------------------");
			repository.findByIdadeBetween(18, 35).forEach(System.out::println);
		};
	}
}
