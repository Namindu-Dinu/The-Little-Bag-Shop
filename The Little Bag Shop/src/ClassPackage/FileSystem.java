
package ClassPackage;

import java.io.*;

public class FileSystem {
    
    
    private static String FILE_PATH = "F:\\DEGREE\\SE Degree\\Assignment\\Sem 2\\Assignment\\OOP\\Final\\Sis\\The Little Bag Shop\\File Manager\\";
    File file;
    private String fileName;
    
     public FileSystem(String fileName)
     {
        this.fileName = fileName;        
     }
      public boolean createANewFile() 
      {
        try {
            file = new File(FILE_PATH + fileName);
            if (file.createNewFile()){
                System.out.println("File Created: " + file.getName());
                return true;
            }
            else
            {
            System.out.println("File Already Exisit !");
            return false;
            }
        } catch(IOException e) {
            System.out.println("Something went wrong with creating file" + e);
            return false;
        }       
        
      }
          
       public boolean writeDataToFile(String record) 
      {
        try {
            file.createNewFile();
            FileWriter fileWriter  = new FileWriter(file, true);
            BufferedWriter  bufferedWriter= new BufferedWriter(fileWriter);

            bufferedWriter.write(record);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
            return true;
        } catch (IOException ex) 
        {
            System.out.println("Something went wrong with writing" + ex);
            return false;
        }
    }
       
       
        public BufferedReader readAFile()
      {
        if(!createANewFile())
        {
            try {
                FileReader fileReader = new FileReader(file);
           BufferedReader bufferedReader = new BufferedReader(fileReader);

                return bufferedReader;
            } 
            catch (IOException ex)
            {
System.out.println("Something went wrong with Reading the file" + ex);
            }
        }    
        return null;
    }
         
}

    

