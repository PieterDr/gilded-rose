package com.gildedrose.quality;

import com.gildedrose.Item;

public class ConjuredItemQualityAdjuster implements QualityAdjuster {

    @Override
    public boolean supports(Item item) {
        return "Conjured item".equals(item.name);
    }

    @Override
    public void adjust(Item item) {
        item.quality = Math.max(0, item.quality + getAdjustment(item));
    }

    private int getAdjustment(Item item) {
        if (item.sellIn > 0) return -2;
        else return -4;
    }

}
