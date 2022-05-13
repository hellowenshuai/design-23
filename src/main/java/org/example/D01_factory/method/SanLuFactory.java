package org.example.D01_factory.method;

import org.example.D01_factory.simple.Milk;
import org.example.D01_factory.simple.SanLuMilk;

public class SanLuFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new SanLuMilk();
    }
}
