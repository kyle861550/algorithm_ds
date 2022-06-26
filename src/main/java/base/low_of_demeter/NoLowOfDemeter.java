package base.low_of_demeter;

public class NoLowOfDemeter {

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
        public void payBill(Bill bill, int money) {
            bill.payPrice(money);
        }
    }

    static class Alien {
        Bill bill = new Bill(321);
        public int getPrice() {
            return bill.getPrice();
        }

        public void goShopPayBill() {
            new Shop().payBill(bill, getPrice());
        }
    }

}
