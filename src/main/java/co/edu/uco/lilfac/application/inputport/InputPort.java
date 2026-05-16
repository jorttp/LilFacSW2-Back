package co.edu.uco.lilfac.application.inputport;

public interface InputPort <T, R> {
	R execute(T data);
}
