package seedu.organizer.testutil;

import static seedu.organizer.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.organizer.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.organizer.logic.commands.CommandTestUtil.VALID_DEADLINE_AMY;
import static seedu.organizer.logic.commands.CommandTestUtil.VALID_DEADLINE_BOB;
import static seedu.organizer.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.organizer.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.organizer.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.organizer.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.organizer.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.organizer.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.organizer.model.Organizer;
import seedu.organizer.model.task.Task;
import seedu.organizer.model.task.exceptions.DuplicateTaskException;

/**
 * A utility class containing a list of {@code Task} objects to be used in tests.
 */
public class TypicalTasks {

    public static final Task ALICE = new TaskBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withDeadline("2018-03-11")
            .withPhone("85355255")
            .withTags("friends").build();
    public static final Task BENSON = new TaskBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withDeadline("2018-09-08").withPhone("98765432")
            .withTags("owesMoney", "friends").build();
    public static final Task CARL = new TaskBuilder().withName("Carl Kurz").withPhone("95352563")
            .withDeadline("2018-11-12").withAddress("wall street").build();
    public static final Task DANIEL = new TaskBuilder().withName("Daniel Meier").withPhone("87652533")
            .withDeadline("2018-03-21").withAddress("10th street").build();
    public static final Task ELLE = new TaskBuilder().withName("Elle Meyer").withPhone("9482224")
            .withDeadline("2018-09-14").withAddress("michegan ave").build();
    public static final Task FIONA = new TaskBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withDeadline("2018-04-05").withAddress("little tokyo").build();
    public static final Task GEORGE = new TaskBuilder().withName("George Best").withPhone("9482442")
            .withDeadline("2018-05-23").withAddress("4th street").build();

    // Manually added
    public static final Task HOON = new TaskBuilder().withName("Hoon Meier").withPhone("8482424")
            .withDeadline("2018-07-06").withAddress("little india").build();
    public static final Task IDA = new TaskBuilder().withName("Ida Mueller").withPhone("8482131")
            .withDeadline("2018-06-01").withAddress("chicago ave").build();

    // Manually added - Task's details found in {@code CommandTestUtil}
    public static final Task AMY = new TaskBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withDeadline(VALID_DEADLINE_AMY).withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Task BOB = new TaskBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withDeadline(VALID_DEADLINE_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND,
                    VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalTasks() {
    } // prevents instantiation

    /**
     * Returns an {@code Organizer} with all the typical persons.
     */
    public static Organizer getTypicalOrganizer() {
        Organizer ab = new Organizer();
        for (Task task : getTypicalPersons()) {
            try {
                ab.addTask(task);
            } catch (DuplicateTaskException e) {
                throw new AssertionError("not possible");
            }
        }
        return ab;
    }

    public static List<Task> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
