package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.Iusuario;

import model.TblUsuario;

public class ClassUsuariolmp implements Iusuario{

	@Override
	public void RegistraruUsuario(TblUsuario usuario) {
		/// establecer la conexión con la unidad de persistencia
		EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoJPASABADO2024-2"); 
		//gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		//iniciamos la transacción 
		emanager.getTransaction().begin();
		//registramos
		emanager.persist(usuario);
		//emitir mensaje por consola
		System.out.println("Cliente registrado en la BD");
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
	}

	@Override
	public void ActualizarCUsuario(TblUsuario usuario) {
		// TODO Auto-generated method stub
				//Establecemos conexión con unidad de persistencia
				EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoJPASABADO2024-2"); 
				//gestionar las entidades
				EntityManager emanager = em.createEntityManager();
				//iniciamos la t5ransaccion
				emanager.getTransaction().begin();
				//actualizar
				emanager.merge(usuario);
				//emitimos mensaje
				System.out.println("Usuario actualizado en la BD");
				//confirmamos
				emanager.getTransaction().commit();
				//cerramos
				emanager.close();
		
	}

	@Override
	public void EliminarUsuario(TblUsuario usuario) {
		//Establecemos conexión con unidad de persistencia
				EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoJPASABADO2024-2"); 
				//gestionar las entidades
				EntityManager emanager = em.createEntityManager();
				//iniciamos la transaccion
				emanager.getTransaction().begin();
				//recuperamos el codigo a eliminar
				TblUsuario elim= emanager.merge(usuario);
				//procedemos a eliminar
				emanager.remove(elim);
				//emitimos mensaje
				System.out.println("Usuario eliminado en la BD");
				//confirmamos
				emanager.getTransaction().commit();
				//cerramos
				emanager.close();
		
	}

	@Override
	public TblUsuario BuscarUsuario(TblUsuario usuario) {
		//Establecemos conexión con unidad de persistencia
				EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoJPASABADO2024-2"); 
				//gestionar las entidades
				EntityManager emanager = em.createEntityManager();
				//iniciamos la transaccion
				emanager.getTransaction().begin();
				//recuperamos el codigo a eliminar
				TblUsuario buscarusu = emanager.find(TblUsuario.class, usuario.getIdusuario());
				//confirmamos
				emanager.getTransaction().commit();
				//cerramos
				emanager.close();
				//retornamos el cliente buscado
				return buscarusu;
	}

	@Override
	public List<TblUsuario> ListadoUsuario() {
		//Establecemos conexión con unidad de persistencia
		EntityManagerFactory em=Persistence.createEntityManagerFactory("ProyectoJPASABADO2024-2"); 
		//gestionar las entidades
		EntityManager emanager = em.createEntityManager();
		//iniciamos la transaccion
		emanager.getTransaction().begin();
		//recuperamos el listado de la bd
		//aplicamos consultas JPQL, el metodo createquery(), sirve para hacer consultas dinamicas en leguaje JPQL
		List<TblUsuario> listado = emanager.createQuery("select c from TblUsuario u", TblUsuario.class).getResultList();
		//confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		//retornamos el cliente buscado
		return listado;
	}

}
