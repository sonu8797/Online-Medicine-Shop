package com.company;
import java.util.*;
   

class info {
    public int id;
    public String name;


}


class manufacturer extends info {
    ArrayList <Product> productSet = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);



    public void AddProduct() {
        Product x = new Product();
        System.out.print("Enter the name of newly added product : ");
        x.name = scanner.next();
        System.out.print("Enter the id of newly added product : ");
        x.id = scanner.nextInt();
        x.producer.name = name;
        x.producer.id = id;
        productSet.add(x);
    }

    public void printProduct() {
        if (productSet.isEmpty()) {
            System.out.println("Manufacturer does not have any manufactured product ");
            return;
        }
        int i = 1;
        System.out.println("The products manufactured by manufacturer is  " + name + " are shown : ");
        for (Product p : productSet) {
            System.out.println("Product : " + i++ + "   Name : " + p.name + ", id : " + p.id);
        }
        System.out.println();
    }
}

class Product extends info {
    manufacturer producer = new manufacturer();

}

class Customer extends info {
    int zipcode;
    ArrayList<Product> purchaseProducts;

    public void order(ArrayList<shopsWarehouses> Shops, Product p , HashMap<Delivery_agent, Integer> Hm) {
        for (shopsWarehouses it : Shops) {
            if ( it.zipcode == zipcode) {
                int i = 0;
                for (Map.Entry<Product, Integer> set : it.productCopies.entrySet()) {
                    if ((p.id == set.getKey().id) && (Objects.equals(p.name, set.getKey().name))
                            && (Objects.equals(p.producer.name, set.getKey().producer.name))
                            && (Objects.equals(p.producer.name, set.getKey().producer.name))) {
                        System.out.println("Product is purchased successfully");
                        purchaseProducts.add(p);
                        int c = it.productCopies.get(p);
                        it.productCopies.replace(p, c - 1);
                        return;
                    }
                    i++;
                }
                if (i == it.productCopies.size()) {
                    System.out.println("Product is not found in store " + it.name + " of id " + it.id);
                }
            }
        }
        System.out.println("Product is not found in any store " + p.name + " of id " + p.id);
    }

    public void showing_orderList() {
        int i = 0;
        for (Product it : purchaseProducts) {
            System.out.println("Purchased Product : " + i + "  Name : " + it.name + " , ID : " + it.id
                    + " , Producer name : " + it.producer.name + " , Producer ID : " + it.producer.id);
        }
    }
}

class shopsWarehouses extends info {
    int zipcode;
    Map<Product, Integer> productCopies = new HashMap<>();

    public void inventory_shops() {
        for (Map.Entry<Product, Integer> set : productCopies.entrySet()) {
            System.out.println(set.getKey() + " :  " + set.getValue());
        }
        System.out.println();
    }
}

class Delivery_agent extends info {
    int zipcode;
}

public class Assignment_01 {

    static void createManufacture(ArrayList<manufacturer> mnf1) {
        Scanner scanner = new Scanner(System.in);
        manufacturer Producer = new manufacturer();
        System.out.print("Enter the name of manufacturer  : ");
        Producer.name = scanner.next();
        System.out.print("Enter the ID of manufacturer : ");
        Producer.id = scanner.nextInt();
        mnf1.add(Producer);
    }

    static void deleteManufacturer(ArrayList<manufacturer> mnf1, manufacturer mnf2) {
        int i = 0;
        for (manufacturer it : mnf1) {
            if (Objects.equals(it.name, mnf2.name) && it.id == mnf2.id) {
                System.out.println("The manufacturer " + it.name + " with id " + it.id + " is deleted successful");
                mnf1.remove(i);
                break;
            }
            i++;
        }
        if (i == mnf1.size())
            System.out.println("Manufacturer can't found here.");
    }

    static void printManufacturer(ArrayList<manufacturer> mnf1) {
        int i = 1;
        for (manufacturer it : mnf1) {
            System.out.println("Manufacture : " + i++ + "->  Name : " + it.name + " , id :  " + it.id);
        }
        System.out.println();
    }

    static void createProduct(ArrayList<Product> Pds) {
        Scanner scanner = new Scanner(System.in);
        Product Pd = new Product();
        System.out.print("Enter the name of product :");
        Pd.name = scanner.next();
        System.out.print("Enter the ID of product : ");
        Pd.id = scanner.nextInt();
        System.out.print("Enter the name of producer : ");
        Pd.producer.name = scanner.next();
        System.out.print("Enter the id of producer : ");
        Pd.producer.id = scanner.nextInt();
        Pds.add(Pd);
    }

    static void deleteProduct(ArrayList<Product> Pd, Product Pd1) {
        int i = 0;
        for (Product it : Pd) {
            if (Objects.equals(it.name, Pd1.name) && it.id == Pd1.id) {
                System.out.println("The product " + it.name + " with id " + it.id + " and with Producer name "
                        + it.producer.name + " of id " + it.producer.id + " is deleted successful");
                Pd.remove(i);
                break;
            }
            i++;
        }
        if (i == Pd.size())
            System.out.println("Product can't found here.");
    }

    static void printProducts(ArrayList<Product> Pd) {
        int i = 0;
        for (Product it : Pd) {
            System.out.println("Product : " + i++ + " -> Name : " + it.name + " id : " + it.id
                    + " , Manufacturer name : " + it.producer.name + " , Manufacturer id : " + it.producer.id);
        }
        System.out.println();
    }

    static void createCustomer(ArrayList<Customer> Ctm) {
        Scanner sc = new Scanner(System.in);
        Customer new_Customer = new Customer();
        System.out.print("Enter the name of Customer : ");
        new_Customer.name = sc.next();
        System.out.print("Enter the ID of Customer : ");
        new_Customer.id = sc.nextInt();
        System.out.print("Enter the zipcode of Customer : ");
        new_Customer.zipcode = sc.nextInt();
        System.out.println();
        Ctm.add(new_Customer);
    }

    static void deleteCustomer(ArrayList<Customer> Ctm, Customer Ctm1) {
        int i = 0;
        for (Customer it : Ctm) {
            if (Objects.equals(it.name, Ctm1.name) && it.id == Ctm1.id && Ctm1.zipcode == it.zipcode) {
                System.out.println("The customer " + it.name + " with id " + it.id + " and zipcode " + it.zipcode
                        + " is deleted successfully");
                Ctm.remove(i);
                break;
            }
            i++;
        }
        if (i == Ctm.size())
            System.out.println("No Customer Found.");
    }

    static void printCustomer(ArrayList<Customer> Ctm) {
        int i = 1;
        for (Customer it : Ctm) {
            System.out.println(
                    "Customer : " + i++ + "->  Name : " + it.name + " , id :  " + it.id + " zipcode : " + it.zipcode);
        }
        System.out.println();
    }

    static void createShops_warehouse(ArrayList<shopsWarehouses> Swh) {
        Scanner scanner = new Scanner(System.in);
        shopsWarehouses new_shop = new shopsWarehouses();
        System.out.print("Enter the name of shop : ");
        new_shop.name = scanner.next();
        System.out.print("Enter the ID of shop : ");
        new_shop.id = scanner.nextInt();
        System.out.print("Enter the zipcode of shop : ");
        new_shop.zipcode = scanner.nextInt();
        System.out.println();
        Swh.add(new_shop);
    }

    static void deleteShops_warehouse(ArrayList<shopsWarehouses> Swh, shopsWarehouses Swh1) {
        int i = 0;
        for (shopsWarehouses it : Swh) {
            if (Objects.equals(it.name, Swh1.name) && it.id == Swh1.id && Swh1.zipcode == it.zipcode) {
                System.out.println("The shop or warehouse " + it.name + " with id " + it.id + " and zipcode "
                        + it.zipcode + " is deleted successfully");
                Swh.remove(i);
                break;
            }
            i++;
        }
        if (i == Swh.size())
            System.out.println("Shop can't found here.");
    }

    static void printShops_warehouse(ArrayList<shopsWarehouses> Swh) {
        int i = 1;
        for (shopsWarehouses it : Swh) {
            System.out.println("Shop_Warehouse : " + i++ + "->  Name : " + it.name + " , id :  " + it.id + " zipcode : "
                    + it.zipcode);
        }
        System.out.println();
    }

    static void createDeliveryAgent(TreeMap<Integer, Delivery_agent> Hm) {
        Scanner scanner = new Scanner(System.in);
        Delivery_agent new_deliveryAgent = new Delivery_agent();
        System.out.print("Enter the name of Delivery agent : ");
        new_deliveryAgent.name = scanner.next();
        System.out.print("Enter the ID of Delivery agent : ");
        new_deliveryAgent.id = scanner.nextInt();
        System.out.print("Enter the zipcode of Delivery agent : ");
        new_deliveryAgent.zipcode = scanner.nextInt();
        System.out.println();
        int k;
        System.out.print("Enter the number of deliveries delivered  by agent  : ");
        k = scanner.nextInt();
        Hm.put(k, new_deliveryAgent);
    }

    static void deleteDeliverySAgent(TreeMap<Integer, Delivery_agent> Hm, Delivery_agent p) {
        int i = 0;
        for (Map.Entry<Integer, Delivery_agent> set : Hm.entrySet()) {
            if ((p.id == set.getValue().id) && (p.name == set.getValue().name) && (p.zipcode == set.getValue().zipcode)) {
                System.out.println("The delivery agent " + p.name + " with id " + p.id + " and zipcode " + p.zipcode
                        + " is deleted successfully");
                Hm.remove(set.getValue());
                break;
            }
            i++;
        }
        if (i == Hm.size())
            System.out.println("No Customer Found.");
    }

    static void PrintDeliveryAgent(ArrayList<Delivery_agent> DA, HashMap<Delivery_agent, Integer> Hm) {
        int i = 1;
        for (Delivery_agent it : DA) {
            System.out.println(
                    "Delivery Agent : " + i++ + "->  Name : " + it.name + " , id :  " + it.id + " zipcode : " + it.zipcode + " No of Orders : " + Hm.get(it));
        }
        System.out.println();
    }
    public static void main(String[] args) {

        ArrayList<manufacturer> mnf1 = new ArrayList<>();
        ArrayList<Product> Pds = new ArrayList<>();
        ArrayList<Customer> Ctm = new ArrayList<>();
        ArrayList<shopsWarehouses> Swh = new ArrayList<>();
        TreeMap<Integer, Delivery_agent> DA = new TreeMap<>();
        createManufacture(mnf1);
        printManufacturer(mnf1);
        createProduct(Pds);
        printProducts(Pds);
        createCustomer(Ctm);
        printCustomer(Ctm);
        printCustomer(Ctm);
        createShops_warehouse(Swh);
        printShops_warehouse(Swh);
        createDeliveryAgent(DA);
         System.out.println("Press '1' for the  Manufacturer.");
        System.out.println("Press '2' for the Products.");
        System.out.println("Press '3' for the Customers.");
        System.out.println("Press '4' for the Shops and Warehouses.");
        System.out.println("Press '5' for the Delivery agents.");
        System.out.println("Press '0' for Exit");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice : ");
    }
}
