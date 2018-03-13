package seedu.organizer.model.task;

import static seedu.organizer.commons.util.AppUtil.checkArgument;

/**
 * Represents a Task's status in the organizer book.
 */
public class Status {

    public final static String LABEL_FOR_DONE = "Done";
    public final static String LABEL_FOR_NOT_DONE = "Not done";

    public final boolean value;

    /**
     * Constructs an {@code Description}.
     *
     * @param description A valid organizer.
     */
    public Status(boolean newValue) {
        this.value = newValue;
    }

    public Status getInverse() {
        return new Status(!this.value);
    }

    @Override
    public String toString() {
        if( this.value ) {
            return LABEL_FOR_DONE;
        } else {
            return LABEL_FOR_NOT_DONE;
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Status // instanceof handles nulls
                && this.value == ((Status) other).value); // state check
    }

    @Override
    public int hashCode() {
        if( this.value ) {
            return 1;
        } else {
            return 0;
        }
    }
}
