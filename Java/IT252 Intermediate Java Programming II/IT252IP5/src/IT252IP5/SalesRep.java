/**
 * Course: IT252 - Intermediate Java Programming II
 * Filename:SalesRep.java
 * Module: Class Definition
 * Created: 04/05/2016
 * Modified:04/28/2016
 * 
 * Purpose: This class definition will hold all of the information about the sales representative.
 * Modification:
 * 04/05/2016 Created class definition.
 * 04/22/2016 Added class method to compute the total sold for class items
 * 04/28/2016 Modified the toString to build a formatted string of the class objects
 * 
 */
package IT252IP5;

/**
 *
 * @author Duane Osburn
 */
public class SalesRep {
    private int salesRepID;
    private String firstName;
    private String lastName;
    private double offSupp;
    private double books;
    private double paper;
    private String salesDist;
    private boolean phone;
    private boolean email;
    private boolean visit;

    
    public int getSalesRepID() {
        return salesRepID;
    }

    public void setSalesRepID(int salesRepID) {
        this.salesRepID = salesRepID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getOffSupp() {
        return offSupp;
    }

    public void setOffSupp(double offSupp) {
        this.offSupp = offSupp;
    }

    public double getBooks() {
        return books;
    }

    public void setBooks(double books) {
        this.books = books;
    }

    public double getPaper() {
        return paper;
    }

    public void setPaper(double paper) {
        this.paper = paper;
    }

    public String getSalesDist() {
        return salesDist;
    }

    public void setSalesDist(String salesDist) {
        this.salesDist = salesDist;
    }

    public boolean isPhone() {
        return phone;
    }

    public void setPhone(boolean phone) {
        this.phone = phone;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public boolean isVisit() {
        return visit;
    }

    public void setVisit(boolean visit) {
        this.visit = visit;
    }
    
    public double computeTotal(){
        double total = getOffSupp() + getBooks() + getPaper();
        return total;
    }

    //@Override
    //public String toString() {
    //    return "SalesRep{" + "salesRepID=" + salesRepID + ", firstName=" + firstName + ", lastName=" + lastName + ", offSupp=" + offSupp + ", books=" + books + ", paper=" + paper + ", salesDist=" + salesDist + ", phone=" + phone + ", email=" + email + ", visit=" + visit + '}';
    //}
    @Override
    public String toString(){
        return "Sales ID= " + salesRepID + "\t" + "\t" + "First Name= " + firstName + "\t" + "Last Name=" + lastName + "\n" +
                "Office Supplies= $" + offSupp + "\t" + "Books= $" + books + "\t" + "Paper= $" + paper + "\n" +
                "Sales District= " + salesDist + "\t" + "Phone Contact= " + phone + "\t" + "E-mail Contact= " + email + "\t" + "Visit Contact =" + visit + "\n";
    }
}
