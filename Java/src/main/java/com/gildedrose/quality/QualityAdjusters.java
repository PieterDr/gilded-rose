package com.gildedrose.quality;

import com.gildedrose.Item;

import java.util.List;

public class QualityAdjusters {

    private static final List<QualityAdjuster> adjusters = List.of(
            new AgedBrieQualityAdjuster(),
            new BackstagePassQualityAdjuster(),
            new SulfurasQualityAdjuster(),
            new DefaultQualityAdjuster()
    );

    public static void handle(Item item) {
        adjusters.stream()
                .filter(adjuster -> adjuster.supports(item))
                .findFirst()
                .ifPresentOrElse(
                        adjuster -> adjuster.adjust(item),
                        () -> {throw new IllegalArgumentException("Unsupported item: " + item.name);}
                );
    }

}
