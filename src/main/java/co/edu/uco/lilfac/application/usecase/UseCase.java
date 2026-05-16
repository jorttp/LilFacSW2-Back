package co.edu.uco.lilfac.application.usecase;

public interface UseCase <D, R>{
	R execute(D data);
}
