
package ClassPackage;

import java.io.BufferedReader;
import java.io.IOException;


public class BagClass {
     //creating variables
    private String BagId;
    private String name;
    private String  category;
    private String price;
    private String quantity;
    FileSystem FileSystem = new FileSystem("Bag Details.txt");
    
    public BagClass(){}
    
     public BagClass(String BagId, String name, String category, String price, String quantity) {
        this.BagId = BagId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
       
    }

    

    public String getBagId() {
        return BagId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public FileSystem getFileSystem() {
        return FileSystem;
    }

    public void setBagId(String BagId) {
        this.BagId = BagId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setFileSystem(FileSystem FileSystem) {
        this.FileSystem = FileSystem;
    }

    
    
     
    public boolean addBag() {
        
        if(!FileSystem.createANewFile())
        {
            String record = BagId + " " + name + " " + category + " " + price +" " + quantity;
           
            return FileSystem.writeDataToFile(record);
        }

        return false;
    }
    public boolean searchBag (String category) 
      {
        boolean isFound = false;
         
        try {
            String[] words = null;
            
            BufferedReader bufferedReader = FileSystem.readAFile();
            String Bag;
            
            outerloop:
            while ((Bag = bufferedReader.readLine()) != null) {            
                words = Bag.split(" "); 
                
                for (String word : words) {
                    if (word.equals(category)) 
                    {
                        isFound = true;
                        
                        this.setBagId(words[0]);
                        this.setName(words[1]);
                        this.setCategory(words[2]);
                        this.setPrice(words[3]);
                        this.setQuantity(words[4]);
                        break outerloop;
                    }
                }
            }
        } catch (IOException ex)
        {
            System.out.println("Error searchmanager "+ex);
        }
        
        return isFound;
    }
     
}
