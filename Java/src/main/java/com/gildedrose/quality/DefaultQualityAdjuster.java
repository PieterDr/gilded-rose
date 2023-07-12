package com.gildedrose.quality;

import com.gildedrose.Item;

public class DefaultQualityAdjuster implements QualityAdjuster {

    @Override
    public boolean supports(Item item) {
        return true;
    }

    @Override
    public void adjust(Item item) {
        item.quality = Math.max(0, item.quality - 1);
        if (item.sellIn < 1) {
            item.quality = Math.max(0, item.quality - 1);
        }
    }

}
