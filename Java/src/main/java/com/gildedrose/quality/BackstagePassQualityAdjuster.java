package com.gildedrose.quality;

import com.gildedrose.Item;

public class BackstagePassQualityAdjuster implements QualityAdjuster {

    @Override
    public boolean supports(Item item) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(item.name);
    }

    @Override
    public void adjust(Item item) {
        item.quality = Math.min(50, item.quality + getAdjustment(item));
    }

    private int getAdjustment(Item item) {
        if (item.sellIn >= 10) return 1;
        if (item.sellIn >= 5) return 2;
        if (item.sellIn >= 0) return 3;
        return -item.quality;
    }

}
