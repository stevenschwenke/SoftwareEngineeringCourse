package designPatterns.strategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    @Test
    void lambdasRemoveBoilerplateCodeInStrategyPattern() {

        // Strategy pattern "usual" implementation:
        Validator v1 = new Validator(new IsNumeric());
        assertThat(v1.validate("aaa")).isFalse();

        Validator v2 = new Validator(new IsAllLowerCase());
        assertThat(v2.validate("aaa")).isTrue();

        // Strategy pattern with lambdas:
        // ValidationStrategy = functional interface, hence this is possible:
        Validator v3 = new Validator((String s) -> s.matches("\\d+"));
        assertThat(v3.validate("aaa")).isFalse();
        // => Lambdas remove boilerplate code
    }
}