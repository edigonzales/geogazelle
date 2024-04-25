package org.geogazelle;

import org.jboss.elemento.IsElement;

import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLElement;

import static org.jboss.elemento.Elements.*;

public class BasemapElement implements IsElement<HTMLElement> {
    private final HTMLElement root;

    public BasemapElement() {
        root = div().element();

        HTMLButtonElement button = button().element();
        button.textContent = "Push";
        
        root.appendChild(button);
    }
    
    @Override
    public HTMLElement element() {
        return root;
    }

}
