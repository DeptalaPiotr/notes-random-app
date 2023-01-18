package pl.deptala.piotr.notesrandomapp.api.exception;

public class NoteException extends Exception{

    public NoteException(String message) {
        super(message);
    }

    public NoteException(String message, Throwable cause) {
        super(message, cause);
    }
}
