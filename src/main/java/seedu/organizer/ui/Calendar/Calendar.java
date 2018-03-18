package seedu.organizer.ui.Calendar;

import java.io.IOException;
import java.time.YearMonth;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.organizer.ui.UiPart;

//@@author guekling
/**
 * !!! ADD COMMENTS !!!
 */
public class Calendar extends UiPart<Region> {

    private static final String FXML = "Calendar.fxml";

    private MonthView monthView;

    @FXML
    private StackPane calendarPlaceholder;

    public Calendar() {
        super(FXML);
    }

    /**
     * ADD COMMENTS!!!
     * @param currentYearMonth
     * @throws IOException
     */
    public void getCurrentMonth(YearMonth currentYearMonth) throws IOException {
        monthView = new MonthView();

        int currentYear = currentYearMonth.getYear();

        monthView.setMonthCalendarTitle(currentYear, currentYearMonth.getMonth().toString());
        monthView.setMonthCalendarDates(currentYear, currentYearMonth.getMonthValue());
        calendarPlaceholder.getChildren().add(monthView.getRoot());
    }
}
