package duke;

public class EmptyCommandException extends Exception{
    public EmptyCommandException(String command) {
        super(String.format(Duke.LINE + "\n" + ""
                + "☹ OOPS!!! The description of a "+ command +" cannot be empty." + "\n" + Duke.LINE));
    }
}
