package cashregister;

public class FackPurchase extends Purchase{

    private String text = "";

    public FackPurchase(Item[] items) {
        super(items);
    }

    @Override
    public String asString() {
        return text;
    }

    public void setStringIWant(String message) {
        text = message;
    }
}
