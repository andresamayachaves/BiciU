package main.java.biciU.Entities;

import main.java.biciU.Utils.ConsoleMenu;
import main.java.biciU.Enums.Status;

import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    private Status ticketStatus;
    private static User user = new User();
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
        this.user = userIn;
        this.amountToPay = amountToPay;
    }

    public void setUpdatesAtReturn() {
        check("Bike");
        check("Helmet");
    }

    private void setStatus(Status st){
     this.ticketStatus = st;
    }

    private void check(String element){                         //todo Bike returned out of time
        if(element=="Helmet") {
            helmetReturned = ConsoleMenu.renderAndVerify(
                    (option) -> List.of("Y", "N").contains(option.toUpperCase(Locale.ROOT)),
                    "did user return the helmet?");
        }
        if(helmetReturned=="Y"){
            String goodConditionElement = ConsoleMenu.renderAndVerify(
                    (option) -> List.of("Y", "N").contains(option.toUpperCase(Locale.ROOT)),
                    "did user return the "+element+" in good condition?");
            if(goodConditionElement =="N"){
                user.sumDebt(5.0);
                setStatus(Status.PENDING);
            }
        }else{
            user.sumDebt(5.0);
            setStatus(Status.PENDING);
        }
    }

    private  void goodConditionBike(){

    }

    public void generatePrintTicket(){

        //todo
    };

    public User getUser() {
        return user;
    }
}
