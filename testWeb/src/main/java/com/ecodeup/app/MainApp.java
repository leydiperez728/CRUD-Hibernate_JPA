package com.ecodeup.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ecodeup.model.Persona;

public class MainApp {

	public static void main(String[] args) {
		
//CRUD EFECTUADO
		int opcion = 0;
		Long cedula;
		Scanner scanner = new Scanner(System.in);
		Persona persona;
		String auxApellido, auxNombre, auxDireccion = new String();

		EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
		while (opcion!=5) {
			System.out.println("1. Crear Persona");
			System.out.println("2. Buscar Persona");
			System.out.println("3. Actualizar Persona");
			System.out.println("4. Eliminar Persona");
			System.out.println("5. Salir");
			System.out.println("Elija una opción:");

			opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Digite la cedula de la persona:");
				persona = new Persona();
				cedula = scanner.nextLong();
				persona.setCedula(cedula);
				scanner.nextLine();

				System.out.println("Digite el nombre de la persona:");
				auxNombre = scanner.nextLine();
				persona.setNombre(auxNombre);				
				
				System.out.println("Digite el apellido de la persona:");
				auxApellido = scanner.nextLine();
				persona.setApellido(auxApellido);
				
				System.out.println("Indique la dirección de la persona:");
				auxDireccion = scanner.nextLine();
				persona.setDireccion(auxDireccion);
				
				System.out.println("Ingrese el celular de la persona:");
				persona.setCelular(scanner.nextLong());
				
				System.out.println("Ingrese el número de teléfono:");
				persona.setTelefono(scanner.nextLong());
				
								
				System.out.println(persona);
				entity.getTransaction().begin();
				entity.persist(persona);
				entity.getTransaction().commit();
				System.out.println("Persona registrada...");
				System.out.println();
				break;

			case 2:
				System.out.println("Digite el documento de la persona a buscar:");
				persona = new Persona();
				persona = entity.find(Persona.class, scanner.nextLong());
				if (persona != null) {
					System.out.println(persona);
					System.out.println();
				} else {
					System.out.println();
					System.out.println("Persona no se ha encontrado... Lista de personas completa");
					List<Persona> listaPersonas= new ArrayList<>();
					Query query=entity.createQuery("SELECT p FROM Persona p");
					listaPersonas=query.getResultList();
					for (Persona p : listaPersonas) {
						System.out.println(p);
					}
					
					System.out.println();
				}

				break;
			case 3:
				System.out.println("Digite el documento de la persona a actualizar:");
				persona = new Persona();

				persona = entity.find(Persona.class, scanner.nextLong());
				if (persona != null) {
					System.out.println(persona);
					/*
					 * System.out.println("Digite el documento de la persona a modificar"); cedula =
					 * scanner.nextLong(); persona.setCedula(cedula); scanner.nextLine();
					 */			
					scanner.nextLine();
					System.out.println("Digite el nombre de la persona:");
					auxNombre = scanner.nextLine();
					persona.setNombre(auxNombre);				
					
					System.out.println("Digite el apellido de la persona:");
					auxApellido = scanner.nextLine();
					persona.setApellido(auxApellido);
					
					System.out.println("Indique la dirección de la persona:");
					auxDireccion = scanner.nextLine();
					persona.setDireccion(auxDireccion);
					
					System.out.println("Ingrese el celular de la persona:");
					persona.setCelular(scanner.nextLong());
					
					System.out.println("Ingrese el número de teléfono:");
					persona.setTelefono(scanner.nextLong());
					
					entity.getTransaction().begin();
					entity.merge(persona);
					entity.getTransaction().commit();
					System.out.println("Datos de la persona actualizados..");
					System.out.println();
				} else {
					System.out.println("Persona no encontrada...");
					System.out.println();
				}
				break;
			case 4:
				System.out.println("Digite el documento de la persona a eliminar:");
				persona = new Persona();

				persona = entity.find(Persona.class, scanner.nextLong());
				if (persona != null) {
					System.out.println(persona);
					entity.getTransaction().begin();
					entity.remove(persona);
					entity.getTransaction().commit();
					System.out.println("La persona ha sido eliminada de la base de datos...");
				} else {
					System.out.println("La persona no ha sido encontrada...");
				}
				break;
			case 5:entity.close();JPAUtil.shutdown();
			break;

			default:
				System.out.println("Opción no válida\n");
				break;
			}
		}
	}

}