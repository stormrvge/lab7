package commands;

public class PermissionDeniedException extends Exception {
    public PermissionDeniedException() {
        super("Permission denied.");
    }
}
