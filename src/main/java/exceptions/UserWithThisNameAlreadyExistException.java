package exceptions;

public class UserWithThisNameAlreadyExistException extends Exception{
    public UserWithThisNameAlreadyExistException(String message) {super("User with username " + message + " already exist");}
}
