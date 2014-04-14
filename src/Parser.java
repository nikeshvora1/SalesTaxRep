/**
 * Created by nikeshv on 12/04/14.
 */
public class Parser {

    public Item getItem(String inputString) {
        Item item=new Item(1,"abc",true,2);
        String [] itemString= inputString.split(" ");
        item.setQuantity(Integer.parseInt(itemString[0]));
        item.setName(itemString[1]);
        return item;

    }
}
