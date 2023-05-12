package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Magnum;

public class PriceList {
    //properties
    private double ballPrice;
    private double rocketPrice;
    private double magnumStandardPrice;


    //constructors
    public PriceList() {
    }

    public PriceList(double ballPrice, double rocketPrice, double magnumStandardPrice) {
        this.ballPrice = ballPrice;
        this.rocketPrice = rocketPrice;
        this.magnumStandardPrice = magnumStandardPrice;
    }


    //getters & setters
    public double getBallPrice() {
        return ballPrice;
    }

    public void setBallPrice(double ballPrice) {
        this.ballPrice = ballPrice;
    }

    public double getRocketPrice() {
        return rocketPrice;
    }

    public void setRocketPrice(double rocketPrice) {
        this.rocketPrice = rocketPrice;
    }

    public void setMagnumStandardPrice(double magnumStandardPrice) {
        this.magnumStandardPrice = magnumStandardPrice;
    }


    //custom methods
    public double getMagnumPrice(Magnum.MagnumType type) {
        double factor = 1;

        switch (type) {
            case MILKCHOCOLATE:
            case WHITECHOCOLATE:
            case BLACKCHOCOLATE:
                factor = 1.1;
                break;
            case ALPINENUTS:
            case ROMANTICSTRAWBERRIES:
                factor = 1.5;
        }

        return magnumStandardPrice * factor;
    }
}
