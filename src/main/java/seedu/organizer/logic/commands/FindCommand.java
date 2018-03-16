package seedu.organizer.logic.commands;

import seedu.organizer.model.task.FieldsContainsKeywordsPredicate;

//@@author guekling
/**
 * Finds and lists all persons in organizer book whose name or description contains any of the argument keywords.
 * Keyword matching is not case sensitive.
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find";
    public static final String COMMAND_ALIAS = "f";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all tasks whose names or description contain "
            + "any of the specified keywords (not case-sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " cs2103 es2660 assignment";

    private final FieldsContainsKeywordsPredicate predicate;

    public FindCommand(FieldsContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute() {
        model.updateFilteredTaskList(predicate);
        return new CommandResult(getMessageForPersonListShownSummary(model.getFilteredTaskList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindCommand // instanceof handles nulls
                && this.predicate.equals(((FindCommand) other).predicate)); // state check
    }
}
