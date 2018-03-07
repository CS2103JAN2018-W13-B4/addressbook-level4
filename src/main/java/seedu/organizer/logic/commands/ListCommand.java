package seedu.organizer.logic.commands;

import static seedu.organizer.model.Model.PREDICATE_SHOW_ALL_PERSONS;

/**
 * Lists all persons in the organizer book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all persons";


    @Override
    public CommandResult execute() {
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}