package com.xballoy.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void shouldAddInteger() {
        // Arrange
        final int x = 6;
        final int y = 4;

        // Act
        final int result = Calculator.sum(x, y);

        // Assert
        assertThat(result).isEqualTo(10);
    }
}
