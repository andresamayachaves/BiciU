package Classes.Entities;

import Enums.Status;
import java.sql.Date;

public class Ticket {
    // Attributes
    private String Code_num; // Code numeric part
    private String Code; // Code
    private Date dateStart;  // TODO use format 'YYYY-MM-DD'
    //private Hour hourStart;  // TODO manage only hours in format 'HH:MM'
    private Date dateEnd;   // TODO use format 'YYYY-MM-DD'
    //private Hour hourEnd; // TODO manage only hours in format 'HH:MM'
    private boolean helmetSupplied;
    private Status ticketStatus;
    private User user;
    private Double amountToPay; //In case of debt

    //Constructor


    public Ticket(String code_num, String code, Date dateStart, Date dateEnd, boolean helmetSupplied, Status ticketStatus, User user, Double amountToPay) {
        Code_num = code_num;
        Code = code;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.helmetSupplied = helmetSupplied;
        this.ticketStatus = ticketStatus;
        this.user = user;
        this.amountToPay = amountToPay;
    }
}
