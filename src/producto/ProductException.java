package producto;

public class ProductException extends Exception {

    public ProductException() {
    }

    public ProductException(String message) {
        super(message);
    }

    public ProductException(Throwable cause) {
        super(cause);
    }

    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }

}