import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ParserTest {
    Parser parser = new Parser();
    String itemString = "10 books at Rs.232";


    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void shouldIdentifyQuantityInInputString(){
        Item item = parser.getItem(itemString);
        assertEquals(10, item.getQuantity());
    }

    @Test
    public void shouldIdentifyQuantityInADifferentString(){
        String itemString = "20 movies at Rs.100";
        Item item = parser.getItem(itemString);
        assertEquals(20,item.getQuantity());
    }

    @Test
    public void shouldIdentifyTheNameOfTheItem() throws Exception {
        String itemString = "20 movies at Rs.100";
        Item item=parser.getItem(itemString);
        assertEquals("movies",item.getName());

    }

    @Test
    public void shouldIdentifyNameForADifferentString() throws Exception {
        String itemString = "10 books at Rs.232";
        Item item = parser.getItem(itemString);
        assertEquals("books", item.getName());
    }

    @Test
    public void shouldIdentifyNameForAStringWithoutImported() throws Exception {
        String itemString = "10 imported choclate at Rs.232";
        Item item = parser.getItem(itemString);
        assertEquals("choclate", item.getName());
    }
}


