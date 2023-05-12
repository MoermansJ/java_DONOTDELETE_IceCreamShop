package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

import java.util.Objects;
import java.util.stream.Stream;

public class IceCreamSalon implements IceCreamSeller {
    //properties
    private PriceList priceList;
    private double totalProfit;


    //constructors
    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
    }


    //custom methods
    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {
        Stream.of(flavors).filter(Objects::nonNull).forEach(item -> totalProfit += (priceList.getBallPrice() * 0.25));
        System.out.println("TOTALPROFIT: " + totalProfit);

        return new Cone(flavors);
    }

    @Override
    public IceRocket orderIceRocket() {
        totalProfit += (priceList.getRocketPrice() * 0.2);
        System.out.println("TOTALPROFIT: " + totalProfit);
        return new IceRocket();
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        totalProfit += (priceList.getMagnumPrice(type) * 0.01);
        System.out.println("TOTALPROFIT: " + totalProfit);

        return new Magnum(type);
    }

    @Override
    public String toString() {
        return "IceCreamSalon{" +
                "priceList=" + priceList +
                ", totalProfit=" + totalProfit +
                '}';
    }

    @Override
    public double getProfit() {
        return totalProfit;
    }
}
