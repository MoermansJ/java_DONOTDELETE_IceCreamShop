package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;

public class IceCreamApp {
    public static void main(String[] args) {
        //Maak een PriceList instantie aan.
        PriceList priceList = new PriceList(1, 1, 1);

        //Maak een IceCreamSalon instantie aan met behulp van de pricelist en steek deze in een
        //IceCreamSeller variabele
        IceCreamSeller iceCreamSeller = new IceCreamSalon(priceList);


        //Bestel enkele ijsjes (order methoden), steek deze in een array van Eatable.
        Eatable[] eatableArr = new Eatable[]{iceCreamSeller.orderIceRocket(),
                iceCreamSeller.orderMagnum(Magnum.MagnumType.ALPINENUTS),
                iceCreamSeller.orderCone(new Cone.Flavor[]{Cone.Flavor.PISTACHE, Cone.Flavor.VANILLA})};

        //Roep van deze ijsjes de eat methode aan.
        for (Eatable icecream : eatableArr) {
            icecream.eat();
        }

        //Aan het einde van je applicatie print je de profit af van de icecreamseller.
        IceCreamSalon iceCreamSellerDowncastToIceCreamSalon = (IceCreamSalon) iceCreamSeller;
        System.out.printf("%.2f%n", iceCreamSellerDowncastToIceCreamSalon.getProfit());

    }
}
