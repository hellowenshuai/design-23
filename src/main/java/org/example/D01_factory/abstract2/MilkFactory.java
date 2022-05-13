package org.example.D01_factory.abstract2;

import org.example.D01_factory.method.MengNiuFactory;
import org.example.D01_factory.method.TeLunSuFactory;
import org.example.D01_factory.method.YiLiFactory;
import org.example.D01_factory.simple.Milk;
import org.example.D01_factory.simple.SanLuMilk;

public class MilkFactory extends AbstractFactory {
    @Override
    Milk getYiLi() {
        return new YiLiFactory().getMilk();
    }

    @Override
    Milk getTeLunSu() {
        return new TeLunSuFactory().getMilk();
    }

    @Override
    Milk getMengNiu() {
        return new MengNiuFactory().getMilk();
    }

    @Override
    Milk getSanLu() {
        return new SanLuMilk();
    }
}
