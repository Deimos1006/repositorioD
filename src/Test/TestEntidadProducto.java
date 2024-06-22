package Test;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TblProducto;
import model.TblTipoproducto;

public class TestEntidadProducto {

	public static void main(String[] args) {
		// Establecemos la conexión con la unidad de persistencia
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoJPASABADO2024-2");

		// Gestionar las entidades
		EntityManager emanager = em.createEntityManager();

		// Iniciar la transacción
		emanager.getTransaction().begin();

		// Realizamos la respeciva instancia
		TblTipoproducto tipoprod = new TblTipoproducto();

		// Asignamos los respectivos valores
		tipoprod.setDescripcion("Mouse rojo");

		// Aplicamos la persistencia
		emanager.persist(tipoprod);

		// Emitir un mensaje por consola
		System.out.println("Tipo de producto registrado en la base de datos");

		// Confirmamos la transacción
		emanager.getTransaction().commit();

		// Cerrarmos la transacción
		emanager.close();
		
		/*Instanciamos la entidad tbl producto*/
		
		TblProducto producto = new TblProducto();
		
		/*Asignamos valores*/
		
		producto.setNomprod("Mouse");
		producto.setLote("L2020");
		producto.setCodbarras("777");
		producto.setFechavenc(Calendar.getInstance().getTime());
		producto.setPrecio(50);
		producto.setDescrip("Producto importado desde la china");
	}

}