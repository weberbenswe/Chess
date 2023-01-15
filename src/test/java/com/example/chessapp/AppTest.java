package com.example.chessapp;

import javafx.application.Application;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;


public class AppTest {

    private volatile boolean success = false;

    /**
     * Test that a JavaFX application launches.
     */
    @Test
    public void testMain() {
        Thread thread = new Thread() { // Wrapper thread.
            @Override
            public void run() {
                try {
                    Application.launch(App.class);
                    success = true;
                } catch(Throwable t) {
                    if(t.getCause() != null && t.getCause().getClass().equals(InterruptedException.class)) {
                        success = true;
                        return;
                    }
                    // This is not the exception we are looking for so log it.
                    Logger.getLogger(AppTest.class.getName()).log(Level.SEVERE, null, t);
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ignored) {

        }
        thread.interrupt();
        try {
            thread.join(1);
        } catch(InterruptedException ignored) {
        }
        assert(success);
    }

    @Test
    public void testLoadFXML(){

    }
}
