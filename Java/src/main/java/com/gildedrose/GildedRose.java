package com.gildedrose;

import com.gildedrose.quality.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item... items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            adjustQuality(item);
            adjustSellIn(item);
        }
    }

    private static void adjustSellIn(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private static void adjustQuality(Item item) {
        switch (item.name) {
            case "Aged Brie" -> new AgedBrieQualityAdjuster().adjust(item);
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePassQualityAdjuster().adjust(item);
            case "Sulfuras, Hand of Ragnaros" -> new SulfurasQualityAdjuster().adjust(item);
            default -> new DefaultQualityAdjuster().adjust(item);
        }
    }
}
