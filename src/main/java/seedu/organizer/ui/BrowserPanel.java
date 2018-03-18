package seedu.organizer.ui;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import seedu.organizer.commons.core.LogsCenter;
import seedu.organizer.ui.Calendar.Calendar;
import seedu.organizer.ui.Calendar.MonthView;

//@@author guekling
/**
 * The Browser Panel of the App.
 */
public class BrowserPanel extends UiPart<Region> {

    private static final String FXML = "BrowserPanel.fxml";

    private final Logger logger = LogsCenter.getLogger(this.getClass());

    private YearMonth currentYearMonth;
    private int dateCount;
    private String[] datesToBePrinted;
    private MonthView monthView;

    @FXML
    private Text calendarTitle;

    @FXML
    private GridPane taskCalendar;

    @FXML
    private StackPane calendarPane;

    public BrowserPanel() {
        super(FXML);

        monthView = new MonthView();
        loadMainView();

    }

    private void loadMainView() {
        try {
            createMainView();
        } catch (IOException e) {
            logger.warning("Error loading FXML file for Main View.");
        }
    }

    private void createMainView() throws IOException {
        monthView.getCurrentMonth(currentYearMonth);
        String fxmlMonth = monthView.getFxmlFile();
        calendarPane.getChildren().add(monthView.getRoot());
    }

}
