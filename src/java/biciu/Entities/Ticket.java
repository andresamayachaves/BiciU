package java.biciu.Entities;

import java.biciu.Enums.Status;

import java.util.Date;

public class Ticket {
    // Attributes
    private final int code_num; // Code numeric part
    private final String code; // Code
    // private final Date dateStart;  // TODO use format 'YYYY-MM-DD'
    //private final Hour hourStart;  // TODO manage only hours in format 'HH:MM'
    // private final Date dateEnd;   // TODO use format 'YYYY-MM-DD'
    //private final Hour hourEnd; // TODO manage only hours in format 'HH:MM'
    private final boolean helmetSupplied;
    private final Status ticketStatus;
    private final User user = new User();
    private final Double amountToPay; //In case of debt

    public Ticket(){
        this.code_num = 0;
        this.code = "";
        //todo  this.dateStart = Date....;
        //todo this.dateEnd = dateEnd;
        this.helmetSupplied = false;
        this.ticketStatus = Status.ACTIVE;
        this.amountToPay = 0.0;
    }

    public Ticket(int code_num, String code, Date dateStart, Date dateEnd, boolean helmetSupplied, Status ticketStatus, User userIn, Double amountToPay) {
        this.code_num = code_num;
        this.code = code;
        //this.dateStart = dateStart;   todo
        //this.dateEnd = dateEnd;   todo
        this.helmetSupplied = helmetSupplied;
        this.ticketStatus = ticketStatus;
        //this.user = userIn;
        this.amountToPay = amountToPay;
    }

    public void generatePrintTicket(){

        //todo
    };
}
