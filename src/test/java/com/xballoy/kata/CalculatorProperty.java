package com.xballoy.kata;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorProperty {

    @Property
    void sum_shouldBeReversible(@ForAll Integer x, @ForAll Integer y) {
        assertThat(Calculator.sum(x, y)).isEqualTo(Calculator.sum(y, x));
    }
}
