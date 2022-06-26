package base.low_of_demeter;

public class LowOfDemeter {

    static class Bill {
        private final int price;

        public Bill(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        public void payPrice(int money) {
            System.out.println("You pay " + money + " for bill");
        }
    }

    static class Shop {
        Bill bill = new Bill(321);

        public int getPrice() {
            return bill.getPrice();
        }
        public void payBill() {
            bill.payPrice(getPrice());
       }
    }

    static class Alien {

        public void goShopPayBill() {
            new Shop().payBill();
        }
    }

}
