package com.colors.colors.config;

import com.colors.colors.BluePrinter;
import com.colors.colors.ColorPrinter;
import com.colors.colors.GreenPrinter;
import com.colors.colors.Impl.*;
import com.colors.colors.RedPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration
public class PrinterConfig {

    @Bean
    public BluePrinter bluePrinter() {
        return new ItalianBluePrinter();
    }

    @Bean
    public RedPrinter redPrinter() {
        return new ItalianRedPrinter();
    }

    @Bean
    public GreenPrinter greenPrinter() {
        return new ItalianGreenPrinter();
    }

    @Bean
    public ColorPrinter colorPrinter(RedPrinter redPrinter, BluePrinter bluePrinter, GreenPrinter greenPrinter) {
        return new ColorPrinterImpl(redPrinter, bluePrinter, greenPrinter);
    }
}
