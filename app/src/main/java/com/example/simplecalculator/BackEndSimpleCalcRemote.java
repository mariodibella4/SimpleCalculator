package com.example.simplecalculator;

import javax.ejb.Remote;

@Remote
public interface BackEndSimpleCalcRemote {
    String getSolution(String input);
}
