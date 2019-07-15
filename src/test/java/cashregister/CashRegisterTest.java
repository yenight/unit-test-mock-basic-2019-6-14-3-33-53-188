package cashregister;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
        FakePrinter printer = new FakePrinter();
        CashRegister cashRegister = new CashRegister(printer);
        Item[] items = {new Item("a", 10), new Item("b", 20)};
        Purchase purchase = new Purchase(items);
        //when
        //Throwable throwable = Assertions.assertThrows(UnsupportedOperationException.class, () -> cashRegister.process(purchase));
        cashRegister.process(purchase);
        //then
        Assertions.assertTrue(printer.methodWasCalled());
        //Assertions.assertEquals("Not Implemented", throwable.getMessage());
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        FakePrinter printer = new FakePrinter();
        CashRegister cashRegister = new CashRegister(printer);
        Item[] items = {new Item("a", 10), new Item("b", 20)};
        FackPurchase purchase = new FackPurchase(items);
        //when
        cashRegister.process(purchase);
        //then
        Assertions.assertEquals(purchase.asString(), printer.methodCalledReturnMessage());
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        Printer printer = Mockito.mock(Printer.class);
        Purchase purchase = Mockito.mock(Purchase.class);
        Item[] items = {new Item("a", 10), new Item("b", 20)};
        CashRegister cashRegister = new CashRegister(printer);
        when(purchase.asString()).thenReturn("666");

        //when
        cashRegister.process(purchase);

        //then
        verify(printer).print("666");

    }

}
