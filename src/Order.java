import java.util.ArrayList;
import java.util.List;

public class Order {
    TaxCalculator taxCalculator;


    public Order(TaxCalculator taxCalculator) {
        this.taxCalculator=taxCalculator;
    }

    public double calculateTotal(Item item) {

        setTotalTax(item);
        double priceWithTax = item.getPrice() + item.getTax();
        return item.getQuantity() * priceWithTax;
    }

    private void setTotalTax(Item item) {
        item.setTax(taxCalculator.calculateTotalTax(item));
    }

    public String getBillForItem(Item item) {
        return item.getQuantity() + " " + item.getName() + " " + item.getPrice() + " " + calculateTotal(item);

    }

    public List<String> getBillForOrder(List<Item> items) {
        List<String> bill=new ArrayList<String>();
        for(Item item: items)
        {
            bill.add(getBillForItem(item));
        }
        return bill;
    }
}
