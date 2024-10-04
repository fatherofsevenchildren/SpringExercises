package edu.school21.application;

import edu.school21.preprocessor.PreProcessor;
import edu.school21.preprocessor.PreProcessorToUpperImpl;
import edu.school21.printer.PrinterWithPrefixImpl;
import edu.school21.renderer.Renderer;
import edu.school21.renderer.RendererErrImpl;

public class Application {
    public static void main(String[] args) {
        PreProcessor preProcessor = new PreProcessorToUpperImpl();
        Renderer renderer = new RendererErrImpl(preProcessor);
        PrinterWithPrefixImpl printer = new PrinterWithPrefixImpl(renderer);
        printer.setPrefix("Prefix");
        printer.print("Hello!");
    }
}