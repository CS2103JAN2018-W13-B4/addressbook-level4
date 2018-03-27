package seedu.organizer.logic.commands;

import java.time.YearMonth;

import seedu.organizer.ui.CalendarPanel;

/**
 * ADD COMMENTS!!!
 * Lists all persons in the organizer book to the user.
 */
public class PreviousMonthCommand extends Command {

    public static final String COMMAND_WORD = "pmonth";
    public static final String COMMAND_ALIAS = "pm";

    @Override
    public CommandResult execute() {
        //CalendarPanel calendarPanel = new CalendarPanel();
        //YearMonth viewYearMonth = calendarPanel.getYearMonth().minusMonths(1);
        //calendarPanel.loadPreviousMonthView(viewYearMonth);
        return new CommandResult("TEST");
    }

}
