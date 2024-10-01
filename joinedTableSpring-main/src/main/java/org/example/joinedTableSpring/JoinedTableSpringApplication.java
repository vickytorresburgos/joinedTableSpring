package org.example.joinedTableSpring;

import org.example.joinedTableSpring.repositorios.AlumnoRepository;
import org.example.joinedTableSpring.repositorios.PersonaRepository;
import org.example.joinedTableSpring.repositorios.ProfesorRepository;
import org.example.joinedTableSpring.entidades.Profesor;
import org.example.joinedTableSpring.entidades.Alumno;
import org.example.joinedTableSpring.enumeraciones.Especialidades;
import org.example.joinedTableSpring.enumeraciones.Titulos;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class JoinedTableSpringApplication {
	private static final Logger logger = LoggerFactory.getLogger(org.example.joinedTableSpring.JoinedTableSpringApplication.class);

	@Autowired
	private org.example.joinedTableSpring.repositorios.PersonaRepository personaRepository;
	@Autowired
	private org.example.joinedTableSpring.repositorios.ProfesorRepository profesorRepository;
	@Autowired
	private org.example.joinedTableSpring.repositorios.AlumnoRepository alumnoRepository;

	public static void main(String[] args) {
		SpringApplication.run(org.example.joinedTableSpring.JoinedTableSpringApplication.class, args);

		System.out.println("funcionando");
	}

	@Bean
	@Transactional
	CommandLineRunner init(org.example.joinedTableSpring.repositorios.PersonaRepository personaRepository,
						   org.example.joinedTableSpring.repositorios.AlumnoRepository alumnoRepository,
						   org.example.joinedTableSpring.repositorios.ProfesorRepository profesorRepository) {
		return args -> {

			LocalDate fechaIngreso = LocalDate.of(2023, 7, 15);
			BigDecimal sueldo = new BigDecimal("125.75");

			org.example.joinedTableSpring.entidades.Profesor p1 = org.example.joinedTableSpring.entidades.Profesor.builder()
					.nombre("Claudia")
					.apellido("Naveda")
					.cantHijos(1)
					.fechaIngreso(fechaIngreso)
					.sueldo(sueldo)
					.titulo(Titulos.INGENIERO)
					.build();

			profesorRepository.save(p1);

			fechaIngreso = LocalDate.of(2022, 7, 18);
			sueldo = new BigDecimal("142.10");

			org.example.joinedTableSpring.entidades.Profesor p2 = org.example.joinedTableSpring.entidades.Profesor.builder()
					.nombre("Alberto")
					.apellido("Cortez")
					.cantHijos(2)
					.fechaIngreso(fechaIngreso)
					.sueldo(sueldo)
					.titulo(Titulos.INGENIERO)
					.build();

			profesorRepository.save(p2);

			org.example.joinedTableSpring.entidades.Alumno a1 = org.example.joinedTableSpring.entidades.Alumno.builder()
					.nombre("Celina")
					.apellido("Guerra")
					.legajo(62354)
					.especialidad(Especialidades.BACHILLER)
					.build();

			alumnoRepository.save(a1);

			org.example.joinedTableSpring.entidades.Alumno a2 = org.example.joinedTableSpring.entidades.Alumno.builder()
					.nombre("Alma")
					.apellido("Quinteros")
					.legajo(62235)
					.especialidad(Especialidades.PERITO_MERCANTIL)
					.build();

			alumnoRepository.save(a2);

			org.example.joinedTableSpring.entidades.Alumno a3 = org.example.joinedTableSpring.entidades.Alumno.builder()
					.nombre("Sofia")
					.apellido("Soler")
					.legajo(62748)
					.especialidad(Especialidades.BACHILLER)
					.build();

			alumnoRepository.save(a3);
		};
	};
}
