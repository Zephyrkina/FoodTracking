package ua.training.model.exception;

public class ItemAlreadyExists extends RuntimeException {

    public ItemAlreadyExists() {
    }

    public ItemAlreadyExists(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
