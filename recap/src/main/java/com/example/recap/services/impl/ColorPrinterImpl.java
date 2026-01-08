package com.example.recap.services.impl;

import com.example.recap.services.BluePrinter;
import com.example.recap.services.ColorPrinter;
import com.example.recap.services.RedPrinter;
import com.example.recap.services.YellowPrinter;
import org.springframework.context.annotation.Bean;

public class ColorPrinterImpl implements ColorPrinter {

    BluePrinter bluePrinter;
    RedPrinter redPrinter;
    YellowPrinter yellowPrinter;

    public ColorPrinterImpl(BluePrinter bluePrinter, RedPrinter redPrinter, YellowPrinter yellowPrinter) {
        this.bluePrinter = bluePrinter;
        this.redPrinter = redPrinter;
        this.yellowPrinter = yellowPrinter;
    }

    @Override
    public void print() {
        this.bluePrinter.print();
        this.redPrinter.print();
        this.yellowPrinter.print();
    }
}
