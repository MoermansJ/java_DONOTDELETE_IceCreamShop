package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

import java.util.Objects;
import java.util.stream.Stream;

public class IceCreamCar implements IceCreamSeller {
    //properties
    private PriceList priceList;
    private Stock stock;
    private double totalProfit; //renamed FROM "profit" to "totalProfit"


    //constructors
    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }


    //custom methods
    private Cone prepareCone(Cone.Flavor[] flavors) {
        if (stock.getBalls() < flavors.length || stock.getCones() <= 0) {
            System.out.println("NO MORE ICECREAM (cones/flavors)");
            return null;
        }

        stock.setCones(stock.getCones() - 1);
        stock.setBalls(stock.getBalls() - flavors.length);
        return new Cone(flavors);
    }

    private IceRocket prepareIceRocket() {
        if (stock.getIceRockets() <= 0) {
            System.out.println("NO MORE ICECREAM (icerocket)");
            return null;
        }

        stock.setIceRockets(stock.getIceRockets() - 1);
        return new IceRocket();
    }

    private Magnum prepareMagnum(Magnum.MagnumType type) {
        if (stock.getMagni() <= 0) {
            System.out.println("NO MORE ICECREAM (magnum)");
            return null;
        }

        stock.setMagni(stock.getMagni() - 1);
        return new Magnum(type);
    }

    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {
        Cone result = prepareCone(flavors);

        if (result != null) {
            Stream.of(flavors).filter(Objects::nonNull).forEach(item -> totalProfit += (priceList.getBallPrice() * 0.25));
        }

        return result;
    }

    @Override
    public IceRocket orderIceRocket() {
        IceRocket result = prepareIceRocket();

        if (result != null) {
            totalProfit += (priceList.getRocketPrice() * 0.2);
        }

        return result;
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        Magnum result = prepareMagnum(type);

        if (result != null) {
            totalProfit += (priceList.getMagnumPrice(type) * 0.01);
        }

        return result;
    }

    @Override
    public double getProfit() {
        return totalProfit;
    }
}
