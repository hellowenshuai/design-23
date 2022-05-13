package org.example.D01_factory.method;

import org.example.D01_factory.simple.Milk;
import org.example.D01_factory.simple.TeLunSuMilk;

public class TeLunSuFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new TeLunSuMilk();
    }
}
