package seedu.organizer.model.task;

import static java.util.Objects.requireNonNull;
import static seedu.organizer.commons.util.AppUtil.checkArgument;

/**
 * Represents a Task's deadline in the organizer book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDeadline(String)}
 */
public class Deadline {

    public static final String MESSAGE_DEADLINE_CONSTRAINTS =
        "Task deadlines should be in the format YYYY-MM-DD, and it should not be blank";

    /*
     * The first character of must not be a whitespace, otherwise " " (a blank string) becomes a valid input.
     * Format of string is YYYY-MM-DD.
     */
    public static final String DEADLINE_VALIDATION_REGEX = "\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])";

    public final String value;

    /**
     * Constructs an {@code Deadline}.
     *
     * @param deadline A valid deadline.
     */
    public Deadline(String deadline) {
        requireNonNull(deadline);
        checkArgument(isValidDeadline(deadline), MESSAGE_DEADLINE_CONSTRAINTS);
        this.value = deadline;
    }

    /**
     * Returns true if a given string is a valid task deadline.
     */
    public static boolean isValidDeadline(String test) {
        return test.matches(DEADLINE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Deadline // instanceof handles nulls
                && this.value.equals(((Deadline) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
