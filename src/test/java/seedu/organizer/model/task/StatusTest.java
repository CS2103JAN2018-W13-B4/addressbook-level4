package seedu.organizer.model.task;

import org.junit.Test;
import seedu.organizer.testutil.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StatusTest {

    @Test
    public void comparator_allCombination() {
        Status s_true_1 = new Status(true);
        Status s_true_2 = new Status(true);
        Status s_false_1 = new Status(false);
        Status s_false_2 = new Status(false);

        assertTrue(s_true_1.equals(s_true_1));
        assertTrue(s_true_1.equals(s_true_2));
        assertFalse(s_true_1.equals(s_false_1));

        assertTrue(s_false_1.equals(s_false_1));
        assertTrue(s_false_1.equals(s_false_2));
        assertFalse(s_false_1.equals(s_true_1));
    }

    public void getInverse_allCombination() {
        Status s_true = new Status(true);
        Status s_false = new Status(false);

        assertEquals(s_true.getInverse(), s_false);
        assertEquals(s_false.getInverse(), s_true);
    }
}
