package main.biciU.Entities;

import main.biciU.Enums.Status;
import main.biciU.Utils.ConsoleMenu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

public class Ticket {
    // Attributes
    private final int code_num; // Code numeric part
    private final String code; // Code
    private final LocalDate dateStart;
    private final LocalTime timeStart;
    private final LocalDate dateEnd;
    private LocalTime  timeEnd;
    private static String helmetReturned;
    private static String goodCondition;
    private Status ticketStatus;
    private static User user = new User();
    private final Double amountToPay; //In case of debt

    public Ticket(){
        this.code_num = 0;
        this.code = "";
        this.dateStart = LocalDate.now();
        this.dateEnd = LocalDate.now();
        this.timeStart = LocalTime.now();
        this.timeEnd = LocalTime.now();
        this.helmetReturned = "N";
        this.goodCondition = "Y";
        this.ticketStatus = Status.ACTIVE;
        this.amountToPay = 0.0;
    }

    public Ticket(int code_num, String code, LocalDate dateStart, LocalTime timeStart, LocalDate dateEnd, LocalTime timeEnd, Status ticketStatus, Double amountToPay, LocalTime endTime) {
        this.code_num = code_num;
        this.code = code;
        this.dateStart = dateStart;
        this.timeStart = timeStart;
        this.dateEnd = dateEnd;
        this.timeEnd = timeEnd;
        this.ticketStatus = ticketStatus;
        this.amountToPay = amountToPay;

    }

    public void setUpdatesAtReturn() {
        check("Bike");
        check("Helmet");
    }

    private void setStatus(Status st){
     this.ticketStatus = st;
    }

    private void check(String element){

        user.sumDebt(3.0*returnedOutOfTime());

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

    private int  returnedOutOfTime(){
        int out30 =(int)this.timeEnd.until(this.timeStart, ChronoUnit.HOURS) *2;
        return out30;
    }

    private  void goodConditionBike(){

    }

    public void generatePrintTicket(){

        //todo
    };

    public User getUser() {
        return user;
    }

    public void updateEndTime(){
        this.timeEnd = LocalTime.now();
    }

}
