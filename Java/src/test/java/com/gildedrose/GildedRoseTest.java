package com.gildedrose;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void allItemsInTheShopAreUpdated() {
        Item item1 = new Item("Item1", 1, 1);
        Item item2 = new Item("Item2", 2, 2);
        Item item3 = new Item("Item3", 3, 3);
        GildedRose app = new GildedRose(item1, item2, item3);

        app.updateQuality();

        Assertions.assertThat(item1.sellIn).isEqualTo(0);
        Assertions.assertThat(item2.sellIn).isEqualTo(1);
        Assertions.assertThat(item3.sellIn).isEqualTo(2);
    }

    @ParameterizedTest(name = "{3}")
    @CsvSource(delimiter = '|', value = {
            "Normal item                               | 10 | 9 | Normal item sellIn decreases by 1",
            "Aged Brie                                 | 10 | 9 | Aged Brie sellIn decreases by 1",
            "Backstage passes to a TAFKAL80ETC concert | 10 | 9 | Backstage pass sellIn decreases by 1",
            "Sulfuras, Hand Of Ragnaros                | 10 | 9 | Sulfuras sellIn does not change",
    })
    void sellInOfItemsIsUpdatedCorrectly(String name, int initialSellIn, int expectedSellIn, String displayName) {
        Item item = new Item(name, initialSellIn, 0);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(expectedSellIn);
    }

    @ParameterizedTest(name = "{4}")
    @CsvSource(delimiter = '|', value = {
            "Normal item                               | 10 | 20 | 19 | Normal item quality decreases by 1",
            "Normal item                               | 0  | 20 | 18 | Normal item quality decreases by 2 when it expires",
            "Normal item                               | -1 | 20 | 18 | Normal item quality decreases by 2 if it is expired",
            "Normal item                               | 10 | 0  | 0  | Normal item quality cannot drop below 0",
            "Aged Brie                                 | 10 | 20 | 21 | Aged Brie quality increases by 1",
            "Aged Brie                                 | 0  | 20 | 22 | Aged Brie quality increases by 2 when it expires",
            "Aged Brie                                 | -1 | 20 | 22 | Aged Brie quality increases by 2 if it is expired",
            "Aged Brie                                 | 10 | 49 | 50 | Aged Brie quality cannot exceed 50",
            "Aged Brie                                 | -1 | 49 | 50 | Aged Brie quality cannot exceed 50, even when expired",
            "Backstage passes to a TAFKAL80ETC concert | 11 | 30 | 31 | Backstage pass quality increases by 1 if more than 10 days left",
            "Backstage passes to a TAFKAL80ETC concert | 10 | 30 | 32 | Backstage pass quality increases by 2 if 10 days left",
            "Backstage passes to a TAFKAL80ETC concert | 8  | 30 | 32 | Backstage pass quality increases by 2 if 8 days left",
            "Backstage passes to a TAFKAL80ETC concert | 6  | 30 | 32 | Backstage pass quality increases by 2 if 6 days left",
            "Backstage passes to a TAFKAL80ETC concert | 5  | 30 | 33 | Backstage pass quality increases by 3 if 5 days left",
            "Backstage passes to a TAFKAL80ETC concert | 3  | 30 | 33 | Backstage pass quality increases by 3 if 3 days left",
            "Backstage passes to a TAFKAL80ETC concert | 1  | 30 | 33 | Backstage pass quality increases by 3 if 1 day left",
            "Backstage passes to a TAFKAL80ETC concert | 1  | 49 | 50 | Backstage pass quality cannot exceed 50",
            "Backstage passes to a TAFKAL80ETC concert | 0  | 30 | 0  | Backstage pass becomes worthless after the concert",
            "Backstage passes to a TAFKAL80ETC concert | -1 | 30 | 0  | Backstage pass stays worthless after the concert",
            "Sulfuras, Hand of Ragnaros                | 40 | 80 | 80 | Sulfuras quality does not change",
    })
    void qualityOfItemsIsUpdatedCorrectly(String name, int initialSellIn, int initialQuality, int expectedQuality, String displayName) {
        Item item = new Item(name, initialSellIn, initialQuality);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertThat(item.quality).isEqualTo(expectedQuality);
    }

}
