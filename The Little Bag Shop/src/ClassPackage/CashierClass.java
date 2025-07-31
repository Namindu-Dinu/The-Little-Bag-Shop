
package ClassPackage;

import java.io.*;

public class CashierClass {
    private String UserId;
    private String Password;
    private int UserCount;

    FileSystem fs = new FileSystem("CashierInfo.txt");
    
 public CashierClass(){}
 
    public CashierClass(String UserId, String Password) {
        this.UserId = UserId;
        this.Password = Password;
    }    

    public String getUserId() {
        return UserId;
    }

    public String getPassword() {
        return Password;
    }

    public int getUserCount() {
        return UserCount;
    }
    
    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setUserCount(int UserCount) {
        this.UserCount = UserCount;
    }

   public boolean addNewUser()
    {
        if(!fs.createANewFile()){
            String record = UserId + " " + Password ;       
                            
            return fs.writeDataToFile(record);
        }
        return false;
    }
    public boolean validateLogin()
     {
        try {
            String[] words = null;
            
            BufferedReader bufferedReader = fs.readAFile();
            String user;

            while ((user = bufferedReader.readLine()) != null)
            {              
                words = user.split(" ");
                
                if (words[0].equals(UserId) && words[1].equals(Password))
                {
                    this.setUserId(words[0]);
                    this.setPassword(words[1]);
                    return true;
                }
            }
        } catch (IOException ex)
        {
            System.err.println("Error Validating Login"+ex);
        }   
        return false;
    } 
}
