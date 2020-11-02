package seedu.intellibrary.logic.parser;

import static seedu.intellibrary.logic.commands.CommandTestUtil.NAME_DESC_AMY;
import static seedu.intellibrary.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.intellibrary.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.intellibrary.logic.commands.StockCommand;

class StockCommandParserTest {

    private StockCommandParser stockCommandParser = new StockCommandParser();

    @Test
    void parse_validArgs_returnsStockCommand() {
        assertParseSuccess(stockCommandParser,
                NAME_DESC_AMY,
                new StockCommand(Arrays.asList(VALID_NAME_AMY.split("\\s+")), null));
    }
}
