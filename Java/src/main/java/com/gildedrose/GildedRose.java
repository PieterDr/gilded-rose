package com.gildedrose;

import com.gildedrose.quality.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item... items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            adjustSellIn(item);
            adjustQuality(item);
        }
    }

    private void adjustSellIn(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void adjustQuality(Item item) {
        QualityAdjusters.handle(item);
    }
}
