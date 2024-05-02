//Mobile.java
public class Mobile extends Gadget{
   private int callingCredit;
   public static void main(String[] args) {
           //creating mobile class
           Mobile mobile1 =new Mobile("matrolla6",50.0,150,"170x360x500",200);
           Mobile mobile2 =new Mobile("abdphone",700,450,"200x400x700",300);
           //display metheod to show mobiles
           mobile1.display();
           mobile2.display();
        }
   //metheod for price,weight,model,size
   public Mobile(String model,double price,int weight,String size,int callingCredit){
       super(model,price,weight,size);
       this.callingCredit=callingCredit;
   }
   //methoeod for calling credit
   public int getCallingCredit(){
       return callingCredit;
   }
   //for adding calling credit
   public void addCallingCredit(int amount){
       if(amount>0){
           callingCredit+=amount;
           System.out.println("Calling credit Successfully added.");
       }else{
        System.out.println("kindly provide a positive value to add mobile Credit");
       }
   }
   
   public void makeCall(String phoneNumber,int duration){
       if (duration<=callingCredit){
           System.out.println("Calling"+phoneNumber+"for"+"duartion"+"minutes.");
           callingCredit=duration;
       }else{
           System.out.println("Not enough Credit to call top up to call again");
       }
   }
   //for displaying
   @Override
   public void display(){
       super.display();
       System.out.println("Calling Credit Remaining:"+callingCredit+"minutes");
   
   }
}