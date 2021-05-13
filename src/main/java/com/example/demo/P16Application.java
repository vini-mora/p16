package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.repositories.EmpresaRepository;
import com.example.demo.entities.Empresa;

@SpringBootApplication
public class P16Application {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(P16Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Vinicius LTDA");
			empresa.setCnpj("02792266000140");
			
			this.empresaRepository.save(empresa);

			List<Empresa> empresas = empresaRepository.findAll();
			   	empresas.forEach(System.out::println);
			
			
				/*Empresa empresaDb = (Empresa) empresaRepository;
				
				 * no meu caso não consgui fazer a busca quando o tipo é long 
				 * pesquise no curso Erro no projeto P16 
				 * lá você percebe que esse problema só acontece na versão que estou porcausa disso estou Ignorando
				
				empresaDb.setId(1L);
				System.out.println("Empresa por ID: " + empresaDb);
				
				empresaDb.setRazaoSocial("Vinicius LTDA");
				this.empresaRepository.save(empresaDb);*/

				Empresa empresaCnpj = empresaRepository.findByCnpj("02792266000140");
				System.out.println("Empresa por CNPJ: " + empresaCnpj);
				
				this.empresaRepository.deleteById(1L);
				empresas = empresaRepository.findAll();
				System.out.println("Empresas: " + empresas.size());

		
						
			
			
		};	
	}

}
