//MP3.JAVA
public class MP3 extends Gadget{
    private int availableMemory;
    // for adding model, price,weight,size and memory
    public MP3(String model,double price,int weight,String size,int availableMemory){
        super(model,price,weight,size);
        this.availableMemory=availableMemory;
    }
    //for checking avaialble memory
    public int getAvailableMemory(){
        return availableMemory;
    }
    // for checking muic is downloaded or not
    public void downloadMusic(int memoryRequired){
        if(memoryRequired<=availableMemory){
            availableMemory=memoryRequired;
            System.out.println("successfully downloaded Music");
        }else{
            System.out.println("not enough memory to download music");
        }
    }
    

    //for deleting muic
    public void deleteMusic(int memoryFreed){
        availableMemory+=memoryFreed;
        System.out.println("successfully deleted Music");
    }
    //for displaying
    @Override
    public void display(){
        super.display();
        System.out.println("Available Memory:"+availableMemory+"MB");
    }
    //main metheod
    public static void main(String[] args) {
        //creating mp3 class objects
        MP3 mp3=new MP3("discman2015",50,10,"172x172x500",400);
        //display MP3
        mp3.display();
        
    }
}