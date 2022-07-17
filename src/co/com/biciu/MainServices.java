package co.com.biciu;

import co.com.biciu.Enums.UserType;
import co.com.biciu.Utils.ConsoleMenu;
import co.com.biciu.Entities.User;
import com.sun.tools.jconsole.JConsoleContext;
import org.apache.commons.lang3.math.NumberUtils;

import java.lang.Math;
;

import java.util.List;
import java.util.Locale;

public class MainServices {


    public static void registerUser() {

       String  enteredUserType = ConsoleMenu.renderAndVerify(
                (text) -> List.of(UserType.class).contains(text.trim().toUpperCase(Locale.ROOT)),
                "Enter the user type, Professor/Student, (P/S): ");
        proceedRegistration(enteredUserType);1
    }

    private void proceedRegistration(UserType enteredUserType){
        String generatedID = generateID(enteredUserType.toString());
        String enteredName= ConsoleMenu.renderAndRead("Enter the following info:\nUser's name: ");
        System.out.println("Age: ");
        Integer enteredAge = Integer.parseInt(ConsoleMenu.renderAndVerify(
                (answer) -> NumberUtils.isNumber(answer),"Age: "));
        User newUser = new User(enteredUserType, generatedID, enteredName, enteredAge, 0);
        //todo save newUser in the DB}




    public static String generateID(String UserType) {
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


    //-----------------------------------


    public static void borrowBycicle() {
        //todo
        }
    }

    public static void returnBicycle() {
        //todo
    }

    public static void payTicket() {
        //todo
    }
    public static void ticketsHistory() {
        //todo
    }

    public static void exit() {
        //todos
    }


}
