package com.gildedrose.quality;

import com.gildedrose.Item;

public class SulfurasQualityAdjuster implements QualityAdjuster {

    @Override
    public boolean supports(Item item) {
        return "Sulfuras, Hand of Ragnaros".equals(item.name);
    }

    @Override
    public void adjust(Item item) {
        return;
    }

}
