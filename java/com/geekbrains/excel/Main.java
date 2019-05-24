package com.geekbrains.excel;

public class Main {
    public static void main(String[] args) {
        ExcelParser parser = new ExcelParser();
        System.out.println(parser.parse("test.xls"));
    }
}
