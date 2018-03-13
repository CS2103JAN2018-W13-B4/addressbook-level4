package seedu.organizer.logic.commands;

import seedu.organizer.logic.CommandHistory;
import seedu.organizer.logic.UndoRedoStack;
import seedu.organizer.model.Model;
import seedu.organizer.model.ModelManager;
import seedu.organizer.model.Organizer;
import seedu.organizer.model.UserPrefs;
import seedu.organizer.model.task.DescriptionContainsKeywordsPredicate;
import seedu.organizer.model.task.Task;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.organizer.commons.core.Messages.MESSAGE_TASKS_LISTED_OVERVIEW;
import static seedu.organizer.testutil.TypicalTasks.PREPAREBREAKFAST;
import static seedu.organizer.testutil.TypicalTasks.PROJECT;
import static seedu.organizer.testutil.TypicalTasks.REVISION;
import static seedu.organizer.testutil.TypicalTasks.getTypicalOrganizer;

//@@author guekling
/**
 * Contains integration tests (interaction with the Model) for {@code FindDescriptionCommand}.
 */
public class FindDescriptionCommandTest {
    private Model model = new ModelManager(getTypicalOrganizer(), new UserPrefs());

    @Test
    public void equals() {
        DescriptionContainsKeywordsPredicate firstPredicate =
                new DescriptionContainsKeywordsPredicate(Collections.singletonList("cs2101"));
        DescriptionContainsKeywordsPredicate secondPredicate =
                new DescriptionContainsKeywordsPredicate(Collections.singletonList("CS2010"));

        FindDescriptionCommand findFirstCommand = new FindDescriptionCommand(firstPredicate);
        FindDescriptionCommand findSecondCommand = new FindDescriptionCommand(secondPredicate);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        FindDescriptionCommand findFirstCommandCopy = new FindDescriptionCommand(firstPredicate);
        assertTrue(findFirstCommand.equals(findFirstCommandCopy));

        // different types -> returns false
        assertFalse(findFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstCommand.equals(null));

        // different task -> returns false
        assertFalse(findFirstCommand.equals(findSecondCommand));
    }

    @Test
    public void equals_notCaseSensitive() {
        String expectedMessage = String.format(MESSAGE_TASKS_LISTED_OVERVIEW, 1);
        FindDescriptionCommand command = prepareCommand("op1");
        assertCommandSuccess(command, expectedMessage, Arrays.asList(PROJECT));
    }

    @Test
    public void execute_zeroKeywords_noTaskFound() {
        String expectedMessage = String.format(MESSAGE_TASKS_LISTED_OVERVIEW, 0);
        FindDescriptionCommand command = prepareCommand(" ");
        assertCommandSuccess(command, expectedMessage, Collections.emptyList());
    }

    @Test
    public void execute_multipleKeywords_multipleTasksFound() {
        String expectedMessage = String.format(MESSAGE_TASKS_LISTED_OVERVIEW, 3);
        FindDescriptionCommand command = prepareCommand("coffee OP1 midterms");
        assertCommandSuccess(command, expectedMessage, Arrays.asList(PREPAREBREAKFAST, PROJECT, REVISION));
    }

    /**
     * Parses {@code userInput} into a {@code FindDescriptionCommand}.
     */
    private FindDescriptionCommand prepareCommand(String userInput) {
        FindDescriptionCommand command =
            new FindDescriptionCommand(new DescriptionContainsKeywordsPredicate(Arrays.asList(userInput.split
            ("\\s+"))));
        command.setData(model, new CommandHistory(), new UndoRedoStack());
        return command;
    }

    /**
     * Asserts that {@code command} is successfully executed, and<br>
     * - the command feedback is equal to {@code expectedMessage}<br>
     * - the {@code FilteredList<Task>} is equal to {@code expectedList}<br>
     * - the {@code Organizer} in model remains the same after executing the {@code command}
     */
    private void assertCommandSuccess(FindDescriptionCommand command, String expectedMessage, List<Task> expectedList) {
        Organizer expectedOrganizer = new Organizer(model.getOrganizer());
        CommandResult commandResult = command.execute();

        assertEquals(expectedMessage, commandResult.feedbackToUser);
        assertEquals(expectedList, model.getFilteredTaskList());
        assertEquals(expectedOrganizer, model.getOrganizer());
    }
}
