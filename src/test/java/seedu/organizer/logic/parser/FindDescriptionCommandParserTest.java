package seedu.organizer.logic.parser;

import seedu.organizer.logic.commands.FindDescriptionCommand;
import seedu.organizer.logic.commands.FindDescriptionCommand;
import seedu.organizer.model.task.DescriptionContainsKeywordsPredicate;

import org.junit.Test;

import java.util.Arrays;

import static seedu.organizer.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.organizer.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.organizer.logic.parser.CommandParserTestUtil.assertParseSuccess;

public class FindDescriptionCommandParserTest {

    private FindDescriptionCommandParser parser = new FindDescriptionCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            FindDescriptionCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindDescriptionCommand() {
        // no leading and trailing whitespaces
        FindDescriptionCommand expectedFindDescriptionCommand =
                new FindDescriptionCommand(new DescriptionContainsKeywordsPredicate(Arrays.asList("cs2103", "CS2102")));
        assertParseSuccess(parser, "cs2103 CS2102", expectedFindDescriptionCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n cs2103 \n \t CS2102  \t", expectedFindDescriptionCommand);
    }
}
