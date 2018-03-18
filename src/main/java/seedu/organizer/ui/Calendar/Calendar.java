package seedu.organizer.ui.Calendar;

import java.io.IOException;
import java.net.URL;
import java.time.YearMonth;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import seedu.organizer.MainApp;
import seedu.organizer.ui.UiPart;

import static java.util.Objects.requireNonNull;

//@@author guekling
/**
 * !!! ADD COMMENTS !!!
 */
public class Calendar extends UiPart<Region> {

    private static final String FXML = "Calendar.fxml";

    private MonthView monthView;

    @FXML
    private StackPane calendarBox;

    public Calendar() {
        super(FXML);
    }

    public void getCurrentMonth(YearMonth currentYearMonth) throws IOException {
        monthView = new MonthView();


        currentYearMonth = currentYearMonth.now();
        int currentYear = currentYearMonth.getYear();
        monthView.setMonthCalendarTitle(currentYear, currentYearMonth.getMonth().toString());

        monthView.setMonthCalendarDates(currentYear, currentYearMonth.getMonthValue());

        calendarBox.getChildren().add(FXMLLoader.load(getClass().getResource("/view/MonthView.fxml")));


    }

    public String getFxmlFile() {
        return "/view/" + FXML;
    }
}
