package com.gildedrose.quality;

import com.gildedrose.Item;

public class DefaultQualityAdjuster implements QualityAdjuster {

    @Override
    public boolean supports(Item item) {
        return true;
    }

    @Override
    public void adjust(Item item) {
        item.quality = Math.max(0, item.quality + getAdjustment(item));
    }

    private int getAdjustment(Item item) {
        if (item.sellIn > 0) return -1;
        else return -2;
    }

}
