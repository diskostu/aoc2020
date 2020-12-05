package com.xballoy.kata;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorSteps {
    private final Context context;

    public CalculatorSteps() {
        this.context = new Context();
    }

    @Given("x equals to {int}")
    public void xEqualsTo(int x) {
        context.x = x;
    }

    @Given("y equals to {int}")
    public void yEqualsTo(int y) {
        context.y = y;
    }

    @When("I add x and y")
    public void iAddXAndY() {
        context.result = Calculator.sum(context.x, context.y);
    }

    @Then("the result of x plus y is {int}")
    public void theResultOfXPlusYIs(int expectedResult) {
        assertThat(context.result)
                .as("result")
                .isEqualTo(expectedResult);
    }

    private static class Context {
        public int result;
        public int x;
        public int y;
    }
}
