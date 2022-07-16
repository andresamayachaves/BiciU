package Classes;

import org.apache.commons.lang3.Range;


// Main Class
public class BiciU {

    // main method
    public static void main(String[] args) {

        displayMainMenu();
        int selectedOption = Integer.parseInt(
                ConsoleMenu.renderAndVerify(
                        (option) -> NumberUtils.isParsable(option) && Range.between(1, 5).contains(Integer.parseInt(option)),
                        "1. Register user.", "2. Borrow Bicycle.", "3. Return Bicycle.", "4.Pay Ticket.","5.Tickets History."
                )
        );
        try {
            pickOption(selectedOption);
        } catch (Exception e) {
            System.out.printf("Error: %s \n", e.getMessage());
            System.out.println("-------------------------------");
        }



        Optional<Integer> selectedOption = Optional.empty();
        while (selectedOption.isEmpty() || selectedOption.get() != 0) {
            try {
                System.out.println("Please select one of the latter options : ");
                selectedOption = Optional.of(Integer.valueOf(ConsoleMenu.renderAndRead(
                        "1. Register user.", "2. Borrow Bicycle.", "3. Return Bicycle.", "4.Pay Ticket.","5.Tickets History."
                )));
                callModule(selectedOption.get());
            } catch (NumberFormatException e) {
                System.out.println("The given option doesn't exist. Please enter one of the listed above.");
            }
        }
    }


    public static void displayMainMenu(){
        System.out.println("Welcome to BiciU!");
        System.out.println("This is the menu:");
        System.out.println("1. Register user.\n2. Borrow Bicycle.\n3. Return Bicycle.\n4.Pay Ticket.\n5.Tickets History.");
    }

}

