package com.example.chessapp;

import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.hasChildren;


public class AppTest extends ApplicationTest {

    private volatile boolean success = false;

    /**
     * Test that a JavaFX application launches.
     */
    @Override
    public void start(Stage stage) throws Exception {
        new App().start(stage);
    }

    @Test
    public void testStart() {
        verifyThat("#root", hasChildren(1));
    }
}
