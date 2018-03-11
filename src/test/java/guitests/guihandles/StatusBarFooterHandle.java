package guitests.guihandles;

import org.controlsfx.control.StatusBar;

import javafx.scene.Node;

/**
 * A handle for the {@code StatusBarFooter} at the footer of the application.
 */
public class StatusBarFooterHandle extends NodeHandle<Node> {
    public static final String STATUS_BAR_PLACEHOLDER = "#statusbarPlaceholder";

    private static final String SYNC_STATUS_ID = "#syncStatus";
    private static final String TOTAL_TASKS_STATUS_ID = "#totalTasksStatus";
    private static final String SAVE_LOCATION_STATUS_ID = "#saveLocationStatus";

    private final StatusBar syncStatusNode;
    private final StatusBar totalTasksStatusNode;
    private final StatusBar saveLocationNode;

    private String lastRememberedSyncStatus;
    private String lastRememberedTotalTasksStatus;
    private String lastRememberedSaveLocation;

    public StatusBarFooterHandle(Node statusBarFooterNode) {
        super(statusBarFooterNode);

        this.syncStatusNode = getChildNode(SYNC_STATUS_ID);
        this.totalTasksStatusNode = getChildNode(TOTAL_TASKS_STATUS_ID);
        this.saveLocationNode = getChildNode(SAVE_LOCATION_STATUS_ID);
    }

    /**
     * Returns the text of the sync status portion of the status bar.
     */
    public String getSyncStatus() {
        return syncStatusNode.getText();
    }

    //@@author guekling-reused
    //Reused from https://github.com/se-edu/addressbook-level4/pull/803/files with minor modifications
    /**
     * Returns the text of the 'total tasks' portion of the status bar.
     */
    public String getTotalTasksStatus() {
        return totalTasksStatusNode.getText();
    }
    //@@author
    /**
     * Returns the text of the 'save location' portion of the status bar.
     */
    public String getSaveLocation() {
        return saveLocationNode.getText();
    }

    /**
     * Remembers the content of the sync status portion of the status bar.
     */
    public void rememberSyncStatus() {
        lastRememberedSyncStatus = getSyncStatus();
    }

    /**
     * Returns true if the current content of the sync status is different from the value remembered by the most recent
     * {@code rememberSyncStatus()} call.
     */
    public boolean isSyncStatusChanged() {
        return !lastRememberedSyncStatus.equals(getSyncStatus());
    }
    //@@author guekling-reused
    //Reused from https://github.com/se-edu/addressbook-level4/pull/803/files with minor modifications
    /**
     * Remembers the content of the 'total persons' portion of the status bar.
     */
    public void rememberTotalTasksStatus() {
        lastRememberedTotalTasksStatus = getTotalTasksStatus();
    }

    /**
     * Returns true if the current content of the 'total persons' is different from the value remembered by the most
     * recent {@code rememberTotalTasksStatus()} call.
     */
    public boolean isTotalTasksStatusChanged() {
        return !lastRememberedTotalTasksStatus.equals(getTotalTasksStatus());
    }
    //@@author
    /**
     * Remembers the content of the 'save location' portion of the status bar.
     */
    public void rememberSaveLocation() {
        lastRememberedSaveLocation = getSaveLocation();
    }

    /**
     * Returns true if the current content of the 'save location' is different from the value remembered by the most
     * recent {@code rememberSaveLocation()} call.
     */
    public boolean isSaveLocationChanged() {
        return !lastRememberedSaveLocation.equals(getSaveLocation());
    }
}
