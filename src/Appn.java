import java.util.*;

public class Appn {
    public static void main(String[] args) {
        // Create instances and test the functionalities
        Garment g1 = new Garment();
        g1.id = "G1";
        g1.name = "T-Shirt";
        g1.price = 25.00;
        g1.updateStock(10);

        Order order = new Order();
        order.addGarment(g1);

        Customer customer = new Customer();
        customer.placeOrder(order);
    }
}


class Garment {
    String id, name, description, color, size;
    double price;
    int stockQuantity;

    void updateStock(int quantity) {
        stockQuantity += quantity;
    }

    double calculateDiscountPrice(double discountPercentage) {
        return price - (price * discountPercentage) / 100;
    }
}

class Fabric {
    String id, type, color;
    double pricePerMeter;

    double calculateCost(double meters) {
        return pricePerMeter * meters;
    }
}

class Supplier {
    String id, name, contactInfo;
    List<Fabric> suppliedFabrics = new ArrayList<>();

    void addFabric(Fabric fabric) {
        suppliedFabrics.add(fabric);
    }
}

class Order {
    String orderId;
    List<Garment> garments = new ArrayList<>();
    double totalAmount;

    void addGarment(Garment garment) {
        garments.add(garment);
        totalAmount += garment.price;
    }

    void printOrderDetails() {
        for (Garment garment : garments) {
            System.out.println(garment.name + "\t" + garment.price);
        }
        System.out.println("Total: " + totalAmount);
    }
}

class Customer {
    String customerId, name, email, phone;
    List<Order> orders = new ArrayList<>();

    void placeOrder(Order order) {
        orders.add(order);
        order.printOrderDetails();
    }
}

class Inventory {
    List<Garment> garments = new ArrayList<>();

    void addGarment(Garment garment) {
        garments.add(garment);
    }

    Garment findGarment(String id) {
        for (Garment garment : garments) {
            if (garment.id.equals(id)) {
                return garment;
            }
        }
        return null;
    }
}

