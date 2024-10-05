package edu.school21.application;

import edu.school21.printer.Printer;
import edu.school21.printer.PrinterWithPrefixImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Printer printer = context.getBean("printerWithPrefix", PrinterWithPrefixImpl.class);
        printer.print("hello");
        context.close();
    }
}