package com.gildedrose.quality;

import com.gildedrose.Item;

public class AgedBrieQualityAdjuster implements QualityAdjuster {

    @Override
    public boolean supports(Item item) {
        return "Aged Brie".equals(item.name);
    }

    @Override
    public void adjust(Item item) {
        item.quality = Math.min(50, item.quality + getAdjustment(item));
    }

    private int getAdjustment(Item item) {
        if (item.sellIn >= 0) return 1;
        else return 2;
    }
}
