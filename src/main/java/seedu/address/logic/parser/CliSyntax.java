package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");
    public static final Prefix PREFIX_FILE = new Prefix("f/");
    public static final Prefix PREFIX_EVENT_TAG = new Prefix("t/E-");
    public static final Prefix PREFIX_START_DATE = new Prefix("sd/");
    public static final Prefix PREFIX_END_DATE = new Prefix("ed/");
    public static final Prefix PREFIX_DESCRIPTION = new Prefix("dc/");
}
