package seedu.organizer.storage;

import static java.util.Objects.requireNonNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.organizer.commons.core.LogsCenter;
import seedu.organizer.commons.exceptions.DataConversionException;
import seedu.organizer.commons.exceptions.IllegalValueException;
import seedu.organizer.commons.util.FileUtil;
import seedu.organizer.model.ReadOnlyOrganizer;

/**
 * A class to access Organizer data stored as an xml file on the hard disk.
 */
public class XmlOrganizerStorage implements OrganizerStorage {

    private static final Logger logger = LogsCenter.getLogger(XmlOrganizerStorage.class);

    private String filePath;

    public XmlOrganizerStorage(String filePath) {
        this.filePath = filePath;
    }

    public String getAddressBookFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyOrganizer> readAddressBook() throws DataConversionException, IOException {
        return readAddressBook(filePath);
    }

    /**
     * Similar to {@link #readAddressBook()}
     * @param filePath location of the data. Cannot be null
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<ReadOnlyOrganizer> readAddressBook(String filePath) throws DataConversionException,
                                                                                 FileNotFoundException {
        requireNonNull(filePath);

        File addressBookFile = new File(filePath);

        if (!addressBookFile.exists()) {
            logger.info("Organizer file "  + addressBookFile + " not found");
            return Optional.empty();
        }

        XmlSerializableOrganizer xmlAddressBook = XmlFileStorage.loadDataFromSaveFile(new File(filePath));
        try {
            return Optional.of(xmlAddressBook.toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + addressBookFile + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveAddressBook(ReadOnlyOrganizer addressBook) throws IOException {
        saveAddressBook(addressBook, filePath);
    }

    /**
     * Similar to {@link #saveAddressBook(ReadOnlyOrganizer)}
     * @param filePath location of the data. Cannot be null
     */
    public void saveAddressBook(ReadOnlyOrganizer addressBook, String filePath) throws IOException {
        requireNonNull(addressBook);
        requireNonNull(filePath);

        File file = new File(filePath);
        FileUtil.createIfMissing(file);
        XmlFileStorage.saveDataToFile(file, new XmlSerializableOrganizer(addressBook));
    }

}
