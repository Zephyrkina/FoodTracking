package ua.training.model.exception;

public class ExceededCalorieNormException extends RuntimeException {

    public ExceededCalorieNormException() {
    }

    public ExceededCalorieNormException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
