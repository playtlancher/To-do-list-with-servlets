package exceptions;

public class UserWithThisEmailAlreadyExistException extends Exception{
    public UserWithThisEmailAlreadyExistException(String message) {super("User with email" + message + " already exist");}
}
