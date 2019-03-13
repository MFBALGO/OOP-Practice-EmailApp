
import java.util.Scanner;


public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 8;
    private String department;
    private String email;
    private int mailBoxCapacity = 200;//200 by default
    private String alternateEmail;
    private String companySuffix = "rayanaorganic.com";
    
    //Construcor for firstName lastName
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.password = randomPassword(defaultPasswordLength);
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() +
                "@" + this.department + "." + this.companySuffix;
        System.out.println("Your email is: " + this.email);
        System.out.println("Your password is: " + this.password);
        
    }
    
    //Ask for the department 
    private String setDepartment(){
        System.out.print("ENTER DEPARTMENT CODE: \n1 for Sales\n2 for Development"
                + "\n3 for Accounting\n0 for None\n");
        Scanner input = new Scanner(System.in);
        int depChoice = input.nextInt();
        
        if (depChoice ==1){return "sales";}
        else if (depChoice ==2){return "development";}
        else if (depChoice ==3){return "accounting";}
        else {return "";}
    }
    
    //Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%";
        char[] password = new char[length];
        for (int i=0;i<length;i++){
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }
    
    //set mailbox capacity 
    public void setMailboxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
        
    }
    
    
    //set alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    
    //change password
    public void changePassword(String newPassword){
        this.password = newPassword;
    }
    
    public int getMailboxCapacity(){return this.mailBoxCapacity;}
    public String getAlternateEmail(){return this.alternateEmail;}
    public String getPassword(){return this.password;}
    
    public void showInfo(){
        System.out.println("DISPLAY NAME: " + firstName + " " + lastName);
        System.out.println("COMPANY EMAIL: " + email);
        System.out.println("MAILBOX CAPACITY: " + mailBoxCapacity + "mb");
    }
}
