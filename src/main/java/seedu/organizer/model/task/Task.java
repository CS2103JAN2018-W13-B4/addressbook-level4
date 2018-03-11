package seedu.organizer.model.task;

import static seedu.organizer.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import seedu.organizer.model.tag.Tag;
import seedu.organizer.model.tag.UniqueTagList;

/**
 * Represents a Task in the organizer book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Task {

    private final Name name;
    private final Priority priority;
    private final Deadline deadline;
    private final Address address;

    private final UniqueTagList tags;

    /**
     * Every field must be present and not null.
     */
    public Task(Name name, Priority priority, Deadline deadline, Address address, Set<Tag> tags) {
        requireAllNonNull(name, priority, deadline, address, tags);
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
        this.address = address;
        // protect internal tags from changes in the arg list
        this.tags = new UniqueTagList(tags);
    }

    public Name getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    public Deadline getDeadline() {
        return deadline;
    }

    public Address getAddress() {
        return address;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags.toSet());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Task)) {
            return false;
        }

        Task otherTask = (Task) other;
        return otherTask.getName().equals(this.getName())
                && otherTask.getPriority().equals(this.getPriority())
                && otherTask.getDeadline().equals(this.getDeadline())
                && otherTask.getAddress().equals(this.getAddress());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, priority, deadline, address, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Priority: ")
                .append(getPriority())
                .append(" Deadline: ")
                .append(getDeadline())
                .append(" Address: ")
                .append(getAddress())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
