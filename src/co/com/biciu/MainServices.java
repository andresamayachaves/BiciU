package co.com.biciu;

import co.com.biciu.Enums.*;
import co.com.biciu.Services.EntitiesServices;
import co.com.biciu.Utils.ConsoleMenu;
import co.com.biciu.Entities.*;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.math.NumberUtils;

import java.lang.Math;
;

import java.util.List;
import java.util.Locale;

public class MainServices {

    //----------------------------------- registerUser()
    public static void registerUser() {

       String  enteredUserType = ConsoleMenu.renderAndVerify(
                (text) -> List.of(UserType.class).contains(text.trim().toUpperCase(Locale.ROOT)),
                "Enter the user type, Professor/Student, (P/S): ");
        proceedRegistration(UserType.valueOf(enteredUserType));
    }

    private static void proceedRegistration(UserType enteredUserType){

        String generatedID = generateID(enteredUserType.toString());
        String enteredName = ConsoleMenu.renderAndRead("Enter the following info:\nUser's name: ");
        System.out.println("Age: ");
        Integer enteredAge = Integer.parseInt(ConsoleMenu.renderAndVerify(
                (answer) -> NumberUtils.isNumber(answer), "Age: "));
        User newUser = new User(enteredUserType, generatedID, enteredName, enteredAge, 0);
        //todo save newUser in the DB
        System.out.println("¡Register Completed!\n");
        newUser.printUserInfo();

    }


    public static String generateID(String typeShort) {
        String idProv = "";
        boolean idExists = false;
        while (!idExists){
            String numPart1 = Double.toString(Math.floor(Math.random()*99999));
            String numPart2 = Double.toString(Math.floor(Math.random()*99999));
            idProv =  typeShort+"-"+numPart1+numPart2;
            idExists = ConsoleMenu.existsInDB(idProv);    //todo 2nd arg
        }
        return  idProv;
    }


    //----------------------------------- borrowBicycle()

    public static void borrowBicycle() {
        String  enteredUserId = ConsoleMenu.renderAndVerify(
                (answer) -> NumberUtils.isNumber(answer),"Enter the user ID: ");
        User userBorrow = EntitiesServices.findUserByID(enteredUserId).get();
        if(!userBorrow.userHasDebt()){
                BikeType enteredType = chooseTypeBike();
                EntitiesServices.getRandomBikeFromStock(enteredType);
        }else{
            System.out.println("User has debt, so the borrowing is not possible at this time.");
        }


        //todo
    }

    }


    private static BikeType chooseTypeBike(){

        BikeType chosenType;
        int selectedOption = Integer.parseInt(
                ConsoleMenu.renderAndVerify(
                        (option) -> NumberUtils.isNumber(option) && Range.between(1, 2).contains(Integer.parseInt(option)),
                        "1. Mountain.", "2. Road"));
        if (selectedOption ==1){
            chosenType = BikeType.MOUNTAIN;
        }else{ chosenType = BikeType.ROAD;
        }
        return chosenType;
    }


    //----------------------------------- returnBicycle()
    public static void returnBicycle() {
        //todo
    }

    //-----------------------------------  payTicket()
    public static void payTicket() {
        //todo
    }

    //-----------------------------------  ticketsHistory()
    public static void ticketsHistory() {
        //todo
    }

    //----------------------------------- exit()
    public static void exit() {
        //todos
    }


}
