package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_CATEGORY_MATH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_CATEGORY_SCIENCE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.RandomCommand;


class RandomCommandParserTest {

    private RandomCommandParser parser = new RandomCommandParser();

    @Test
    void parse_validArgs_returnsRandomCommand() {
        assertParseSuccess(parser, VALID_CATEGORY_MATH, new RandomCommand(VALID_CATEGORY_MATH));
    }

    @Test
    public void parse_multipleArgs_returnsRandomCommand() {
        assertParseSuccess(parser, VALID_CATEGORY_MATH + " " + VALID_CATEGORY_SCIENCE,
                new RandomCommand(VALID_CATEGORY_SCIENCE));
    }

    @Test
    public void parse_emptyArgs_returnsRandomCommand() {
        assertParseFailure(parser, "  ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, RandomCommand.MESSAGE_USAGE));
    }
}
