package com.amazon.sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for application class
 */
public class HelloWorldTest {

    private HelloWorld helloWorld;
    
    private static final int NUM_ITERATIONS = 1;

    @Before
    public void initialize() {    
        helloWorld = new HelloWorld(NUM_ITERATIONS);
    }

    /**
     * Test to make sure run method of application doesnt throw any exceptions
     */    
    @Test
    public void test_runDoesntThrowAnyExceptions() {
        try {
            helloWorld.run();
        } catch (InterruptedException e) {
            Assert.fail("Sample application got terminated incorrectly");
        }
    }

}
