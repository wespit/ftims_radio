/*
 * FtimsRadioApp.java
 */

package ftimsradio;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class FtimsRadioApp extends SingleFrameApplication {

    private RadioView view;
    private RadioControl controler;
    
    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        view = new RadioView();
        controler = new RadioControl(view);

        view.show(true);
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of FtimsRadioApp
     */
    public static FtimsRadioApp getApplication() {
        return Application.getInstance(FtimsRadioApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(FtimsRadioApp.class, args);
    }
}
