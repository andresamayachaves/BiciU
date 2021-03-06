package biciU;

import biciU.Services.EntitiesServices;
import biciU.Services.MainServices;
import biciU.Utils.ConsoleMenu;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.math.NumberUtils;


// Main Class
public class biciU {

    // main method
    public static void main(String[] args) {
        EntitiesServices.createDefaultBikeStock();
        int selectedOption = Integer.parseInt(
                ConsoleMenu.renderAndVerify(
                        (option) -> NumberUtils.isNumber(option) && Range.between(1, 6).contains(Integer.parseInt(option)),
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

    private static void pickOption(Integer option) {
        if (option==1) MainServices.registerUser();
        else if(option==2) MainServices.borrowBicycle();
        else if(option==3) MainServices.returnBicycle();
        else if(option==4) MainServices.payTicket();
        else if(option==5) MainServices.ticketsHistory();
        else MainServices.exit();
    }
}

