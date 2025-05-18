import java.util.*;

class FireExtinguisher{

    private String productName;
    private String type;
    private double price;


    public static ArrayList<FireExtinguisher> extinguisherList = new ArrayList<>();

    public FireExtinguisher(){};
    public FireExtinguisher(String productName, String type, double price){
        this.productName = productName;
        this.type = type;
        this.price = price;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }



    public static void addExtinguisherDetails(String extinguisherDetails){
        String parts[] = extinguisherDetails.split(":");
        String product = parts[0];
        String type = parts[1];
        double price = Double.parseDouble(parts[2]);

        FireExtinguisher extinguisher = new FireExtinguisher(product, type, price);

        extinguisherList.add(extinguisher);
    }

    public static List<FireExtinguisher> findExtinguisherRange(double minimumPrice, double maximumPrice){
        List<FireExtinguisher> filteredList = new ArrayList<>();

        for(FireExtinguisher fe : extinguisherList){
            if(fe.price >= minimumPrice && fe.price <= maximumPrice){
                filteredList.add(fe);
            }
        }
        return filteredList;
    }
}

public class SparkShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of details to be added");
        int count = Integer.parseInt(sc.nextLine());

        System.out.println("Enter extinguisher details(Product:Type:Price)");

        for(int i = 0;i<count;i++){
            String details = sc.nextLine();
            FireExtinguisher.addExtinguisherDetails(details);
        }

        System.out.println("Enter the minimum price:");
        double min = Double.parseDouble(sc.nextLine());

        System.out.println("Enter the maximum Price");
        double max = Double.parseDouble(sc.nextLine());

        List<FireExtinguisher> result = FireExtinguisher.findExtinguisherRange(min, max);


        if(result.isEmpty()){
            System.out.println("No products in inventory");
        }else{
            System.out.println("Fire extinguisher inventory");

            for(FireExtinguisher fe : result){
                System.out.println(fe.getProductName());
            }
        }
    }
}
