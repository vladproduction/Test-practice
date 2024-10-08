package org.springframework.samples.petclinic.vp.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.vp.Interpreter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("yanny")
@SpringJUnitConfig(classes = InterpreterActiveProfileTest.TestConfig.class)
public class InterpreterActiveProfileTest {

    @Configuration
    @ComponentScan("org.springframework.samples.petclinic.vp")
    static class TestConfig{
    }
    @Autowired
    Interpreter interpreter;

    @Test
    public void whatIHear() {
        String word = interpreter.whatIHear();
        assertEquals("Yanny", word);
    }

}
