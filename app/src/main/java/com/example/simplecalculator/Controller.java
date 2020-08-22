package com.example.simplecalculator;

public class Controller {
    public String replaceMultiplyAndDivideWithProperSymbols(String input){
        String inputProperMultiply=input.replace('×','*');
        String inputProperMuliplyAndDivide=inputProperMultiply.replace('÷','/');
        return inputProperMuliplyAndDivide;
    }
}

