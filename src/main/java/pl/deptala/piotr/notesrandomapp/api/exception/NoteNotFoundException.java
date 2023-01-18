package pl.deptala.piotr.notesrandomapp.api.exception;

public class NoteNotFoundException extends NoteException {

    public NoteNotFoundException(String message) {
        super(message);
    }


    public NoteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
