package seedu.organizer.logic.commands;

/**
 * ADD COMMENTS!!!
 * Lists all persons in the organizer book to the user.
 */
public class PreviousMonthCommand extends Command {

    public static final String COMMAND_WORD = "pmonth";
    public static final String COMMAND_ALIAS = "pm";

    public static final String MESSAGE_SUCCESS = "Shows previous month";

    @Override
    public CommandResult execute() {
        return new CommandResult(MESSAGE_SUCCESS);
    }

}
