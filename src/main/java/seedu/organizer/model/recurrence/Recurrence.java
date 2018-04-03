package seedu.organizer.model.recurrence;

import java.util.Objects;

//@@author natania
/**
 * Represents a Task's recurrence in the organizer book.
 */

public class Recurrence {

    public final boolean isRecurring;
    public final int recurrenceGroup;

    /**
     * Constructs a default {@code Recurrence} with task not recurring.
     */
    public Recurrence() {
        this.isRecurring = false; // false when task is not recurring, true when otherwise
        this.recurrenceGroup = 0; // dummy group
    }

    /**
     * Constructs a {@code Recurrence} for task that is recurring.
     *
     * @param index A valid identifying index for a group of recurring tasks.
     */
    public Recurrence(int index) {
        this.isRecurring = true; // false when task is not recurring, true when otherwise
        this.recurrenceGroup = index; // unique group of recurring tasks
    }

    /**
     * Constructs a {@code Recurrence} for task that is recurring.
     *
     * @param isRecurring A boolean that shows whether task is recurring
     * @param index A valid identifying index for a group of recurring tasks.
     */
    public Recurrence(boolean isRecurring, int index) {
        this.isRecurring = isRecurring; // false when task is not recurring, true when otherwise
        this.recurrenceGroup = index; // unique group of recurring tasks
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Recurrence // instanceof handles nulls
                && this.isRecurring == (((Recurrence) other).isRecurring))
                && this.recurrenceGroup == (((Recurrence) other).recurrenceGroup); // state check
    }

    @Override
    public int hashCode() {
        return Objects.hash(isRecurring, recurrenceGroup);
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return String.valueOf(recurrenceGroup);
    }

}


