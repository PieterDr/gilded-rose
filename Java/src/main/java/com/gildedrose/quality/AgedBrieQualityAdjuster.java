package com.gildedrose.quality;

import com.gildedrose.Item;

public class AgedBrieQualityAdjuster implements QualityAdjuster {

    @Override
    public void adjust(Item item) {
        item.quality = Math.min(50, item.quality + 1);
        if (item.sellIn < 1) {
            item.quality = Math.min(50, item.quality + 1);
        }
    }

}
