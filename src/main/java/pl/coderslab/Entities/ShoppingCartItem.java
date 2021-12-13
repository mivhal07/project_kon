package pl.coderslab.Entities;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
public class ShoppingCartItem implements Cloneable {
    public String itemName;
    public int price;
    public int quantity;
    public URL descriptionURL;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(String itemName, int price,
                            int quantity, URL descriptionURL) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.descriptionURL = descriptionURL;
    }

    public void add(ShoppingCartItem otherItem) {
        this.quantity = this.quantity + otherItem.quantity;
    }

    public void subtract(ShoppingCartItem otherItem) {
        this.quantity = this.quantity - otherItem.quantity;
    }

    public int hashCode() {
        return itemName.hashCode() + price;
    }


    public boolean equals(Object other) {
        if (this == other) return true;

        if (!(other instanceof ShoppingCartItem))
            return false;

        ShoppingCartItem otherItem =
                (ShoppingCartItem) other;

        return (itemName.equals(otherItem.itemName)) &&
                (price == otherItem.price);
    }


    public ShoppingCartItem copy() {
        return new ShoppingCartItem(itemName, price,
                quantity, descriptionURL);
    }

    public String toString() {
        return itemName + " cost: " + price + " qty: " + quantity + " desc: " +
                descriptionURL;
    }
}
