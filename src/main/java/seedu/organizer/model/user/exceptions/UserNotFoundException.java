package seedu.organizer.model.user.exceptions;

//@@author dominickenn
/**
 * Signals that an operation could not find the user
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("User could not be found");
    }
}
