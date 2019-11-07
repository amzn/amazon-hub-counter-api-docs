package com.amazon.sample;

import amazon.platform.config.AppConfig;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.concurrent.TimeUnit;

/**
 * Application class that launcher invokes
 */
public class Amazon_hub_counter_api_docs {

    private static final String APP_NAME = "Amazon-hub-counter-api-docs";
    private static final int TEN_SECONDS = (int)TimeUnit.SECONDS.toMillis(10);

    public static void main(String[] args) throws InterruptedException {
        
        initAppConfig(args);

        String root = System.getProperty("root");
        String realm = AppConfig.getRealm().name();
        String domain = AppConfig.getDomain();

        Injector injector = Guice.createInjector(new Amazon_hub_counter_api_docsModule(root, domain, realm));

        HelloWorld helloWorld = injector.getInstance(HelloWorld.class);
        helloWorld.run();
        
      }

      private static void initAppConfig(String[] args) throws InterruptedException {
        verifyArguments(args);

        AppConfig.initialize(APP_NAME, null, args);
    }

    private static void verifyArguments(String[] args) throws InterruptedException {
        boolean hasRealm = false;
        boolean hasDomain = false;
        boolean hasRoot = false;

        for (String arg : args) {
            if (arg.startsWith("--realm=")) {
                hasRealm = true;
            } else if (arg.startsWith("--domain=")) {
                hasDomain = true;
            } else if (arg.startsWith("--root=")) {
                hasRoot = true;
            }
        }

        if (hasRealm && hasDomain && hasRoot) {
            return;
        } else {
            System.out.println("The service cannot determine what environment it is running in and will shut down.");
            System.out.println("If you are trying to run from an Eclipse workspace, add the following");
            System.out.println("program arguments to your launch configuration: ");
            System.out.println("");
            System.out.println("--domain=test --realm=USAmazon --root=build/private");
            Thread.sleep(TEN_SECONDS); // Wait a while to avoid flapping at full speed (in case this happens in Apollo)
            System.exit(0);
        }
    }

}
