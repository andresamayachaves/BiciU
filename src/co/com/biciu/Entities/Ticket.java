package co.com.biciu.Entities;

import co.com.biciu.Enums.Status;

import java.util.Date;

public class Ticket {
    // Attributes
    private final String Code_num; // Code numeric part
    private final String Code; // Code
    private final Date dateStart;  // TODO use format 'YYYY-MM-DD'
    //private final Hour hourStart;  // TODO manage only hours in format 'HH:MM'
    private final Date dateEnd;   // TODO use format 'YYYY-MM-DD'
    //private final Hour hourEnd; // TODO manage only hours in format 'HH:MM'
    private final boolean helmetSupplied;
    private final Status ticketStatus;
    private final User user = new User();
    private final Double amountToPay; //In case of debt

    public Ticket(String code_num, String code, Date dateStart, Date dateEnd, boolean helmetSupplied, Status ticketStatus, User userIn, Double amountToPay) {
        Code_num = code_num;
        Code = code;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.helmetSupplied = helmetSupplied;
        this.ticketStatus = ticketStatus;
        //this.user = userIn;
        this.amountToPay = amountToPay;
    }
}
