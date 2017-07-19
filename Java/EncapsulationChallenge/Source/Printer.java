package com.company;

/**
 * Created by Tobias on 24.05.2017.
 */
public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean isDuplex;

    public Printer(int tonerLevel, boolean isDuplex) {
        if(tonerLevel > -1 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        }else {
            this.tonerLevel = -1;
        }
        this.isDuplex = isDuplex;
        this.pagesPrinted = 0;
    }

    public int addToner(int amount){
        if(amount > 0 && amount <= 100) {
            if(this.tonerLevel + amount > 100){
                return -1;
            }
            this.tonerLevel += amount;
            return this.tonerLevel;
        }else {
            return -1;
        }
    }

    public int printing (int pages){
        if(isDuplex){
            pages = pages / 2;
        }

        this.pagesPrinted += pages;
        return pages;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
