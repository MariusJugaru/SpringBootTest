package com.colors.colors.Impl;

import com.colors.colors.BluePrinter;
import com.colors.colors.ColorPrinter;
import com.colors.colors.GreenPrinter;
import com.colors.colors.RedPrinter;

public class ColorPrinterImpl implements ColorPrinter {
    private RedPrinter redPrinter;
    private BluePrinter bluePrinter;
    private GreenPrinter greenPrinter;

    public ColorPrinterImpl(RedPrinter redPrinter, BluePrinter bluePrinter, GreenPrinter greenPrinter) {
        this.redPrinter = redPrinter;
        this. bluePrinter = bluePrinter;
        this.greenPrinter = greenPrinter;
    }
    public String print() {
        return String.join(", ", redPrinter.print(), bluePrinter.print(), greenPrinter.print());
    }
}
