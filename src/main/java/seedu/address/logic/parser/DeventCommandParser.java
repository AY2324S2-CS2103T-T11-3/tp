package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.DeventCommand;
import seedu.address.logic.parser.exceptions.ParseException;
/**
 * Parser for the devent command.
 */
public class DeventCommandParser {
    /**
     * Parses the given {@code String} of arguments in the context of the DeventCommand
     * and returns a DeventCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeventCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeventCommand.MESSAGE_USAGE));
        }
        String[] nameKeywords = trimmedArgs.split(" ");
        if (nameKeywords.length != 1) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeventCommand.MESSAGE_USAGE));
        }
        String tagName = nameKeywords[0];
        return new DeventCommand(tagName);
    }
}
