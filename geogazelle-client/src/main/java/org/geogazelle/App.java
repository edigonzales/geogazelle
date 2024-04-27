package org.geogazelle;

import static elemental2.dom.DomGlobal.console;
import static org.jboss.elemento.Elements.*;

import com.google.gwt.core.client.EntryPoint;

import org.dominokit.domino.ui.themes.DominoThemeManager;
import org.dominokit.domino.ui.themes.DominoThemeAccent;
import org.dominokit.domino.ui.themes.DominoThemeLight;

import org.dominokit.domino.ui.forms.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        ConfigManager configManager = ConfigManager.getInstance();
        configManager.loadConfig();
        console.log("Hallo Config");
        
        DominoThemeManager.INSTANCE.apply(DominoThemeLight.INSTANCE);
        DominoThemeManager.INSTANCE.apply(DominoThemeAccent.RED); 

        console.log("Hallo Stefan.");

        body().add(TextBox.create().setLabel("User name")
                                .setPlaceholder("Username").element());
        
        
        BasemapElement basemapElement = new BasemapElement();
        body().add(basemapElement);
        
        LineElement lineElement = new LineElement();
        body().add(lineElement);
        

    }
}