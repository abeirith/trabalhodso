package persistencia;

public class ExcecaoErroDePersistencia extends Exception {

	private static final long serialVersionUID = 1L;

	public ExcecaoErroDePersistencia(String msg) {
		super(msg);
	}
}
