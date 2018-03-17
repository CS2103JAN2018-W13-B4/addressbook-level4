package seedu.organizer.logic.parser;

import seedu.organizer.logic.commands.FindDeadlineCommand;
import seedu.organizer.model.task.DeadlineContainsKeywordsPredicate;

import org.junit.Test;

import java.util.Arrays;

import static seedu.organizer.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.organizer.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.organizer.logic.parser.CommandParserTestUtil.assertParseSuccess;

//@@author guekling
public class FindDeadlineCommandParserTest {

    private FindDeadlineCommandParser parser = new FindDeadlineCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                FindDeadlineCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindDeadlineCommand() {
        // no leading and trailing whitespaces
        FindDeadlineCommand expectedFindDeadlineCommand =
            new FindDeadlineCommand(new DeadlineContainsKeywordsPredicate(Arrays.asList("2018-09-09",
            "2018-01-01")));
        assertParseSuccess(parser, "2018-09-09 2018-01-01", expectedFindDeadlineCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n 2018-09-09 \n \t 2018-01-01 \t", expectedFindDeadlineCommand);
    }
}
