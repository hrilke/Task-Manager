package spring.project.Task_Manager.Exception;

public class EmailAlreadyRegisteredException extends Throwable {
    public EmailAlreadyRegisteredException(String message) {
        super(message);
    }
}
