package cashregister;

public class FakePrinter extends Printer{
    private boolean isCalled = false;
    private String message = "";

    public void print(String printThis) {
        message = printThis;
        isCalled = true;
    }

    public boolean methodWasCalled() {
        return isCalled;
    }

    public String methodCalledReturnMessage() {
        return message;
    }
}
