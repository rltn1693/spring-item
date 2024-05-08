package hello.item.service.domain.item;

import lombok.Data;

import java.util.Objects;

@Data
public class Item {

    //상품 ID
    private Long id;

    //상품명
    private String itemName;

    //가격
    private Integer price;

    //수량
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(itemName, item.itemName) && Objects.equals(price, item.price) && Objects.equals(quantity, item.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemName, price, quantity);
    }
}
