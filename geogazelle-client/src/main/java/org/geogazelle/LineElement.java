package org.geogazelle;

import org.jboss.elemento.IsElement;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;

import static elemental2.dom.DomGlobal.console;
import static org.jboss.elemento.Elements.*;

import org.jboss.elemento.InputType;

public class LineElement implements IsElement<HTMLElement> {
    private StateManager stateManager;
    private ConfigManager configManager;

    private final HTMLElement root;

    public LineElement() {
        stateManager = StateManager.getInstance(); 
        configManager = ConfigManager.getInstance();
        
        root = div().element();
        
        HTMLInputElement input = input(InputType.text).element();
        input.placeholder = "placeholder";
        
        stateManager.subscribe("activeBasemap", (oldBasemap, newBasemap) ->
            onChangeProjection(oldBasemap, newBasemap)
        );
        
        // TODO Noch nicht sicher, ob das so funktioniert:
        // Wird alles richtig konfiguriert und gerendert?
        this.configManager.loadConfig().then(obj -> {
            
            String id = configManager.getConfig().basemaps[1].id;
            console.log("basemap id from LineElement:" + id);

            root.appendChild(input);            
            return null;
        });
        
    }
    
    @Override
    public HTMLElement element() {
        return root;
    }
    
    private void onChangeProjection(String oldBasemap, String newBasemap) {
        console.log("Hello from LineElement. Trigger by Basemap.");
        console.log(oldBasemap + " || " + newBasemap);
    }
}
