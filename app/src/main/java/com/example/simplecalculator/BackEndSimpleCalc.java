package com.example.simplecalculator;

import net.objecthunter.exp4j.ExpressionBuilder;

import javax.ejb.Stateless;

@Stateless
public class BackEndSimpleCalc implements BackEndSimpleCalcRemote {
    @Override
    public String getSolution(String input) {
        String res;
        String updatedInput = replaceMultiplyAndDivideWithProperSymbols(input);
        ExpressionBuilder expression = new ExpressionBuilder(updatedInput);
        try {
            double result = expression.build().evaluate();
            res = Double.toString(result);
        } catch (ArithmeticException e) {
            res = "Error";
        }
        return res;
    }

    public String replaceMultiplyAndDivideWithProperSymbols(String input) {
        String inputProperMultiply = input.replace('×', '*');
        return inputProperMultiply.replace('÷', '/');
    }
}
