/**
 * Created by nikeshv on 12/04/14.
 */
public class Item {
    private int quantity;
    private String name;
    private boolean isImported;
    private double price;
    private double tax;

        public Item(int quantity, String name, boolean isImported, double price) {
        this.quantity = quantity;
        this.name = name;
        this.isImported = isImported;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean isImported) {
        this.isImported = isImported;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
