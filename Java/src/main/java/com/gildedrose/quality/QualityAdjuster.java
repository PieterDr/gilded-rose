package com.gildedrose.quality;

import com.gildedrose.Item;

interface QualityAdjuster {

    boolean supports(Item item);
    void adjust(Item item);

}
