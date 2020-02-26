package changeJarPack;


import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * The purpose this class is to simulate a change Jar.
 *
 *
 * 	 NOTE: MUCH MORE CODING IS NEEDED IN THESE METHODS, and you
 * 	 will need to comply with the Java Style Guide.
 * 	 HOWEVER,  HERE IS SOME STARTING CODE.
 *
 * @suthor
 */

public class ChangeJar {

    private static boolean isMutate;


    DecimalFormat currency = new DecimalFormat("0.00");
    /**
     * The number of quarters in the current Jar
     */
    private int quarters;

    /**
     * The number of dimes in the current Jar
     */
    private int dimes;

    // Now you do the rest of the instance variables using the
    // Java Style guide.
    private int nickels;
    private int pennies;

    /******************************************************************
     *  The is the default constuctor for ChangeJar
     */

    public ChangeJar() {
        quarters = 0;
        dimes = 0;
        nickels = 0;
        pennies = 0;

    }

    public ChangeJar(double amount) {
        int amountToCents = (int) (amount * 100);

        quarters = amountToCents / 25; //counts quarters
        amountToCents = amountToCents - (quarters * 25); // subtracts quarters from total

        dimes = amountToCents / 10; //counts dimes
        amountToCents = amountToCents - (dimes * 10); // subtracts dimes from total

        nickels = amountToCents / 5; //counts nickles
        amountToCents = amountToCents - (nickels * 5); //subtracts nickels from total

        pennies = amountToCents; //counts pennies


    }

    /******************************************************************
     *
     *   This constructor creates a Change Jar from an existing
     *    Change Jar.
     *
     * @param other is an existing Change Jar
     */


    public ChangeJar(ChangeJar other) {
        quarters = other.quarters;
        dimes = other.dimes;
        nickels = other.nickels;
        pennies = other.pennies;
    }

    public ChangeJar(String amount) {

        if(containsIllegals(amount) == true){
            throw new IllegalArgumentException();
        }else {

            double amtToDbl = Double.parseDouble(amount);
            currency.format(amtToDbl);
            int amountToCents = (int) (amtToDbl * 100); //converts to cents

            quarters = amountToCents / 25; //counts quarters
            amountToCents = amountToCents - (quarters * 25); // subtracts quarters from total

            dimes = amountToCents / 10; //counts dimes
            amountToCents = amountToCents - (dimes * 10); // subtracts dimes from total

            nickels = amountToCents / 5; //counts nickles
            amountToCents = amountToCents - (nickels * 5); //subtracts nickels from total

            pennies = amountToCents; //counts pennies
        }


    }

    public boolean containsIllegals(String toExamine){
        Pattern pattern = Pattern.compile("[abcdefghijklmnopqrstuvwxyz!$&()=~#@*%{}<>';:,?|_^] ");
        Matcher matcher = pattern.matcher(toExamine);
        return matcher.find();
    }

    public boolean equals(Object other) {
        boolean rtn = false;

        if (other != null) {
            if (other instanceof ChangeJar) {
                ChangeJar temp = (ChangeJar) other;

                if (this.getAmount() == temp.getAmount()) {
                    rtn = true;
                } else {
                    rtn = false;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        return rtn;
    }


    public static boolean equals(ChangeJar jar1, ChangeJar jar2) {
        if (jar1 != null || jar2 != null) {
            if (jar1.getAmount() == jar2.getAmount()) {
                return true;
            } else {
                return false;
            }

        } else {
            throw new IllegalArgumentException();
        }
    }


    public int compareTo(ChangeJar other) {
        if (other != null) {
            if (this.getAmount() > other.getAmount()) {
                return 1;
            } else if (this.getAmount() < other.getAmount()) {
                return -1;
            } else {
                return 0;
            }
        }
        throw new IllegalArgumentException();
    }


    public static int compareTo(ChangeJar jar1, ChangeJar jar2) {
        if (jar1 != null && jar2 != null) {
            if (jar1.getAmount() > jar2.getAmount()) {
                return 1;
            } else if (jar1.getAmount() < jar2.getAmount()) {
                return -1;
            } else {
                return 0;
            }
        }
        throw new IllegalArgumentException();
    }


    public void takeOut(int quarters, int dimes, int nickels, int pennies) {
        // A method that subtracts the parameters from the “this” ChangeJar object.
        // You may assume all of the parameter are positive
        setMutate(true);

        if (quarters >= 0 && dimes >= 0 && nickels >= 0 && pennies >= 0) {
            if (quarters <= this.quarters && dimes <= this.dimes && nickels <= this.nickels && pennies <= this.pennies) {
                this.quarters = this.quarters - quarters;
                this.dimes = this.dimes - quarters;
                this.nickels = this.nickels - quarters;
                this.pennies = this.pennies - quarters;
            } else {
                throw new IllegalArgumentException();
            }

        } else {
            throw new IllegalArgumentException();
        }
    }


    public void takeOut(ChangeJar other) {
        // A method that subtracts ChangeJar other to the “this” ChangeJar object.
        // (For step 2 there are no worries about errors)

        if (other.quarters >= 0 && other.dimes >= 0 && other.nickels >= 0 && other.pennies >= 0) {
            if (other.quarters <= this.quarters && other.dimes <= this.dimes && other.nickels <= this.nickels && other.pennies <= this.pennies) {
                this.quarters = this.quarters - other.quarters;
                this.dimes -= other.dimes;
                this.nickels -= other.nickels;
                this.pennies -= other.pennies;
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void dec(){
        setMutate(true);

        if(this.pennies > 0) {
            this.pennies--;
        }else{
            throw new IllegalArgumentException();
        }

    }

    public void add(int quarters, int dimes, int nickels, int pennies) {
        // A method that adds the parameters from the "this" ChangeJar object.
        // You may assume all of the parameter are positive.
        setMutate(true);

        this.quarters += quarters;
        this.dimes += dimes;
        this.nickels += nickels;
        this.pennies += pennies;


    }

    public void add(ChangeJar other) {
        // A method that add ChangeJar other to the "this ChangeJar object
        setMutate(true);

        this.quarters += other.getQuarters();
        this.dimes += other.getDimes();
        this.nickels += other.getNickels();
        this.pennies += other.getPennies();
    }

    public void inc(){
        setMutate(true);

        this.pennies++;
    }

    public String toString() {

        String s = this.quarters + " Quarter" + ((quarters != 1) ? "s" : "") + "\n"
                + this.dimes + " Dime" + ((dimes != 1) ? "s" : "") + "\n"
                + this.nickels + " Nickel" + ((nickels != 1) ? "s" : "") + "\n"
                + this.pennies + " Penn" + ((pennies != 1) ? "ies" : "y") + "\n";

        return s;
    }

    /******************************************************************
     *
     *   This constructor creates a Change Jar from with some
     *   initial values for Quarters, Dimes, Nickels, and Pennies.
     **
     * @param quarters is the number of quarters to start with.
     * @param dimes is the number of dimes to start with.
     * @param nickels is the number of nicels to start with.
     * @param pennies is the number of pennies to start with.
     *
     */
    public ChangeJar(int quarters, int dimes, int nickels, int pennies) {
        super();

        if (quarters < 0 || dimes < 0 || nickels < 0 || pennies < 0) {
            throw new IllegalArgumentException();
        }

        this.quarters = quarters;
        this.dimes = dimes;
        this.nickels = nickels;
        this.pennies = pennies;
    }

// REMEBER to use the Java Style Guide for the rest of your code.

    private static int convertToPennies(ChangeJar temp) {
        return (temp.quarters * 25) + (temp.dimes * 10) + (temp.nickels * 5) + temp.pennies;
    }

    public static void mutate(boolean selected) {
//        A method that turns ‘off’ (false) and ‘on’ (true)
//        any subtract/add methods in ChangeJar based on the value (true,false) of the variable ‘on’. In other
//        words, when on is false, this prevents any subtract/add method from changing (mutate) the state of the
//        “this” object as it relates to the amount in the ChangeJar.
        isMutate = selected;

    }

    public ChangeJar takeOut (double amount) {
        currency.format(amount);
        int amtToCents = (int) (amount * 100);
        int countQ = 0;
        int countD = 0;
        int countN = 0;
        int countP = 0;

        if(this.quarters > 0) {
            for (int q = this.quarters; q > 0; q--) {
                if (amtToCents > 25) {
                    amtToCents = amtToCents - 25;
                    countQ++;
                }
            }
            if (this.dimes > 0) {
                for (int d = this.dimes; d > 0; d--) {
                    if (amtToCents > 10) {
                        amtToCents = amtToCents - 10;
                        countD++;
                    }
                }
            }
                    if (this.nickels > 0) {
                        for (int n = this.nickels; n > 0; n--) {
                            if (amtToCents > 5) {
                                amtToCents = amtToCents - 5;
                                countN++;
                            }
                        }
                    }
                    if(this.pennies > 0 ) {
                        for (int p = this.pennies; p > 0; p--) {
                            if (amtToCents > 0) {
                                amtToCents = amtToCents - 1;
                                countP++;
                            }
                        }
                    }

            }

        this.quarters -= countQ;
        this.dimes -= countD;
        this.nickels -= countN;
        this.pennies -= countP;

        ChangeJar other = new ChangeJar(countQ, countD, countN, countP);
        return other;
    }







    public void save(String fileName) {
        PrintWriter out = null;
            try {
                out = new PrintWriter(new BufferedWriter(new FileWriter(
                        fileName)));
                out.print(getQuarters() + " " +getDimes() + " " + getNickels() + " " +getPennies());
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.close();
        }



    public void load(String fileName) {

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
            setQuarters(scanner.nextInt());
            setDimes(scanner.nextInt());
            setNickels(scanner.nextInt());
            setPennies(scanner.nextInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public double getAmount () {
        return convertToPennies(this) / 100.0;
    }


    public static void main(String[] args) {
        //**public ChangeJar(ChangeJar other)**//
            ChangeJar other = new ChangeJar(5, 5, 5, 5);
            ChangeJar jar2 = new ChangeJar(other);


        //**public ChangeJar(String amount)**//
            ChangeJar s = new ChangeJar("2.82");
            System.out.println("2.82 Amount: \n" + s);

            s = new ChangeJar("8");
            System.out.println("8 Amount: \n" + s);

            s = new ChangeJar(".28");
            System.out.println(".28 Amount: \n" + s);

        //**public ChangeJar(double amount)**//
            ChangeJar s1 = new ChangeJar();
            System.out.println("0 Amount: \n" + s1);

            s1.add(1,1,1,100);
            System.out.println("1,1,1,100 Amount: \n" + s1);

            ChangeJar s2 = new ChangeJar(41.99);
            s2.add(0,0,0,99);
            for (int i = 0; i < 100; i++)
                s2.dec();
            System.out.println("amount: \n" + s2);

        //**public boolean equals(Object other)**//
            ChangeJar temp = new ChangeJar(2, 2, 2, 2);
            System.out.println("Object other: " + other.equals(jar2));
            System.out.println(("Object other: " + other.equals(temp)));

        //**public static boolean equals(ChangeJar Jar 1, ChangeJar jar2**//
            System.out.println(equals(s1, s2));
            ChangeJar same1 = new ChangeJar(2.5);
            ChangeJar same2 = new ChangeJar("2.50");
            System.out.println(equals(same1, same2)+ "\n");

        //**public int compareTo(ChangeJar other)**//
            System.out.println("Compare to: " + other.compareTo(jar2));

        //** public int compareTo(ChangeJar jar1, ChangeJar jar2)**//
            System.out.println(compareTo(s1, s2));
            System.out.println(compareTo(s2, s1));
            System.out.println(compareTo(s1, s1) + "\n");

        //**  public void takeOut(int quarters, int dimes, int nickels, int pennies)**//
            s1.takeOut(0, 1, 1, 1);
            //s1.takeOut(-1, 1, 1, 1);

       //**public void takeOut(ChangeJar other)**//

        //**public void dec()**//
            s1.dec();

        //**public void add(int quarters, int dimes, int nickels, int pennies)**//
        ChangeJar s3 = new ChangeJar(1.0);
        System.out.println("s3 Amount before: " + s3.getAmount());
        s3.add(1, 4, 4, 2);
        System.out.println("s3 Amount after: " + s3.getAmount());

        //**public void add(ChangeJar other)**//

        //**public void inc()**//
            s1.inc();

        //**GETTERS/SETTERS**//
            s1.setQuarters(3);
            System.out.println(s1.getQuarters());

            s2.setDimes(6);
            System.out.println(s2.getDimes());

            s1.setNickels(2);
            System.out.println(s1.getNickels());

            s1.setPennies(12);
            System.out.println(s1.getPennies());


    }

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    public int getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }

    public boolean isMutate() {
        return isMutate = true;
    }

    public void setMutate(boolean mutate) {
        isMutate = mutate;
    }
}