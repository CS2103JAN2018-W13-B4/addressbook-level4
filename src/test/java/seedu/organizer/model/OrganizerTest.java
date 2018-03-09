package seedu.organizer.model;

import static org.junit.Assert.assertEquals;
<<<<<<< HEAD:src/test/java/seedu/address/model/AddressBookTest.java
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_UNUSED;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.AMY;
import static seedu.address.testutil.TypicalPersons.BOB;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;
=======
import static seedu.organizer.testutil.TypicalTasks.ALICE;
import static seedu.organizer.testutil.TypicalTasks.getTypicalAddressBook;
>>>>>>> upstream/master:src/test/java/seedu/organizer/model/OrganizerTest.java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
<<<<<<< HEAD:src/test/java/seedu/address/model/AddressBookTest.java
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;
import seedu.address.testutil.AddressBookBuilder;
import seedu.address.testutil.PersonBuilder;
=======
import seedu.organizer.model.tag.Tag;
import seedu.organizer.model.task.Task;
>>>>>>> upstream/master:src/test/java/seedu/organizer/model/OrganizerTest.java

public class OrganizerTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

<<<<<<< HEAD:src/test/java/seedu/address/model/AddressBookTest.java
    private final AddressBook addressBook = new AddressBook();
    // Reused from https://github.com/se-edu/addressbook-level4/pull/790
    private final AddressBook addressBookWithBobAndAmy = new AddressBookBuilder().withPerson(BOB)
            .withPerson(AMY).build();

=======
    private final Organizer organizer = new Organizer();
>>>>>>> upstream/master:src/test/java/seedu/organizer/model/OrganizerTest.java

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), organizer.getPersonList());
        assertEquals(Collections.emptyList(), organizer.getTagList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        thrown.expect(NullPointerException.class);
        organizer.resetData(null);
    }

    @Test
    public void resetData_withValidReadOnlyAddressBook_replacesData() {
        Organizer newData = getTypicalAddressBook();
        organizer.resetData(newData);
        assertEquals(newData, organizer);
    }

    @Test
    public void resetData_withDuplicatePersons_throwsAssertionError() {
        // Repeat ALICE twice
        List<Task> newTasks = Arrays.asList(ALICE, ALICE);
        List<Tag> newTags = new ArrayList<>(ALICE.getTags());
        OrganizerStub newData = new OrganizerStub(newTasks, newTags);

        thrown.expect(AssertionError.class);
        organizer.resetData(newData);
    }

    @Test
    public void getPersonList_modifyList_throwsUnsupportedOperationException() {
        thrown.expect(UnsupportedOperationException.class);
        organizer.getPersonList().remove(0);
    }

    @Test
    public void getTagList_modifyList_throwsUnsupportedOperationException() {
        thrown.expect(UnsupportedOperationException.class);
        organizer.getTagList().remove(0);
    }

    // Reused from https://github.com/se-edu/addressbook-level4/pull/790
    @Test
    public void updatePerson_detailsChanged_personsAndTagsListUpdated() throws Exception {
        AddressBook addressBookUpdatedToAmy = new AddressBookBuilder().withPerson(BOB).build();
        addressBookUpdatedToAmy.updatePerson(BOB, AMY);

        AddressBook expectedAddressBook = new AddressBookBuilder().withPerson(AMY).build();

        assertEquals(expectedAddressBook, addressBookUpdatedToAmy);
    }

    @Test
    public void removeTag_nonExistentTag_addressBookUnchanged() throws Exception {
        addressBookWithBobAndAmy.removeTag(new Tag(VALID_TAG_UNUSED));

        AddressBook expectedAddressBook = new AddressBookBuilder().withPerson(BOB).withPerson(AMY).build();

        assertEquals(expectedAddressBook, addressBookWithBobAndAmy);
    }

    @Test
    public void removeTag_tagUsedByMultiplePersons_tagRemoved() throws Exception {
        addressBookWithBobAndAmy.removeTag(new Tag(VALID_TAG_FRIEND));

        Person amyWithoutFriendTag = new PersonBuilder(AMY).withTags().build();
        Person bobWithoutFriendTag = new PersonBuilder(BOB).withTags(VALID_TAG_HUSBAND).build();
        AddressBook expectedAddressBook = new AddressBookBuilder().withPerson(bobWithoutFriendTag)
                .withPerson(amyWithoutFriendTag).build();

        assertEquals(expectedAddressBook, addressBookWithBobAndAmy);
    }

    /**
     * A stub ReadOnlyOrganizer whose tasks and tags lists can violate interface constraints.
     */
    private static class OrganizerStub implements ReadOnlyOrganizer {
        private final ObservableList<Task> tasks = FXCollections.observableArrayList();
        private final ObservableList<Tag> tags = FXCollections.observableArrayList();

        OrganizerStub(Collection<Task> tasks, Collection<? extends Tag> tags) {
            this.tasks.setAll(tasks);
            this.tags.setAll(tags);
        }

        @Override
        public ObservableList<Task> getPersonList() {
            return tasks;
        }

        @Override
        public ObservableList<Tag> getTagList() {
            return tags;
        }
    }

}
