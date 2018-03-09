package seedu.organizer.storage;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import seedu.organizer.commons.exceptions.IllegalValueException;
import seedu.organizer.commons.util.FileUtil;
import seedu.organizer.commons.util.XmlUtil;
import seedu.organizer.model.Organizer;
import seedu.organizer.testutil.TypicalTasks;

public class XmlSerializableOrganizerTest {

    private static final String TEST_DATA_FOLDER = FileUtil.getPath("src/test/data/XmlSerializableOrganizerTest/");
    private static final File TYPICAL_PERSONS_FILE = new File(TEST_DATA_FOLDER + "typicalTasksOrganizer.xml");
    private static final File INVALID_PERSON_FILE = new File(TEST_DATA_FOLDER + "invalidTaskOrganizer.xml");
    private static final File INVALID_TAG_FILE = new File(TEST_DATA_FOLDER + "invalidTagOrganizer.xml");

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void toModelType_typicalPersonsFile_success() throws Exception {
        XmlSerializableOrganizer dataFromFile = XmlUtil.getDataFromFile(TYPICAL_PERSONS_FILE,
                XmlSerializableOrganizer.class);
        Organizer organizerFromFile = dataFromFile.toModelType();
        Organizer typicalPersonsOrganizer = TypicalTasks.getTypicalOrganizer();
        assertEquals(organizerFromFile, typicalPersonsOrganizer);
    }

    @Test
    public void toModelType_invalidPersonFile_throwsIllegalValueException() throws Exception {
        XmlSerializableOrganizer dataFromFile = XmlUtil.getDataFromFile(INVALID_PERSON_FILE,
                XmlSerializableOrganizer.class);
        thrown.expect(IllegalValueException.class);
        dataFromFile.toModelType();
    }

    @Test
    public void toModelType_invalidTagFile_throwsIllegalValueException() throws Exception {
        XmlSerializableOrganizer dataFromFile = XmlUtil.getDataFromFile(INVALID_TAG_FILE,
                XmlSerializableOrganizer.class);
        thrown.expect(IllegalValueException.class);
        dataFromFile.toModelType();
    }
}
