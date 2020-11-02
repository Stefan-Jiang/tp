package seedu.intellibrary.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.intellibrary.commons.core.Messages.MESSAGE_BOOKS_LISTED_OVERVIEW;
import static seedu.intellibrary.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.intellibrary.testutil.TypicalBooks.ELLE;
import static seedu.intellibrary.testutil.TypicalBooks.getTypicalLibrary;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.intellibrary.model.Model;
import seedu.intellibrary.model.ModelManager;
import seedu.intellibrary.model.UserPrefs;
import seedu.intellibrary.model.book.NameContainsKeywordsPredicate;
import seedu.intellibrary.ui.Mode;

/**
 * Contains integration tests (interaction with the Model) and unit tests for StockCommand.
 */
class StockCommandTest {
    private Model model = new ModelManager(getTypicalLibrary(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalLibrary(), new UserPrefs());

    @Test
    void execute_oneKeyword_oneBookFound() {
        String expectedMessage = String.format(MESSAGE_BOOKS_LISTED_OVERVIEW, 1);
        NameContainsKeywordsPredicate nameContainsKeywordsPredicate =
                new NameContainsKeywordsPredicate(Arrays.asList("Elle"));
        expectedModel.updateFilteredBookList(nameContainsKeywordsPredicate, Mode.NORMAL);
        StockCommand stockCommand = new StockCommand(Arrays.asList("Elle"), null);
        assertCommandSuccess(stockCommand, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(ELLE), model.getFilteredBookList());

    }
}
