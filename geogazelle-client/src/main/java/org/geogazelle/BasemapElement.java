package org.geogazelle;

import org.jboss.elemento.IsElement;

import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Event;
import elemental2.dom.EventListener;

import static elemental2.dom.DomGlobal.console;
import static org.jboss.elemento.Elements.*;

public class BasemapElement implements IsElement<HTMLElement> {
    private StateManager stateManager;
    
    private final HTMLElement root;

    public BasemapElement() {
        stateManager = StateManager.getInstance();
        //stateManager.setState("activeBasemap", "schwarz-weiss");
        
        
        root = div().element();

        HTMLButtonElement button = button().element();
        button.textContent = "Push";
        
        root.appendChild(button);
        
        this.element().addEventListener("click", new EventListener() {
            @Override
            public void handleEvent(Event evt) {
                console.log("Hello from BasemapElement: Button pushed.");
                
                stateManager.setState("activeBasemap", "ortho");

            }
            
        });
    }
    
    @Override
    public HTMLElement element() {
        return root;
    }

}
