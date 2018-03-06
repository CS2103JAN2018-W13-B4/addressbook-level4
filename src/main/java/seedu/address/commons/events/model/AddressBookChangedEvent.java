package seedu.address.commons.events.model;

import seedu.address.commons.events.BaseEvent;
import seedu.address.model.ReadOnlyOrganizer;

/** Indicates the Organizer in the model has changed*/
public class AddressBookChangedEvent extends BaseEvent {

    public final ReadOnlyOrganizer data;

    public AddressBookChangedEvent(ReadOnlyOrganizer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "number of persons " + data.getPersonList().size() + ", number of tags " + data.getTagList().size();
    }
}
