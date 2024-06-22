package interfaces;

import java.util.List;

import model.TblUsuario;

public interface Iusuario {
	public void RegistraruUsuario(TblUsuario usuario);
	public void ActualizarCUsuario(TblUsuario usuario);
	public void EliminarUsuario(TblUsuario usuario);
	public TblUsuario BuscarUsuario(TblUsuario usuario);
	public List<TblUsuario> ListadoUsuario();
	
}
