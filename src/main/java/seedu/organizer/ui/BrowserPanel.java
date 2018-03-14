package seedu.organizer.ui;

import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.logging.Logger;

import com.google.common.eventbus.Subscribe;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.web.WebView;
import seedu.organizer.MainApp;
import seedu.organizer.commons.core.LogsCenter;
import seedu.organizer.commons.events.ui.TaskPanelSelectionChangedEvent;
import seedu.organizer.model.task.Task;

/**
 * The Browser Panel of the App.
 */
public class BrowserPanel extends UiPart<Region> {

    /*public static final String DEFAULT_PAGE = "default.html";
    public static final String SEARCH_PAGE_URL =
            "https://se-edu.github.io/addressbook-level4/DummySearchPage.html?name=";*/

    private static final String FXML = "BrowserPanel.fxml";

    /*private final Logger logger = LogsCenter.getLogger(this.getClass());

    @FXML
    private WebView browser;*/

    private YearMonth currentYearMonth;

    @FXML
    private Text calendarShowMonth;

    @FXML
    private GridPane taskCalendar;
    

    public BrowserPanel() {
        super(FXML);

        //currentYearMonth = currentYearMonth.now();
        LocalDate currentYearMonth = LocalDate.of(2018, 12, 1);
        calendarShowMonth.setText(currentYearMonth.getMonth().toString() + " " + String.valueOf(currentYearMonth.getYear
            ()));


        LocalDate startDate = LocalDate.of(currentYearMonth.getYear(), currentYearMonth.getMonthValue(), 1);
        int startDay = startDate.getDayOfWeek().getValue();

        if (startDay == 7) {
            startDay = 0;
        }

        int lengthOfMonth = startDate.lengthOfMonth();
        String[] datesToBePrinted = new String[36];

        for (int date = 1; date <= 35; date++) {
            if (date <= lengthOfMonth) {
                datesToBePrinted[date] = "  " + String.valueOf(date);
            }
        }

        int dateCount = 1;

        for (int row = 0; row <= 4; row++) {
            if (row == 0) {
                for (int column = startDay; column <= 6; column++) {
                    Text dateToPrint = new Text(datesToBePrinted[dateCount]);
                    taskCalendar.add(dateToPrint, column, row);
                    taskCalendar.setHalignment(dateToPrint, HPos.LEFT);
                    taskCalendar.setValignment(dateToPrint, VPos.TOP);

                    dateCount++;
                }
            } else {
                for (int column = 0; column <= 6; column++) {
                    Text dateToPrint = new Text(datesToBePrinted[dateCount]);
                    taskCalendar.add(dateToPrint, column, row);
                    taskCalendar.setHalignment(dateToPrint, HPos.LEFT);
                    taskCalendar.setValignment(dateToPrint, VPos.TOP);

                    dateCount++;
                }
            }
        }

        if (dateCount != lengthOfMonth) { // if month has more than 5 weeks
            int remainingDays = lengthOfMonth - dateCount;

            for (int column = 0; column <= remainingDays; column++) {
                Text dateToPrint = new Text(datesToBePrinted[dateCount]);
                taskCalendar.add(dateToPrint, column, 0);
                taskCalendar.setHalignment(dateToPrint, HPos.LEFT);
                taskCalendar.setValignment(dateToPrint, VPos.TOP);

                dateCount++;
            }
        }


        /*taskCalendar.add(dateOne, 0, 0);
        taskCalendar.add(dateTwo, 1, 0);
        taskCalendar.setHalignment(dateOne, HPos.LEFT);
        taskCalendar.setValignment(dateOne, VPos.TOP);*/

        // To prevent triggering events for typing inside the loaded Web page.
        /*getRoot().setOnKeyPressed(Event::consume);

        loadDefaultPage();
        registerAsAnEventHandler(this);*/
    }

    /*private void loadPersonPage(Task task) {
        loadPage(SEARCH_PAGE_URL + task.getName().fullName);
    }

    public void loadPage(String url) {
        Platform.runLater(() -> browser.getEngine().load(url));
    }*/

    /**
     * Loads a default HTML file with a background that matches the general theme.
     */
    /*private void loadDefaultPage() {
        URL defaultPage = MainApp.class.getResource(FXML_FILE_FOLDER + DEFAULT_PAGE);
        loadPage(defaultPage.toExternalForm());
    }*/

    /**
     * Frees resources allocated to the browser.
     */
    /*public void freeResources() {
        browser = null;
    }

    @Subscribe
    private void handlePersonPanelSelectionChangedEvent(TaskPanelSelectionChangedEvent event) {
        logger.info(LogsCenter.getEventHandlingLogMessage(event));
        loadPersonPage(event.getNewSelection().task);
    }*/
}
