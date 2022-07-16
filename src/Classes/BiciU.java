package Classes;

import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.math.NumberUtils;
import Classes.Entities.MainServices;
import Utils.ConsoleMenu;


// Main Class
public class BiciU {

    // main method
    public static void main(String[] args) {

        displayMainMenu();
        int selectedOption = Integer.parseInt(
                ConsoleMenu.renderAndVerify(
                        (option) -> NumberUtils.isParsable(option) && Range.between(1, 6).contains(Integer.parseInt(option)),
                                           "1. Register user.", "2. Borrow Bicycle.", "3. Return Bicycle.", "4.Pay Ticket.","5.Tickets History.", "6.eXIT"
                )
        );
        try {
            pickOption(selectedOption);
        } catch (Exception e) {
            System.out.printf("Error: %s \n", e.getMessage());
            System.out.println("-------------------------------");
        }
    }
    public static void displayMainMenu(){
        System.out.println("Welcome to BiciU!");
        System.out.println("This is the menu:");
        System.out.println("1. Register user.\n2. Borrow Bicycle.\n3. Return Bicycle.\n4.Pay Ticket.\n5.Tickets History.");
    }
    private static void pickOption(Integer option) {
        if (option==1) {
            MainServices.registerUser();
        } else if(option==2) {
            MainServices.borrowBycicle();
        } else if(option==3) {
            MainServices.returnBicycle();
        } else if(option==4) {
            MainServices.payTicket();
        } else if(option==5) {
            MainServices.ticketsHistory();
        } else {
            MainServices.exit();
        }
    }
}

