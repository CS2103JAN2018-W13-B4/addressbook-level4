package seedu.organizer.ui;

import java.io.IOException;
import java.time.YearMonth;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.organizer.commons.core.LogsCenter;
import seedu.organizer.ui.Calendar.Calendar;

//@@author guekling
/**
 * The Browser Panel of the App.
 */
public class CalendarPanel extends UiPart<Region> {

    private static final String FXML = "CalendarPanel.fxml";

    private final Logger logger = LogsCenter.getLogger(this.getClass());

    private Calendar calendar;
    private YearMonth currentYearMonth;

    @FXML
    private StackPane calendarPane;

    public CalendarPanel() {
        super(FXML);

        calendar = new Calendar();
        currentYearMonth = currentYearMonth.now();

        loadMainView();
    }

    /**
     * ADD COMMENTS!!!!!!!!!
     */
    private void loadMainView() {
        try {
            createMainView();
        } catch (IOException e) {
            logger.warning("Error loading FXML file for Main View.");
        }
    }

    /**
     * ADD COMMENTS!!!!!!!!!!!!
     * @throws IOException
     */
    private void createMainView() throws IOException {
        calendar.getCurrentMonth(currentYearMonth);
        calendarPane.getChildren().add(calendar.getRoot());
    }

}
