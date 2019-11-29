import java.util.*;
import java.io.*;
public class Simulation {
    ArrayList<Item> loadItems(){
        ArrayList<Item> itemsList=new ArrayList<>();
        try{
    File phase1=new File("https://s3.amazonaws.com/video.udacity-data.com/topher/2017/December/5a372d88_phase-2/phase-2.txt");
    FileInputStream fis=new FileInputStream(phase1);
    byte[] byteArray=new byte[(int)phase1.length()];
    fis.read(byteArray);
    String data=new String(byteArray);
    String[] items=data.split("\r\n");
    for(String item:items){
        Item eachItem=new Item();
        String[] temp=item.split("=");
        eachItem.name=temp[0];
        eachItem.weight=Integer.valueOf(temp[1]);
        itemsList.add(eachItem);
    }
    }
        catch(FileNotFoundException e){
            System.out.println("Re-check file location"+e);
        }
        catch (IOException e){

        }
    }
    ArrayList<Rocket> loadUI(ArrayList<Item> itemsList){

    }
    ArrayList<Rocket> loadU2(ArrayList<Item> itemsList){

    }
    int runSimulation(ArrayList<Rocket> rocketsList){

    }
}
