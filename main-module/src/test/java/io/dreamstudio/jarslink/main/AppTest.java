package io.dreamstudio.jarslink.main;

import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Ricky Fung
 */
public class AppTest {

    @Test
    public void testApp() throws MalformedURLException {
        File file = new File("/");
        URL url = new URL(file.toURI().toString());
        System.out.println(url);
    }
}
