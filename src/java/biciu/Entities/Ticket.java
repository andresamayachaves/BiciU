package java.biciu.Entities;

import java.biciu.Enums.Status;

import java.biciu.Utils.ConsoleMenu;
import java.util.Date;
import java.util.List;

public class Ticket {
    // Attributes
    private final int code_num; // Code numeric part
    private final String code; // Code
    // private final Date dateStart;  // TODO use format 'YYYY-MM-DD'
    //private final Hour hourStart;  // TODO manage only hours in format 'HH:MM'
    // private final Date dateEnd;   // TODO use format 'YYYY-MM-DD'
    //private final Hour hourEnd; // TODO manage only hours in format 'HH:MM'
    private static String helmetReturned;
    private static String goodCondition;
    private final Status ticketStatus;
    private final User user = new User();
    private final Double amountToPay; //In case of debt

    public Ticket(){
        this.code_num = 0;
        this.code = "";
        //todo  this.dateStart = Date....;
        //todo this.dateEnd = dateEnd;
        this.helmetReturned = "N";
        this.goodCondition = "Y";
        this.ticketStatus = Status.ACTIVE;
        this.amountToPay = 0.0;
    }

    public Ticket(int code_num, String code, Date dateStart, Date dateEnd, String helmetSupplied, String goodCondition,Status ticketStatus, User userIn, Double amountToPay) {
        this.code_num = code_num;
        this.code = code;
        //this.dateStart = dateStart;   todo
        //this.dateEnd = dateEnd;   todo
        this.helmetReturned = helmetSupplied;
        this.goodCondition = goodCondition;
        this.ticketStatus = ticketStatus;
        //this.user = userIn;
        this.amountToPay = amountToPay;
    }

    public static void setUpdates() {
        helmetReturned = ConsoleMenu.renderAndVerify(
                (option) -> List.of("Y", "N").contains(option.toUppercase(Lcale.ROOT)),
                "did user return the helmet?");
        goodCondition = ConsoleMenu.renderAndVerify(
                (option) -> List.of("Y", "N").contains(option.toUppercase(Lcale.ROOT)),
                "did user return the helmet?");
        if(helmet== "Y"){
        }else{
            User.sumDebt();
        }

    }

    public void generatePrintTicket(){

        //todo
    };
}
