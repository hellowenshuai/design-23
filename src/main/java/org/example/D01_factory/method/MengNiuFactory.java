package org.example.D01_factory.method;

import org.example.D01_factory.simple.MengNiuMilk;
import org.example.D01_factory.simple.Milk;

public class MengNiuFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new MengNiuMilk();
    }
}
