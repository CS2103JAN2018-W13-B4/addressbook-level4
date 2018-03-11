package seedu.organizer.ui;

import static guitests.guihandles.WebViewUtil.waitUntilBrowserLoaded;
import static org.junit.Assert.assertEquals;
import static seedu.organizer.testutil.EventsUtil.postNow;
import static seedu.organizer.testutil.TypicalTasks.GROCERY;
import static seedu.organizer.ui.BrowserPanel.DEFAULT_PAGE;
import static seedu.organizer.ui.UiPart.FXML_FILE_FOLDER;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import guitests.guihandles.BrowserPanelHandle;
import seedu.organizer.MainApp;
import seedu.organizer.commons.events.ui.TaskPanelSelectionChangedEvent;

public class BrowserPanelTest extends GuiUnitTest {
    private TaskPanelSelectionChangedEvent selectionChangedEventStub;

    private BrowserPanel browserPanel;
    private BrowserPanelHandle browserPanelHandle;

    @Before
    public void setUp() {
        selectionChangedEventStub = new TaskPanelSelectionChangedEvent(new TaskCard(GROCERY, 0));

        guiRobot.interact(() -> browserPanel = new BrowserPanel());
        uiPartRule.setUiPart(browserPanel);

        browserPanelHandle = new BrowserPanelHandle(browserPanel.getRoot());
    }

    @Test
    public void display() throws Exception {
        // default web page
        URL expectedDefaultPageUrl = MainApp.class.getResource(FXML_FILE_FOLDER + DEFAULT_PAGE);
        assertEquals(expectedDefaultPageUrl, browserPanelHandle.getLoadedUrl());

        // associated web page of a task
        postNow(selectionChangedEventStub);
        URL expectedPersonUrl = new URL(BrowserPanel.SEARCH_PAGE_URL + GROCERY.getName().fullName.replaceAll(" ", "%20"));

        waitUntilBrowserLoaded(browserPanelHandle);
        assertEquals(expectedPersonUrl, browserPanelHandle.getLoadedUrl());
    }
}
