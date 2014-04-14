import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by nikeshv on 12/04/14.
 */
public class TaxCalculator {

    private static final double IMPORTDUTYTAX = 0.05;
    public static final double SALESTAX = 0.1;
    ArrayList<String> exemptedProducts = new ArrayList<String>(Arrays.asList("books", "food", "medical products"));

    public double calculateSalesTax(Item item) {
        if (istaxAble(item.getName())) {
            return item.getPrice()* SALESTAX;
        }
        return 0.0;
    }

    private boolean istaxAble(String itemName) {
        if(exemptedProducts.contains(itemName.toLowerCase())){
            return false;
        }
            return true;
    }

    public double calculateImportDutyTax(Item item) {
        if(item.isImported()){
            return item.getPrice() * IMPORTDUTYTAX;
        }
        return 0.0;
    }


    public double calculateTotalTax(Item item) {
        double totalTax;
        totalTax=calculateImportDutyTax(item) + calculateSalesTax(item);
        return totalTax;

    }
}
