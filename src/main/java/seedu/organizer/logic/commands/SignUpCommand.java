package seedu.organizer.logic.commands;

//@@author dominickenn

import static java.util.Objects.requireNonNull;
import static seedu.organizer.logic.parser.CliSyntax.PREFIX_PASSWORD;
import static seedu.organizer.logic.parser.CliSyntax.PREFIX_USERNAME;

import seedu.organizer.logic.commands.exceptions.CommandException;
import seedu.organizer.model.user.UniqueUserList;
import seedu.organizer.model.user.User;

/**
 * Adds a user to the organizer.
 */
public class SignUpCommand extends UndoableCommand {

    public static final String COMMAND_WORD = "signup";
    public static final String COMMAND_ALIAS = "su";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Create a user account for PrioriTask. "
            + "Parameters: "
            + PREFIX_USERNAME + "USERNAME "
            + PREFIX_PASSWORD + "PASSWORD \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_USERNAME + "david "
            + PREFIX_PASSWORD + "david1234 ";

    public static final String MESSAGE_SUCCESS = "New user account created: %1$s";
    public static final String MESSAGE_DUPLICATE_USER = "This user already exists in the organizer";

    private final User toAdd;

    /**
     * Creates an SignUpCommand to add the specified {@code User}
     */
    public SignUpCommand(User user) {
        requireNonNull(user);
        toAdd = user;
    }

    @Override
    public CommandResult executeUndoableCommand() throws CommandException {
        requireNonNull(model);
        try {
            model.addUser(toAdd);
            return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
        } catch (UniqueUserList.DuplicateUserException e) {
            throw new CommandException(MESSAGE_DUPLICATE_USER);
        }

    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof SignUpCommand // instanceof handles nulls
                && toAdd.equals(((SignUpCommand) other).toAdd));
    }
}
