package hello.item.service.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {

        //given
        Item itemA = new Item("itemA", 10000, 10);

        //when
        Item savedItem = itemRepository.save(itemA);
        System.out.println(savedItem.toString());

        //then
        Item findItem = itemRepository.findById(itemA.getId());
        System.out.println(findItem.toString());

        assertThat(savedItem).isEqualTo(findItem);

    }

    @Test
    void findAll() {

        //given
        Item itemA = new Item("itemA", 10000, 10);
        Item itemB = new Item("itemB", 20000, 20);

        itemRepository.save(itemA);
        itemRepository.save(itemB);

        //when
        List<Item> items = itemRepository.findAll();

        //then
        assertThat(items.size()).isEqualTo(2);
        assertThat(items).contains(itemA, itemB);

    }

    @Test
    void update() {

        //given
        Item itemA = new Item("itemA", 10000, 10);

        Item savedItem = itemRepository.save(itemA);

        Long id = itemA.getId();

        System.out.println(itemA.toString());

        //when

        Item updateItem = new Item("itemB", 20000, 20);

        itemRepository.update(id, updateItem);

        System.out.println(updateItem.toString());

        Item findItem = itemRepository.findById(id);

        System.out.println(findItem.toString());

        //then
        assertThat(findItem.getItemName()).isEqualTo(updateItem.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateItem.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateItem.getQuantity());

        System.out.println(itemA.hashCode());
        System.out.println(findItem.hashCode());

        System.out.println(findItem.equals(findItem));

        assertThat(itemA).isSameAs(findItem);


    }
}