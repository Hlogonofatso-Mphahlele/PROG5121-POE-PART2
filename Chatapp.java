
package chatapp;

import java.util.Scanner;

public class Chatapp {

    
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        System.out.println("Register Your Account");
        
        System.out.print("Enter your first name: ");
        String firstName = kb.nextLine();
        
        System.out.print("Enter your last name: ");
        String lastName = kb.nextLine();
        
        System.out.print("Enter your username: ");
        String username = kb.nextLine();
        
        System.out.print("Enter your password: ");
        String password = kb.nextLine();
        
        System.out.print("Enter your cellphone number: ");
        String cellPhoneNumber = kb.nextLine();
        
        Login user = new Login(username, password, cellPhoneNumber);
        
        String registrationResult = user.registerUser();
        System.out.println(registrationResult);
        
        if (registrationResult.equals("User registered successfully")) {
            System.out.println("Enter Details To Login");
            
            System.out.print("Enter your username: ");
            String loginUsername = kb.nextLine();
            
            System.out.print("Enter ur password: ");
            String loginPassword = kb.nextLine();
            
            boolean LoginSuccess = user.loginUser(loginUsername, loginPassword);
            
            System.out.println(user.returnLoginStatus(LoginSuccess, firstName, lastName));          
          
        if(LoginSuccess) {
            System.out.println("Welcome To QuickChat");
            
            System.out.print("How many messages would you like to send?: ");
            int numberOfMessages = kb.nextInt();
            kb.nextLine();
            
            int count = 0;
            while (true) {
                System.out.println("Menu:");
                System.out.println("1) Send Message");
                System.out.println("2) Show recently stored messages");
                System.out.println("3) Quit");
                
                System.out.print("Choose an option from the menu: ");
                int menuOption = kb.nextInt();
                kb.nextLine();
                
                switch (menuOption) {
                    case 1:
                        if(count < numberOfMessages) {
                            System.out.print("Enter recipent cell number: ");
                            String recipient = kb.nextLine();
                            
                            System.out.print("Enter your message: ");
                            String messageText = kb.nextLine();
                            
                            Message ms = new Message(recipient, messageText);
                            
                            System.out.println(ms.checkRecipientCell());
                            System.out.println(ms.validateMessageLength());
                            
                            System.out.println("Choose an action to do from the following:");
                            System.out.println("1) Send Message");
                            System.out.println("2) Disregard Message");
                            System.out.println("3) Store Message");
                            System.out.print("What would u like to do: ");
                            
                            
                            int optionChoice = kb.nextInt();
                            kb.nextLine();
                            
                            if (optionChoice == 1) {
                                System.out.println(ms.sendMessages(1));
                                System.out.println("\n" + ms.printMessageDetails());
                            } else if (optionChoice == 2){
                                System.out.println(ms.sendMessages(2));
                            }else if(optionChoice == 3) {
                                System.out.println(ms.sendMessages(3));
                            } else {
                                System.out.println("Invalid option.");
                            }
                            count++;                            
                        } else {
                            System.out.println("Youve reached the maximum number of messages you can send");
                        }
                        break;                        
                    case 2:
                        System.out.println("Coming soon.");
                        break;
                    case 3:
                        System.out.println("Total messages sent: " + Message.returnTotalMessages());
                        System.out.println("Thank you for using QuickChat.");
                        
                        kb.close();
                        return;
                    default:
                        System.out.println("Invalid option chosen.");
                }
            }
        }
            
        }
        kb.close();
     
    }    
    
}
