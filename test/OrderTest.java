import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class OrderTest {
    private Order order;
    private TaxCalculator mockTaxCalculator;

    @Before
    public void setUp() throws Exception {
        mockTaxCalculator=mock(TaxCalculator.class);
        order=new Order(mockTaxCalculator);

    }

    @Test
    public void shouldReturnTotalPriceWithTax() throws Exception {
        Item item=new Item(1,"Phone",true,100);
        given(mockTaxCalculator.calculateTotalTax(item)).willReturn(15.00);

        assertThat(order.calculateTotal(item), is(115.00));

    }

    @Test
    public void shouldReturnTotalPriceForMultipleQuantity(){
        Item item = new Item(3,"books",true,300);
        given(mockTaxCalculator.calculateTotalTax(item)).willReturn(15.00);
        assertThat(order.calculateTotal(item), is(945.0));
    }

    @Test
    public void shouldReturnTheNamePriceQuantityAndTotalAmount() throws Exception {
        Item item = new Item(3,"books",true,300);
        given(mockTaxCalculator.calculateTotalTax(item)).willReturn(15.00);
        assertThat(order.getBillForItem(item),is("3 books 300.0 945.0"));

    }

    @Test
    public void shouldReturnListOfBillsForMultipleItems(){

        Item item1 = new Item(5,"cars",false,100);
        Item item2 = new Item(10,"bikes",true,100);

        List<Item> listOfItems = new ArrayList<Item>();
        List<String> listOfItemBills = new ArrayList<String>();

        listOfItems.add(item1);
        listOfItems.add(item2);

        given(mockTaxCalculator.calculateTotalTax(item1)).willReturn(10.00);
        given(mockTaxCalculator.calculateTotalTax(item2)).willReturn(15.00);

        listOfItemBills.add("5 cars 100.0 550.0");
        listOfItemBills.add("10 bikes 100.0 1150.0");

        assertThat(order.getBillForOrder(listOfItems), is(listOfItemBills));

    }
}
