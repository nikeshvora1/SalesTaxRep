import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nikeshv on 12/04/14.
 */
public class TaxCalculatorTest {
    TaxCalculator taxCalculator = new TaxCalculator();

    @Test
    public void shouldReturn0TaxForLocalExemptedProduct(){
        Item item = new Item(1,"books",false,100);
        Assert.assertEquals(0.0,taxCalculator.calculateSalesTax(item),0.001);
    }

    @Test
    public void shouldReturnTaxForLocalNonExemptedProduct(){
        Item item = new Item(1,"Phone",false,100);
        Assert.assertEquals(10.0,taxCalculator.calculateSalesTax(item),0.001);
    }

    @Test
    public void shouldReturnImportDutyTax0ForLocalProduct(){
        Item item = new Item(1,"Phone",false,200);
        Assert.assertEquals(0.0, taxCalculator.calculateImportDutyTax(item),0.001);
    }
    @Test
    public void shouldReturnImportDutyTaxForImportedProduct(){
        Item item = new Item(1,"Phone",true,200);
        Assert.assertEquals(10.0, taxCalculator.calculateImportDutyTax(item),0.001);
    }

    @Test
    public void shouldReturnTaxForImportedUnexemptedProduct(){
        Item item = new Item(1,"Phone", true, 200);
        Assert.assertEquals(30.0, taxCalculator.calculateTotalTax(item),0.001);
    }
    @Test
    public void shouldReturnTaxForImportedExemptedProduct(){
        Item item = new Item(1,"books",true,300);
        Assert.assertEquals(15.00, taxCalculator.calculateTotalTax(item),0.001);
    }

}
