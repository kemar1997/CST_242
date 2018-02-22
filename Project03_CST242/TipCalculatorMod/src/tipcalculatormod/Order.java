package tipcalculatormod;

/**
 *
 * @author kemar & woonnie & sophia
 */
public class Order {
    String item;
    int price;
    
    public Order() {
        this("", 0);
    }
    
    /**
     * Sets values for item and price to the values of the parameters.
     * 
     * @param item the item of the order
     * @param price the price of the item
     */
    public Order(String item, int price) {
        setItem(item);
        setPrice(price);
    }
    
    /**
     * Updates the item field.
     * 
     * @param item the item of the order
     */
    public void setItem (String item) {
        this.item = item;
    }
    
    /**
     * Updates the price field.
     * 
     * @param price the price of the item
     */
    public void setPrice (int price) {
        if (price > 0) {
            this.price = price;
        }
    }
    
    /**
     * Retrieves the item field.
     * 
     * @return the item of the order
     */
    public String getItem() {
        return item;
    }
    
    /**
     * Retrieves the price field.
     * 
     * @return the price of the item ordered
     */
    public int getPrice() {
        return price;
    }
}
