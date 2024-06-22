package Test;

import Dao.ClassClientelmp;
import model.TblCliente;

public class TestEntidadCliente{

public static void main(String[] args) {
	//Hacemos las respectivas instancias
	TblCliente cliente=new TblCliente();
	ClassClientelmp crud=new ClassClientelmp();
	//insertamos datos
	cliente.setNombre("yumi andrea");
	cliente.setApellidos("gomez chavez");
	cliente.setDni("478956612");
	cliente.setEmail("yumi@gmail.com");
	cliente.setTelf("3871459");
	cliente.setSexo("F");
	cliente.setNacionalidad("japonesa");
	crud.RegistrarCliente(cliente);
	
	TblCliente clientedos=new TblCliente();
	clientedos.setNombre("franklin yeferson");
	clientedos.setApellidos("perez perez");
	clientedos.setDni("10352248");
	clientedos.setEmail("franklin@gmail.com");
	clientedos.setTelf("3874594");
	clientedos.setSexo("M");
	clientedos.setNacionalidad("Peruano");
	crud.RegistrarCliente(clientedos);
	
	TblCliente clientetres=new TblCliente();
	clientetres.setNombre("erickson");
	clientetres.setApellidos("delgado sanchez");
	clientetres.setDni("10254789");
	clientetres.setEmail("erickson@gmail.com");
	clientetres.setTelf("4785936");
	clientetres.setSexo("M");
	clientetres.setNacionalidad("venezolano");
	crud.RegistrarCliente(clientedos);
	
	cliente.setIdcliente(2);
	cliente.setNombre("nilson alexander");
	cliente.setApellidos("martinez martinez");
	cliente.setDni("1047859");
	cliente.setEmail("nilson@gmail.com");
	cliente.setTelf("3871459");
	cliente.setSexo("M");
	cliente.setNacionalidad("argentino");
	crud.ActualizarCliente(cliente);
}
}
