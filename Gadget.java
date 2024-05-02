//Gadget.java
public class Gadget{
    private String model;
    private double price;
    private int weight;
    private String size;
    //constructor
    public Gadget(String model,double price,int weight,String size){
        this.model=model;
        this.price=price;
        this.weight=weight;
        this.size=size;
    }
    //for adding model
    public String getModel(){
       return model;    
    }
    //for adding price
    public double getprice(){
        return price;
    }
    //for adding weight
    public int getWeight(){
        return weight;
    }
    //for adding size 
    public String getsize(){
        return size;
    }
    //Method to display gadgets details
    public void display(){
        System.out.println("Model:"+model);
        System.out.println("price:£"+price);
        System.out.println("Weight:"+weight+"grams");
        System.out.println("Size:"+size);
    
    }
    
    //main method
    public static void main(String[] args) {
        Gadget gadget1 = new Gadget("Nokia 10",300,400,"Large");
        Gadget gadget2 = new Gadget("ONEPLUS 5",800,300,"Small");
        
        //display to show gadgets
        gadget1.display();
        gadget2.display();
        
    }
}