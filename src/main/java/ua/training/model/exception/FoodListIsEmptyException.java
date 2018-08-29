package ua.training.model.exception;

public class FoodListIsEmptyException extends RuntimeException {

    public FoodListIsEmptyException() {
    }

    public FoodListIsEmptyException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
