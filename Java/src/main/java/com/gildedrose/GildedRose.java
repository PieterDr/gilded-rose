package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item... items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    item.quality = Math.min(50, item.quality + 1);
                    if (item.sellIn < 1) {
                        item.quality = Math.min(50, item.quality + 1);
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    item.quality = Math.min(50, item.quality + 1);
                    if (item.sellIn < 11) {
                        item.quality = Math.min(50, item.quality + 1);
                    }
                    if (item.sellIn < 6) {
                        item.quality = Math.min(50, item.quality + 1);
                    }
                    if (item.sellIn < 1) {
                        item.quality = 0;
                    }
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    item.quality = Math.max(0, item.quality - 1);
                    if (item.sellIn < 1) {
                        item.quality = Math.max(0, item.quality - 1);
                    }
                    break;
            }

            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            } else {
                item.sellIn = item.sellIn - 1;
            }
        }
    }
}
