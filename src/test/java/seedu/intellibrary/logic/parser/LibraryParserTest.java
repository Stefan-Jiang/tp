package seedu.intellibrary.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.intellibrary.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.intellibrary.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.intellibrary.logic.parser.CliSyntax.PREFIX_TIMES;
import static seedu.intellibrary.testutil.Assert.assertThrows;
import static seedu.intellibrary.testutil.TypicalIndexes.INDEX_FIRST_BOOK;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.intellibrary.logic.commands.ClearCommand;
import seedu.intellibrary.logic.commands.DeleteCommand;
import seedu.intellibrary.logic.commands.ExitCommand;
import seedu.intellibrary.logic.commands.FindCommand;
import seedu.intellibrary.logic.commands.HelpCommand;
import seedu.intellibrary.logic.commands.ListCommand;
import seedu.intellibrary.logic.commands.TimesCommand;
import seedu.intellibrary.logic.parser.exceptions.ParseException;
import seedu.intellibrary.model.book.NameContainsKeywordsPredicate;
import seedu.intellibrary.model.book.Times;

public class LibraryParserTest {

    private final LibraryParser parser = new LibraryParser();

    /* @Test
    public void parseCommand_add() throws Exception {
        Book book = new BookBuilder().build();
        AddCommand command = (AddCommand) parser.parseCommand(BookUtil.getAddCommand(book));
        assertEquals(new AddCommand(book), command);
    } //After implementation of edit */

    @Test
    public void parseCommand_clear() throws Exception {
        assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD) instanceof ClearCommand);
        assertTrue(parser.parseCommand(ClearCommand.COMMAND_WORD + " 3") instanceof ClearCommand);
    }

    @Test
    public void parseCommand_delete() throws Exception {
        DeleteCommand command = (DeleteCommand) parser.parseCommand(
                DeleteCommand.COMMAND_WORD + " " + INDEX_FIRST_BOOK.getOneBased());
        assertEquals(new DeleteCommand(INDEX_FIRST_BOOK), command);
    }

    /* @Test
    public void parseCommand_edit() throws Exception {
        Book book = new BookBuilder().build();
        EditCommand.EditBookDescriptor descriptor = new EditBookDescriptorBuilder(book).build();
        EditCommand command = (EditCommand) parser.parseCommand(EditCommand.COMMAND_WORD + " "
                + INDEX_FIRST_BOOK.getOneBased() + " " + BookUtil.getEditBookDescriptorDetails(descriptor));
        assertEquals(new EditCommand(INDEX_FIRST_BOOK, descriptor), command);
    } // After implementation of Edit */

    @Test
    public void parseCommand_exit() throws Exception {
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD) instanceof ExitCommand);
        assertTrue(parser.parseCommand(ExitCommand.COMMAND_WORD + " 3") instanceof ExitCommand);
    }

    @Test
    public void parseCommand_find() throws Exception {
        List<String> keywords = Arrays.asList("foo", "bar", "baz");
        FindCommand command = (FindCommand) parser.parseCommand(
                FindCommand.COMMAND_WORD + " " + keywords.stream().collect(Collectors.joining(" ")));
        assertEquals(new FindCommand(new NameContainsKeywordsPredicate(keywords)), command);
    }

    @Test
    public void parseCommand_help() throws Exception {
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD) instanceof HelpCommand);
        assertTrue(parser.parseCommand(HelpCommand.COMMAND_WORD + " 3") instanceof HelpCommand);
    }

    @Test
    public void parseCommand_list() throws Exception {
        assertTrue(parser.parseCommand(ListCommand.COMMAND_WORD) instanceof ListCommand);
        assertTrue(parser.parseCommand(ListCommand.COMMAND_WORD + " 3") instanceof ListCommand);
    }

    @Test
    public void parseCommand_times() throws Exception {
        final Times times = new Times("20");
        TimesCommand command = (TimesCommand) parser.parseCommand(TimesCommand.COMMAND_WORD + " "
                + INDEX_FIRST_BOOK.getOneBased() + " " + PREFIX_TIMES + times.value);
        assertEquals(new TimesCommand(INDEX_FIRST_BOOK, times), command);
    }

    @Test
    public void parseCommand_unrecognisedInput_throwsParseException() {
        assertThrows(ParseException.class, String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE), ()
            -> parser.parseCommand(""));
    }

    @Test
    public void parseCommand_unknownCommand_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, () -> parser.parseCommand("unknownCommand"));
    }
}