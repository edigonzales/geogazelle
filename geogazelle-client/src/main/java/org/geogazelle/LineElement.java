package org.geogazelle;

import org.jboss.elemento.IsElement;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;

import static org.jboss.elemento.Elements.*;

import org.jboss.elemento.InputType;

public class LineElement implements IsElement<HTMLElement> {
    private final HTMLElement root;

    public LineElement() {
        root = div().element();
        
        HTMLInputElement input = input(InputType.text).element();
        input.placeholder = "placeholder";
        
        root.appendChild(input);
    }
    
    @Override
    public HTMLElement element() {
        return root;
    }

}
