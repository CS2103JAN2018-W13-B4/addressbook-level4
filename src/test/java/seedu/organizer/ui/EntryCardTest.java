package seedu.organizer.ui;

import static org.junit.Assert.assertEquals;

import guitests.guihandles.EntryCardHandle;
import seedu.organizer.model.task.Task;
import seedu.organizer.testutil.TaskBuilder;
import seedu.organizer.ui.calendar.EntryCard;

import org.junit.Test;

import static seedu.organizer.ui.testutil.GuiTestAssert.assertEntryCardDisplaysName;

//@@author guekling
public class EntryCardTest extends GuiUnitTest {

    @Test
    public void display() {
        Task task = new TaskBuilder().build();
        EntryCard entryCard = new EntryCard(task);
        uiPartRule.setUiPart(entryCard);
        assertCardDisplay(entryCard, task);
    }

    @Test
    public void getTask() {
        Task task = new TaskBuilder().build();
        EntryCard entryCard = new EntryCard(task);
        assertTaskEquals(task, entryCard.getTask());
    }

    /**
     * Asserts that {@code entryCard} displays the name of {@code expectedTask} correctly.
     */
    private void assertCardDisplay(EntryCard entryCard, Task expectedTask) {
        guiRobot.pauseForHuman();

        EntryCardHandle entryCardHandle = new EntryCardHandle(entryCard.getRoot());

        // verify task name is displayed correctly
        assertEntryCardDisplaysName(expectedTask, entryCardHandle);
    }

    /**
     * Asserts that {@code actualTask} equals to that of {@code expectedTask}.
     */
    private void assertTaskEquals(Task expectedTask, Task actualTask) {
        assertEquals(expectedTask.getName(), actualTask.getName());
        assertEquals(expectedTask.getPriority(), actualTask.getPriority());
        assertEquals(expectedTask.getDeadline(), actualTask.getDeadline());
        assertEquals(expectedTask.getDateAdded(), actualTask.getDateAdded());
        assertEquals(expectedTask.getDateCompleted(), actualTask.getDateCompleted());
        assertEquals(expectedTask.getDescription(), actualTask.getDescription());
        assertEquals(expectedTask.getStatus(), actualTask.getStatus());
        assertEquals(expectedTask.getTags(), actualTask.getTags());
        assertEquals(expectedTask.getSubtasks(), actualTask.getSubtasks());
    }
}
