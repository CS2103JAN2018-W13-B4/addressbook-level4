package guitests.guihandles;

import javafx.scene.Node;
import javafx.scene.control.Label;

//@@author guekling
/**
 * Provides a handle to a entry card in the calendar panel.
 */
public class EntryCardHandle extends NodeHandle<Node> {
    private static final String ENTRY_CARD_ID = "#entryCard";

    private final Label entryCardLabel;

    public EntryCardHandle(Node cardNode) {
        super(cardNode);

        this.entryCardLabel = getChildNode(ENTRY_CARD_ID);
    }

    public String getEntryCardText() {
        return entryCardLabel.getText();
    }
}
