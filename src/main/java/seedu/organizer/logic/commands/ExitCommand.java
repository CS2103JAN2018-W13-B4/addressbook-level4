package seedu.organizer.logic.commands;

import seedu.organizer.commons.core.EventsCenter;
import seedu.organizer.commons.events.ui.ExitAppRequestEvent;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_EXIT_ACKNOWLEDGEMENT = "Exiting Organizer as requested ...";

    @Override
    public CommandResult execute() {
        EventsCenter.getInstance().post(new ExitAppRequestEvent());
        return new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT);
    }

}
