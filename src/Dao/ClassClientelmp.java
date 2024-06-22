package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.Icliente;
import model.TblCliente;

public class ClassClientelmp implements Icliente{

	@Override
	public void RegistrarCliente(TblCliente cliente) {
		// establecer la conexión con la unidad de persistencia
		EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoJPASABADO2024-2"); 
		//gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		//iniciamos la transacción 
		emanager.getTransaction().begin();
		//registramos
		emanager.persist(cliente);
		//emitir mensaje por consola
		System.out.println("Cliente registrado en la BD");
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		
	}//Fin del metodo registrar cliente

	@Override
	public void ActualizarCliente(TblCliente cliente) {
		// TODO Auto-generated method stub
		//Establecemos conexión con unidad de persistencia
		EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoJPASABADO2024-2"); 
		//gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		//iniciamos la t5ransaccion
		emanager.getTransaction().begin();
		//actualizar
		emanager.merge(cliente);
		//emitimos mensaje
		System.out.println("Cliente actualizado en la BD");
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
	}//Fin del metodo actualizar cliente

	@Override
	public void EliminarCliente(TblCliente cliente) {
		//Establecemos conexión con unidad de persistencia
		EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoJPASABADO2024-2"); 
		//gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		//iniciamos la transaccion
		emanager.getTransaction().begin();
		//recuperamos el codigo a eliminar
		TblCliente elim= emanager.merge(cliente);
		//procedemos a eliminar
		emanager.remove(elim);
		//emitimos mensaje
		System.out.println("Cliente eliminado en la BD");
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		
		
	}//Fin del metodo eliminar cliente

	@Override
	public TblCliente BuscarCliente(TblCliente cliente) {
		//Establecemos conexión con unidad de persistencia
		EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoJPASABADO2024-2"); 
		//gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		//iniciamos la transaccion
		emanager.getTransaction().begin();
		//recuperamos el codigo a eliminar
		TblCliente buscarcli = emanager.find(TblCliente.class, cliente.getIdcliente());
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		//retornamos el cliente buscado
		return buscarcli;

	}//Fin del metodo buscar cliente

	@Override
	public List<TblCliente> ListadoCliente() {
		//Establecemos conexión con unidad de persistencia
		EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoJPASABADO2024-2"); 
		//gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		//iniciamos la transaccion
		emanager.getTransaction().begin();
		//recuperamos el listado de la bd
		//aplicamos consultas JPQL, el metodo createquery(), sirve para hacer consultas dinamicas en leguaje JPQL
		List<TblCliente> listado = emanager.createQuery("select c from TblClliente c", TblCliente.class).getResultList();
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		//retornamos el cliente buscado
		return listado;
	}//Fin del metodo listar cliente
	
}
