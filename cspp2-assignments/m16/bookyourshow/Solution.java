/**
 * @author Praveen
 */
/**.
 * { For Scanner }.
 */
import java.util.Scanner;
/**.
 * Class for patron.
 */
class Patron {
    /**.
     * { Private Variables }.
     */
    private String name, phoneno;
    /**.
     * Constructs the object.
     *
     * @param      nme    The nme
     * @param      phono  The phono
     */
    Patron(final String nme, final String phono) {
        this.name = nme;
        this.phoneno = phono;
    }
    /**.
     * { Setter }.
     *
     * @param      nme  The name
     *
     * @return     { description_of_the_return_value }
     */
    public String setname(final String nme) {
        return this.name;
    }
    /**.
     * { setPhone Number }.
     *
     * @param      phone  The phoneno
     *
     * @return     { String }.
     */
    public String setphoneno(final String phone) {
        return this.phoneno;
    }
    /**.
     * { Getter Name }.
     *
     * @return     { String }.
     */
    public String getname() {
        return name;
    }
    /**.
     * { Get Phone Number }.
     *
     * @return     { String }.
     */
    public String getphoneno() {
        return phoneno;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.getname() + "," + this.getphoneno();
    }
}
/**.
 * Class for show.
 */
class Show {
    /**.
     * { For movieNAme }
     */
    private String moviename;
    /**.
     * { For Date Time }.
     */
    private String datetime;
    /**.
     * { For Seats }.
     */
    private String[] seats;
    /**.
     * Constructs the object.
     *
     * @param      mvnme   The mvnme
     * @param      dtetme  The dtetme
     * @param      seat    The seat
     */
    Show(final String mvnme, final String dtetme, final String[] seat) {
        this.moviename = mvnme;
        this.datetime = dtetme;
        this.seats = seat;
    }
    /**.
     * { Setter for moviename }.
     *
     * @param      mvnme  The mvnme
     *
     * @return     { String }.
     */
    public String setmovie(final String mvnme) {
        return this.moviename;
    }
    /**.
     * { Setter for Date Time },
     *
     * @param      dtetme  The dtetme
     *
     * @return     { String }.
     */
    public String setdatetime(final String dtetme) {
        return this.datetime;
    }
    /**.
     * { Setter for Seats }.
     *
     * @param      seat  The seat
     *
     * @return     { String Array }.
     */
    public String[] setseat(final String[] seat) {
        return this.seats;
    }
    /**.
     * { Getter for Movie Name }.
     *
     * @return     { String }.
     */
    public String getmovie() {
        return this.moviename;
    }
    /**.
     * { Getter Date Time }.
     *
     * @return     { String }.
     */
    public String getdatetime() {
        return this.datetime;
    }
    /**.
     * { Getter Seat }.
     *
     * @return     { String Array }.
     */
    public String[] getseat() {
        return this.seats;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.getmovie() + "," + this.getdatetime();
    }
}
/**.
 * Class for book your show.
 */
class BookYourShow {
    /**.
     * { List of Show objects }.
     */
    private List<Show> shows;
    /**.
     * { List of Strings }.
     */
    private List<String> tickets;
    /**.
     * Constructs the object.
     */
    BookYourShow() {
        shows = new List<Show>();
        tickets = new List<String>();
    }
    /**.
     * Adds a show.
     *
     * @param      s     { Show object }.
     */
    public void addAShow(final Show s) {
        shows.add(s);
    }
    /**.
     * Gets a show.
     *
     * @param      moviename  The moviename
     * @param      datetime  The datetime
     *
     * @return     A show.
     */
    public Show getAShow(final String moviename, final String datetime) {
        for (int i = 0; i < shows.size(); i++) {
            Show show = shows.get(i);
            if (show.getmovie().equals(moviename)
                && show.getdatetime().equals(datetime)) {
                return show;
            }
        }
        return null;
    }
    /**.
     * { BookAshow method }.
     *
     * @param      moviename  The moviename
     * @param      datetime  The datetime
     * @param      p         { parameter_description }
     * @param      seats     The seats
     */
    public void bookAShow(final String moviename,
        final String datetime, final Patron p, final String[] seats) {
        /**.
         * { getAshow }.
         */
        Show show = getAShow(moviename, datetime);
        if (show == null) {
            System.out.println("No show");
        } else {
            String[] showseats = show.getseat();
            for (int i = 0; i < showseats.length; i++) {
                for (int j = 0; j < seats.length; j++) {
                    if (seats[j].equals(showseats[i])) {
                        showseats[i] = "N/A";
                    }
                }
            }
            StringBuffer s = new StringBuffer();
            s.append(p.getphoneno() + " ");
            s.append(moviename + " ");
            s.append(datetime);
            tickets.add(s.toString());
        }
    }
    /**.
     * Method to print the ticket
     *
     * @param      moviename  The moviename
     * @param      datetime  The datetime
     * @param      mobile    The mobile
     */
    public void printTicket(final String moviename,
        final String datetime, final String mobile) {
        /**.
         * { Ticket variable }.
         */
        String ticket = mobile + " " + moviename + " " + datetime;
        // for (int i = 0;i < tickets.size(); i++) {
        if (tickets.contains(ticket)) {
                System.out.println(ticket);
        } else {
            System.out.println("Invalid");
        }
    }
    /**.
     * Shows all
     */
    public void showAll() {
        for (int i = 0; i < shows.size(); i++) {
            StringBuffer sb = new StringBuffer();
            Show show = shows.get(i);
            sb.append(show + ",[");
            String[] seats = show.getseat();
            for (int j = 0; j < seats.length - 1; j++) {
                sb.append(seats[j] + ",");
            }
            sb.append(seats[seats.length - 1] + "]");
            System.out.println(sb.toString());
        }
    }
}
/**.
 * Solution class
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
                case "add":
                    int k = 2;
                    String[] seats = new String[tokens.length - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

                case "book":
                    k = 2 + 2;
                    seats = new String[tokens.length - 2 - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.bookAShow(check[1], tokens[1],
                        new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

                case "get":
                    Show show = bys.getAShow(check[1], tokens[1]);
                    if (show != null) {
                       System.out.println(show);
                    } else {
                        System.out.println("No show");
                    }
                break;

                case "print":
                    bys.printTicket(check[1], tokens[1], tokens[2]);
                break;

                case "showAll":
                    bys.showAll();
                break;

                default:
                break;
            }
        }
    }
}
