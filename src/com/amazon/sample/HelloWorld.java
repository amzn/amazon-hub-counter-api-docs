package com.amazon.sample;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;

public class HelloWorld {

    private static final Logger LOG = LogManager.getLogger(HelloWorld.class);

    private final int numIterations;
    
    @Inject
    public HelloWorld(@Named("Amazon-hub-counter-api-docs.numIterations") int numIterations){
        this.numIterations = numIterations;
    }

    public void run() throws InterruptedException {
    
        LOG.info("Initializing application");
        
        for (int i = 0; i < numIterations; i++) {
        
            sleep();

        }
        
        LOG.info("All " + numIterations + " iterations successfully finished. Exiting");
        
    }
    
    private int sleep() throws InterruptedException {

        Random random = new Random();
        int sleepTime = random.nextInt(1000);
        LOG.info("Sleeping for " + sleepTime + " ms before next iteration");
        Thread.sleep(sleepTime);

        return sleepTime;

    }

}
