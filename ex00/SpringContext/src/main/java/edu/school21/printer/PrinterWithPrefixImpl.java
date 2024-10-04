package edu.school21.printer;

import edu.school21.renderer.Renderer;

public class PrinterWithPrefixImpl implements Printer{

    private Renderer renderer;
    private String prefix = "";

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void print(String text) {
        renderer.render(prefix + " " + text);
    }
}
