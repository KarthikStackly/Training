class Product {
    int productID;
    String productName;
    double productAmount;

    Product(int productID, String productName, double productAmount) {
        this.productID = productID;
        this.productName = productName;
        this.productAmount = productAmount;
    }

    void display() {
        System.out.println("\n*** Product added to cart ***");
        System.out.printf(" ID : %d%n Name : %s%n Amount : %.2f%n", productID, productName, productAmount);
    }

}

class Electronics extends Product {
    String warranty;
    Electronics(int productID, String productName, double productAmount, String warranty) {
        super(productID, productName, productAmount);
        this.warranty = warranty;
    }

    void display(){ //Overriding
        super.display(); //Here we are calling a method from the Parent class to run as is.
        System.out.printf(" Warranty : %s%n", warranty); //adding our extra sauce here
        }
}

class Food extends Product {
    String expiry;
    Food(int productID, String productName, double productAmount, String expiry) {
        super(productID, productName, productAmount);
        this.expiry = expiry;
    }

//    String getExpiry(){}
    void display() {
        super.display();
        System.out.printf(" Expiry : %s%n", expiry);
    }
}

class Clothing extends Product {
    enum Sizes {XS, S, M, L, XL, XXL};
    Sizes size;
    Clothing(int productID, String productName, double productAmount, Sizes size) {
        super(productID, productName, productAmount);
        this.size = size;
    }

    void display(){
        super.display();
        System.out.printf(" Size : %s%n", size);
    }
}

public class ShopOnline {
    static void main() {
//        Product lappy = new Product(1234, "Laptop", 50000);
//        We don't create Objects for the Parent class. We do it out of Level 0 Child class
        Electronics lappy = new Electronics(1234, "Laptop", 50000, "blah blah");
        Clothing shirt = new Clothing(123, "Branded T-Shirt", 1500, Clothing.Sizes.XXL);

//            lappy.display();
//            shirt.display();
//            System.out.println("\nTotal Bill to pay = " + (lappy.productAmount + shirt.productAmount));

        Product[] cart = {lappy, shirt};
        double subtotal = 0.0;
        double totalBill = 0.0;

//            Final printfs
        System.out.println("================ Online Shopping Bill ================");
        for (Product item : cart) {
            item.display();
            subtotal += item.productAmount;
        }
        double afterTaxes = subtotal * 0.18;
        totalBill = subtotal + afterTaxes;

        System.out.println("-------------------------------------------------------");
        System.out.printf("GROSS SUBTOTAL      : ₹%.2f\n", subtotal);
        System.out.printf("GST                 : ₹%.2f\n", afterTaxes);
        System.out.println("-------------------------------------------------------");
        System.out.printf("TOTAL AMOUNT PAYABLE: ₹%.2f\n", totalBill);
        System.out.println("=======================================================");
    }
}