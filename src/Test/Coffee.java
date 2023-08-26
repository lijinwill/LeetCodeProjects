package Test;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/10/24 15:56
 */
public class Coffee implements Drinkable {
    private int price = 20;
    private String name = "纯咖啡";
    /**
     * 纯咖啡的价格
     */
    @Override
    public int cost() {
        return price;
    }
    @Override
    public String info() {
        return name;
    }

    public static void main(String[] args) {

        Drinkable coffee = new Coffee();
        Milk milkCoffee = new Milk(coffee);
        Sugar sugarCoffee = new Sugar(milkCoffee);
        System.out.println(sugarCoffee.info()+"--价格是："+sugarCoffee.cost());
//纯咖啡加牛奶加糖--价格是：25

        /*
         * new Sugar( new Milk( new Coffee() ) ).info();
         */
    }
}
abstract class Decorate implements Drinkable {
    private Drinkable drink;

    public Decorate(Drinkable drink) {
        this.drink = drink;
    }

    @Override
    public int cost() {
        return drink.cost();
    }

    @Override
    public String info() {
        return drink.info();
    }
}

class Milk extends  Decorate {

    public Milk(Drinkable drink) {
        super(drink);
    }

    @Override
    public int cost() {
        return super.cost()+2;
    }

    @Override
    public String info() {
        return super.info()+"加牛奶";
    }
}

class Sugar  extends  Decorate {

    public Sugar(Drinkable drink) {
        super(drink);
    }
    @Override
    public int cost() {
        return super.cost()+3;
    }

    @Override
    public String info() {
        return super.info()+"加糖";
    }
}

interface Drinkable {
    int cost();

    String info();
}

