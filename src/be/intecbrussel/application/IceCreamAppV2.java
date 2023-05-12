package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.*;

public class IceCreamAppV2 {
    public static void main(String[] args) {
        PriceList priceList = new PriceList(2, 2, 2);
        Stock stock = new Stock(1, 1, 2, 1);
        IceCreamSeller iceCreamSeller = new IceCreamCar(priceList, stock);

        System.out.println("----------------------------------- ordering cones -----------------------------------");
        System.out.println(iceCreamSeller.orderCone(new Cone.Flavor[]{Cone.Flavor.VANILLA, Cone.Flavor.VANILLA, Cone.Flavor.VANILLA})); //3 scoops -> insufficient stock
        System.out.println(iceCreamSeller.orderCone(new Cone.Flavor[]{Cone.Flavor.VANILLA, Cone.Flavor.VANILLA})); //2 scoops -> possible
        System.out.println(iceCreamSeller.orderCone(new Cone.Flavor[]{Cone.Flavor.VANILLA, Cone.Flavor.VANILLA})); //2 scoops -> insufficient stock
        System.out.println("----------------------------------- ordering icerockets -----------------------------------");
        System.out.println(iceCreamSeller.orderIceRocket()); //1 icerocket -> possible
        System.out.println(iceCreamSeller.orderIceRocket()); //insufficient stock
        System.out.println("----------------------------------- ordering magnums -----------------------------------");
        System.out.println(iceCreamSeller.orderMagnum(Magnum.MagnumType.ALPINENUTS)); //1 magnum -> possible
        System.out.println(iceCreamSeller.orderMagnum(Magnum.MagnumType.ALPINENUTS)); //insufficient stock

        //Aan het einde van je applicatie print je de profit af van de icecreamseller.
        IceCreamCar iceCreamSellerDowncastToIceCar = (IceCreamCar) iceCreamSeller;
        System.out.println("Total iceCreamCar profit: " + iceCreamSellerDowncastToIceCar.getProfit());

        //Eatable array
        Eatable[] eatableArr = new Eatable[]{iceCreamSeller.orderIceRocket(),
                iceCreamSeller.orderMagnum(Magnum.MagnumType.ALPINENUTS),
                iceCreamSeller.orderCone(new Cone.Flavor[]{Cone.Flavor.PISTACHE, Cone.Flavor.VANILLA})};

        //Roep van deze ijsjes de eat methode aan.
        for (Eatable icecream : eatableArr) {
            if (icecream != null) {
                icecream.eat();
            }
        }
    }
}
