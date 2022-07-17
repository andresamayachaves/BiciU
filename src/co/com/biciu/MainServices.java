package co.com.biciu;

import co.com.biciu.Enums.UserType;
import co.com.biciu.Utils.ConsoleMenu;
import com.sun.tools.jconsole.JConsoleContext;

import java.lang.Math;
;

import java.util.List;
import java.util.Locale;

public class MainServices {

    public static void registerUser() {

       String  enteredUserType = ConsoleMenu.renderAndVerify(
                (text) -> List.of(UserType.class).contains(text.trim().toUpperCase(Locale.ROOT)),
                "Enter the user type (Professor/Student): ");
        proceedRegsitration();
    }

    private void proceedRegsitration();{
        String generatedID = generateID();
        User newUser = new User(enteredUserType, generatedID, enteredName, enteredAge, 0);
    }

    private String generateID() {
        numPart = ConsoleMenu.uniqueID();

        String beginning = ConsoleMenu.renderAndVerify(
                (option) ->List.of("S", "P").contains(option.toUpperCase(Locale.ROOT)),
                "Is the user a Student or a Professor? (S/P): ");
        return beginning + numPart;
    }

    //-----------------------------------


    public static void borrowBycicle() {
    }

    public static void returnBicycle() {
    }

    public static void payTicket() {
    }
    public static void ticketsHistory() {

    }

    public static void exit() {
    }


}
