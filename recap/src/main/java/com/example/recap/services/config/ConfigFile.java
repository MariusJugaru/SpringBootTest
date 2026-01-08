package com.example.recap.services.config;

import com.example.recap.services.BluePrinter;
import com.example.recap.services.ColorPrinter;
import com.example.recap.services.RedPrinter;
import com.example.recap.services.YellowPrinter;
import com.example.recap.services.impl.BluePrinterImpl;
import com.example.recap.services.impl.ColorPrinterImpl;
import com.example.recap.services.impl.RedPrinterImpl;
import com.example.recap.services.impl.YellowPrinterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigFile {

    @Bean
    public BluePrinter bluePrinter() {
        return new BluePrinterImpl();
    }

    @Bean
    public RedPrinter redPrinter() {
        return new RedPrinterImpl();
    }

    @Bean
    public YellowPrinter yellowPrinter() {
        return new YellowPrinterImpl();
    }

    @Bean
    public ColorPrinter colorPrinter(BluePrinter bluePrinter, RedPrinter redPrinter, YellowPrinter yellowPrinter) {
        return new ColorPrinterImpl(bluePrinter, redPrinter, yellowPrinter);
    }
}
