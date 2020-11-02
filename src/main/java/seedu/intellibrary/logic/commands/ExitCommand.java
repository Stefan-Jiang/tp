package seedu.intellibrary.logic.commands;

import seedu.intellibrary.model.Model;

/**
 * Terminates the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_EXIT_ACKNOWLEDGEMENT = "Exiting Address Book as requested ...";

    @Override
    public CommandResult execute(Model model) {
        assert model != null;
        return new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT, false, true);
    }

}