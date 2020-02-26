package changeJarPack;
import javafx.scene.control.TextFormatter;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChangeJarTest {

    /**
     * Your assignment is to write many more test cases to
     * have a robust testing, more than just 100% coverage.
     * <p>
     * Some examples are provided to help you get started
     */


    //**Testing valid constructors with wide range of values**//
    @Test
    public void testConstructor() {
        ChangeJar jar1 = new ChangeJar(6, 5, 4, 2);

        assertEquals(6, jar1.getQuarters());
        assertEquals(5, jar1.getDimes());
        assertEquals(4, jar1.getNickels());
        assertEquals(2, jar1.getPennies());

        ChangeJar jar2 = new ChangeJar();
        assertEquals(0, jar2.getQuarters());
        assertEquals(0, jar2.getDimes());
        assertEquals(0, jar2.getNickels());
        assertEquals(0, jar2.getPennies());

        ChangeJar jar3 = new ChangeJar(jar1);
        assertEquals(6, jar3.getQuarters());
        assertEquals(5, jar3.getDimes());
        assertEquals(4, jar3.getNickels());
        assertEquals(2, jar3.getPennies());
    }
    // testing negative number quarters for the constructor
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegQuarters() {
        new ChangeJar(-300, 0, 0, 0);
    }

    // testing negative number DIMES for the constructor
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegDimes() {
        new ChangeJar(0, -300, 0, 0);
    }

    // testing negative number NICKLES for the constructor
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorNegNickles() {
        new ChangeJar(0, 0, -300, 0);
    }

    // testing negative number PENNIES for the constructor
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegPennies() {
        new ChangeJar(0, 0, 0, -300);
    }

    //-------------------------------------------------------------------------------------------
    //** Testing ChangeJar(String amount)
    @Test
    public void stringTest1(){
        ChangeJar jar = new ChangeJar("1.22");
        assertEquals(4, jar.getQuarters());
        assertEquals(2, jar.getDimes());
        assertEquals(0, jar.getNickels());
        assertEquals(2, jar.getPennies());

    }

    //** Testing invalid strings
    @Test(expected = IllegalArgumentException.class)
    public void stringTest2(){
        ChangeJar jar = new ChangeJar("12.a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void stringTest3(){
        ChangeJar jar = new ChangeJar("$12.3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void stringTest4(){
        ChangeJar jar = new ChangeJar("5?.@0");
    }
//---------------------------------------------------------------------------------------------
    //**Testing equals(Object other)**//
    @Test
    public void testEqual() {
        ChangeJar jar1 = new ChangeJar(2, 5, 4, 2);
        ChangeJar jar2 = new ChangeJar(6, 5, 4, 2);
        ChangeJar jar3 = new ChangeJar(2, 5, 4, 2);

        assertFalse(jar1.equals(jar2));
        assertTrue(jar1.equals(jar3));
}

    //**Testing equals for invalid values
    @Test(expected = IllegalArgumentException.class)
    public void testEqual2(){
        ChangeJar jar1 = new ChangeJar(2, 3, 4 ,5);
        ChangeJar jar2 = new ChangeJar("null");

        jar1.equals(jar2);
    }

    //**Testing equals(jar1, jar2) is true
    @Test
    public void testEqual3(){
        ChangeJar jar1 = new ChangeJar(1,1,1,1);
        ChangeJar jar2 = new ChangeJar(1,1,1,1);

        assertEquals(true, ChangeJar.equals(jar1, jar2));

    }

    //**Testing equals(jar1, jar2) is false
    @Test
    public void testEqual4(){
        ChangeJar jar1 = new ChangeJar(1,1,1,1);
        ChangeJar jar2 = new ChangeJar(2,1,1,1);

        assertEquals(false, ChangeJar.equals(jar1, jar2));;

    }

//---------------------------------------------------------------------------------------------
// **Testing compareTo(Object other)

    //**Testing compareTo(ChangeJar other)**//
    @Test
    public void testCompareTo() {
        ChangeJar jar1 = new ChangeJar(2, 5, 4, 2);
        ChangeJar jar2 = new ChangeJar(6, 5, 4, 2);
        ChangeJar jar3 = new ChangeJar(2, 3, 4, 2);
        ChangeJar jar4 = new ChangeJar(2, 5, 4, 2);

        assertTrue(jar2.compareTo(jar1) > 0);
        assertTrue(jar3.compareTo(jar1) < 0);
        assertTrue(jar1.compareTo(jar4) == 0);
}

//**Testing compareTo(jar1, jar2)**//

    @Test
    public void testCompareTo2() {
        ChangeJar jar1 = new ChangeJar(5, 2, 8, 1);
        ChangeJar jar2 = new ChangeJar(2, 2, 2, 2);
        ChangeJar jar3 = new ChangeJar(2, 2, 2, 2);

        assertEquals(1, ChangeJar.compareTo(jar1, jar2));
        assertEquals(-1, ChangeJar.compareTo(jar2, jar1));
        assertEquals(0, ChangeJar.compareTo(jar2, jar3));

    }
//**Testing when jar2 = null**//
    @Test(expected = IllegalArgumentException.class)
    public void testCompareTo3(){
        ChangeJar jar1 = new ChangeJar(5, 2, 8, 1);
        ChangeJar jar2 = new ChangeJar(-1,-2,2,3);

        ChangeJar.compareTo(jar1, jar2);
    }


//---------------------------------------------------------------------------------------------


//---------------------------------------------------------------------------------------------
    //**testing valid takeOut with wide range of quarters, dimes, nickels, pennies**//
    @Test
    public void testTakeOut1() {
        ChangeJar jar = new ChangeJar(3, 3, 2, 2);
        jar.takeOut(1, 1, 1, 1);
        assertEquals(2, jar.getQuarters());
        assertEquals(2, jar.getDimes());
        assertEquals(1, jar.getNickels());
        assertEquals(1, jar.getPennies());
    }

    //**testing valid takeOut with wide range of amounts**//
    @Test
    public void testTakeOut2() {
        ChangeJar jar1 = new ChangeJar(5, 3, 4, 3);
        ChangeJar jar2 = jar1.takeOut(1.22);

        assertEquals(1, jar1.getQuarters());
        assertEquals(1, jar1.getDimes());
        assertEquals(4, jar1.getNickels());
        assertEquals(1, jar1.getPennies());

        assertEquals(4, jar2.getQuarters());
        assertEquals(2, jar2.getDimes());
        assertEquals(0, jar2.getNickels());
        assertEquals(2, jar2.getPennies());
    }

    @Test
    public void testTakeOut120() {
        ChangeJar jar1 = new ChangeJar(3, 2, 4, 8);
        ChangeJar jar2 = jar1.takeOut(1.20);

        assertEquals(0, jar1.getQuarters());
        assertEquals(0, jar1.getDimes());
        assertEquals(0, jar1.getNickels());
        assertEquals(3, jar1.getPennies());

        assertEquals(3, jar2.getQuarters());
        assertEquals(2, jar2.getDimes());
        assertEquals(4, jar2.getNickels());
        assertEquals(5, jar2.getPennies());
    }

    @Test
    public void testTakeOut80(){
        ChangeJar jar1 = new ChangeJar(4, 3, 0, 3);
        ChangeJar jar2 = jar1.takeOut(.80);

        assertEquals(2, jar1.getQuarters());
        assertEquals(0, jar1.getDimes());
        assertEquals(0, jar1.getNickels());
        assertEquals(3, jar1.getPennies());

        assertEquals(2, jar2.getQuarters());
        assertEquals(3, jar2.getDimes());
        assertEquals(0, jar2.getNickels());
        assertEquals(0, jar2.getPennies());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTakeOut3(){
        ChangeJar jar = new ChangeJar(3,2,1,0);
        jar.takeOut(4,1,1,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTakeOut4(){
        ChangeJar jar = new ChangeJar(3,2,1,0);
        jar.takeOut(2,3,1,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTakeOut5(){
        ChangeJar jar = new ChangeJar(3,2,1,0);
        jar.takeOut(2,1,5,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTakeOut6(){
        ChangeJar jar = new ChangeJar(3,2,1,0);
        jar.takeOut(2,1,1,12);
    }

    //**testing taking out MORE QUARTERS than what is available in the changeJar**//
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutQuarters() {
        ChangeJar jar = new ChangeJar(3, 3, 2, 2);
        jar.takeOut(4, 2, 1, 1);
    }

    //**testing taking out MORE DIMES than what is available in the changeJar**//
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutDimes() {
        ChangeJar jar = new ChangeJar(3, 3, 2, 2);
        jar.takeOut(1, 5, 1, 1);
    }


    //**testing taking out MORE NICKLES than what is available in the changeJar**//
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutNickles() {
        ChangeJar jar = new ChangeJar(3, 3, 2, 2);
        jar.takeOut(1, 2, 6, 1);
    }
    //**testing taking out MORE PENNIES than what is available in the changeJar**//
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutPennies() {
        ChangeJar jar = new ChangeJar(3, 3, 2, 2);
        jar.takeOut(1, 2, 1, 5);
    }
    //**testing NEGATIVE number for NICKELS in takeOut**//
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutNegNickels() {
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(1, 1, -1, 1);
    }

    //**testing NEGATIVE number for DIMES in takeOut**//
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutNegDimes() {
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        jar1.takeOut(1, -1, 1, 1);
    }

    //**testing for NEGATIVE number for PENNIES in takeOut**//
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutNegPennies() {
        ChangeJar jar1 = new ChangeJar(4, 5, 5, 9);
        jar1.takeOut(1, 1, 1, -3);
    }

    //**testing for a NEGATIVE number of QUARTERS in takeOut**//
    @Test(expected = IllegalArgumentException.class)
    public void testTakeOutNegQuarters() {
        ChangeJar jar1 = new ChangeJar(4, 4, 4, 4);
        jar1.takeOut(-3, 1, 1, 1);
    }

//----------------------------------------------------------------------------------


    //**testing valid takeOut(ChangeJar OTHER)**//
    @Test
    public void testTakeOutOther() {
        ChangeJar jar = new ChangeJar(3, 3, 3, 3);
        ChangeJar other = new ChangeJar(2, 2, 2, 2);
        jar.takeOut(other);
        assertEquals(1, jar.getQuarters());
        assertEquals(1, jar.getDimes());
        assertEquals(1, jar.getNickels());
        assertEquals(1, jar.getPennies());
    }
    //**testing takeOut(OTHER) with a string amount**//
    @Test
    public void testTakeOutOther1() {
        ChangeJar jar = new ChangeJar(5, 3, 2, 2);
        ChangeJar other = new ChangeJar (1.22);
        jar.takeOut(other);
        assertEquals(1, jar.getQuarters());
        assertEquals(1, jar.getDimes());
        assertEquals(2, jar.getNickels());
        assertEquals(0, jar.getPennies());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTakeOutOther2(){
        ChangeJar jar = new ChangeJar(5, 3, 2, 2);
        ChangeJar other = new ChangeJar (6.22);
        jar.takeOut(other);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTakeOutOther3(){
        ChangeJar jar = new ChangeJar(5, 3, 2, 2);
        ChangeJar other = new ChangeJar (-1.22);
        jar.takeOut(other);
    }
    //**testing valid takeOut(ChangeJar OTHER) with NEGATIVE DIMES**//
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutOtherNegDimes() {
        ChangeJar jar = new ChangeJar(3, 3, 2, 2);
        ChangeJar other = new ChangeJar(2, -2, 1, 1);
        jar.takeOut(other);

    }

    //**testing valid takeOut(ChangeJar OTHER) with NEGATIVE NICKLES**//
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutOtherNegNickels() {
        ChangeJar jar = new ChangeJar(3, 3, 2, 2);
        ChangeJar other = new ChangeJar(2, 2, -1, 1);
        jar.takeOut(other);

    }

    //**testing valid takeOut(ChangeJar OTHER) with NEGATIVE PENNIES**//
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutOtherNegPennies() {
        ChangeJar jar = new ChangeJar(3, 3, 2, 2);
        ChangeJar other = new ChangeJar(2, 2, 1, -1);
        jar.takeOut(other);

    }
//----------------------------------------------------------------------------------------
    //**Testing increments/decrements
    @Test
        public void testDec() {
        ChangeJar jar = new ChangeJar(0, 0, 0, 1);
        jar.dec();

        assertEquals(0, jar.getPennies());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegDec() {
        ChangeJar jar = new ChangeJar(0, 0, 0, 0);
        jar.dec();

    }

//----------------------------------------------------------------------------------------
//**Testing add methods

    //**add(int quarters, int dimes, int nickels, int pennies)**//
    @Test
    public void testAdd() {
        ChangeJar jar = new ChangeJar();
        jar.add(2,3,4,5);
        assertEquals(2, jar.getQuarters());
        assertEquals(3, jar.getDimes());
        assertEquals(4, jar.getNickels());
        assertEquals(5, jar.getPennies());
    }

    //**add(ChangeJarOther

//---------------------------------------------------------------------------------------

    @Test
    public void testInc() {
        ChangeJar jar = new ChangeJar(0, 0, 0, 1);
        jar.inc();

        assertEquals(2, jar.getPennies());

    }



//----------------------------------------------------------------------------------------
    //Testing toString()
    @Test
    public void toStringTest(){
        ChangeJar jar = new ChangeJar(1,1,1,1);
        String expected =
                "1 Quarter" +  "\n"
                + "1 Dime" +  "\n"
                + "1 Nickel" + "\n"
                + "1 Penny" + "\n";
        Assert.assertEquals(expected, jar.toString());


    }
    @Test
    public void toStringTest2(){
        ChangeJar jar = new ChangeJar(2,2,2,2);
        String expected =
                "2 Quarters" +  "\n"
                        + "2 Dimes" +  "\n"
                        + "2 Nickels" + "\n"
                        + "2 Pennies" + "\n";
        Assert.assertEquals(expected, jar.toString());

    }






    //**load and save combined**//
    @Test
    public void testLoadSave() {
        ChangeJar jar1 = new ChangeJar(6, 5, 4, 2);
        ChangeJar jar2 = new ChangeJar(6, 5, 4, 2);

        jar1.save("file1");
        jar1 = new ChangeJar();  // resets to zero

        jar1.load("file1");
        assertTrue(jar1.equals(jar2));
    }


    //------------------------------------------------------------------------------------
//** Josh's Tests**//

    //**testing valid takeOut(ChangeJar OTHER) with NEGATIVE QUARTERS**//
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutOtherNegQuarters() {
        ChangeJar jar = new ChangeJar(3, 3, 2, 2);
        ChangeJar other = new ChangeJar(-2, 2, 1, 1);
        jar.takeOut(other);
    }

    //**taking out more OTHER QUARTERS than what is available in the ChangeJar**//
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutOtherQuarters() {
        ChangeJar jar = new ChangeJar(3, 3, 2, 2);
        ChangeJar other = new ChangeJar(4, 2, 1, 1);
        jar.takeOut(other);
    }

    //**taking out more OTHER DIMES than what is available in the ChangeJar**//
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutOtherDimes() {
        ChangeJar jar = new ChangeJar(3, 3, 2, 2);
        ChangeJar other = new ChangeJar(2, 4, 1, 1);
        jar.takeOut(other);
    }

    //**taking out more OTHER NICKELS than what is available in the ChangeJar**//
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutOtherNickels() {
        ChangeJar jar = new ChangeJar(3, 3, 2, 2);
        ChangeJar other = new ChangeJar(2, 2, 3, 1);
        jar.takeOut(other);
    }

    //**taking out more OTHER PENNIES than what is available in the ChangeJar**//
    @Test
            (expected = IllegalArgumentException.class)
    public void testTakeOutOtherPennies() {
        ChangeJar jar = new ChangeJar(3, 3, 2, 2);
        ChangeJar other = new ChangeJar(2, 2, 1, 4);
        jar.takeOut(other);

    }


//----------------------------------------------------------------------------------------


//---------------------------------------------------------------------------------------------


//**Testing compareTo(jar1, jar2)**//

    //**Throwing an error when JAR1 is NULL***//

    @Test
            (expected = IllegalArgumentException.class)
    public void testCompareToNull() {

        ChangeJar jar1 = null;
        ChangeJar jar3 = new ChangeJar(2, 2, 2, 4);
        ChangeJar jar2 = new ChangeJar(2, 2, 2, 4);
        ChangeJar.compareTo(jar1, jar2);
        ChangeJar.compareTo(jar2, jar1);
        ChangeJar.compareTo(jar2, jar3);
    }
    //Throwing an error when JAR2 is NULL**//
    @Test
            (expected = IllegalArgumentException.class)
    public void testCompareToNull2() {
        ChangeJar jar1 = new ChangeJar(2, 2, 2, 2);
        ChangeJar jar2 = null;
        ChangeJar jar3 = new ChangeJar(2, 2, 2, 4);
        ChangeJar.compareTo(jar1, jar2);
        ChangeJar.compareTo(jar2, jar1);
        ChangeJar.compareTo(jar2, jar3);
    }
    @Test
            (expected = IllegalArgumentException.class)
    public void testCompareToOtherNull() {
        ChangeJar other = null;
        ChangeJar jar1 = new ChangeJar(2,3,4,5);
        jar1.compareTo(other);
        jar1.compareTo(other);
    }


    //------------------------------------------------------------------------------------
    //DEC when there is no pennies left in the change jar
    @Test
            (expected = IllegalArgumentException.class)
    public void testDec1() {
        ChangeJar jar = new ChangeJar(5, 3, 2, 0);
        jar.dec();

    }
    //------------------------------------------------------------------------------------------------------------------
    //Adding QUARTERS to the change jar
    @Test
    public void testAddQ() {
        ChangeJar jar = new ChangeJar(5, 3, 2, 2);
        jar.add(2,0,0,0);
        assertEquals(7, jar.getQuarters());
        assertEquals(3, jar.getDimes());
        assertEquals(2, jar.getNickels());
        assertEquals(2, jar.getPennies());
    }

    //Adding DIMES to the change jar
    @Test
    public void testAddD() {
        ChangeJar jar = new ChangeJar(5, 3, 2, 2);
        jar.add(0,3,0,0);
        assertEquals(5, jar.getQuarters());
        assertEquals(6, jar.getDimes());
        assertEquals(2, jar.getNickels());
        assertEquals(2, jar.getPennies());
    }
    //Adding NICKLES to the change jar
    @Test
    public void testAddN() {
        ChangeJar jar = new ChangeJar(5, 3, 2, 2);
        jar.add(0,0,3,0);
        assertEquals(5, jar.getQuarters());
        assertEquals(3, jar.getDimes());
        assertEquals(5, jar.getNickels());
        assertEquals(2, jar.getPennies());
    }
    //Adding PENNIES to the change jar
    @Test
    public void testAddP() {
        ChangeJar jar = new ChangeJar(5, 3, 2, 2);
        jar.add(0,0,0,10);
        assertEquals(5, jar.getQuarters());
        assertEquals(3, jar.getDimes());
        assertEquals(2, jar.getNickels());
        assertEquals(12, jar.getPennies());
    }
    //-----------------------------------------------------------------------------------------------------------------
    //Adding QUARTERS, DIMES, NICKELS, PENNIES to the OTHER change jar
    @Test
    public void testAddOther() {
        ChangeJar jar1 = new ChangeJar (1,2,3,4);
        ChangeJar other = new ChangeJar(5, 3, 2, 2);
        jar1.add(other);
        assertEquals(6, jar1.getQuarters());
        assertEquals(5, jar1.getDimes());
        assertEquals(5, jar1.getNickels());
        assertEquals(6, jar1.getPennies());
    }

    //Adding QUARTERS to the OTHER change jar
    @Test
    public void testAddOtherQ() {
        ChangeJar jar1 = new ChangeJar (1,2,3,4);
        ChangeJar other = new ChangeJar(8, 0, 0, 0);
        jar1.add(other);
        assertEquals(9, jar1.getQuarters());
        assertEquals(2, jar1.getDimes());
        assertEquals(3, jar1.getNickels());
        assertEquals(4, jar1.getPennies());
    }
    //Adding NICKELS to the OTHER change jar
    @Test
    public void testAddOtherD() {
        ChangeJar jar1 = new ChangeJar (1,2,3,4);
        ChangeJar other = new ChangeJar(0, 6, 0, 0);
        jar1.add(other);
        assertEquals(1, jar1.getQuarters());
        assertEquals(8, jar1.getDimes());
        assertEquals(3, jar1.getNickels());
        assertEquals(4, jar1.getPennies());
    }
    //Adding DIMES to the OTHER change jar
    @Test
    public void testAddOtherN() {
        ChangeJar jar1 = new ChangeJar (1,2,3,4);
        ChangeJar other = new ChangeJar(0, 0, 8, 0);
        jar1.add(other);
        assertEquals(1, jar1.getQuarters());
        assertEquals(2, jar1.getDimes());
        assertEquals(11, jar1.getNickels());
        assertEquals(4, jar1.getPennies());
    }
    //Adding PENNIES to the OTHER change jar
    @Test
    public void testAddOtherP() {
        ChangeJar jar1 = new ChangeJar (1,2,3,4);
        ChangeJar other = new ChangeJar(0, 0, 0, 34);
        jar1.add(other);
        assertEquals(1, jar1.getQuarters());
        assertEquals(2, jar1.getDimes());
        assertEquals(3, jar1.getNickels());
        assertEquals(38, jar1.getPennies());
    }
}

//--------------------------------------------------------------------------------------
//@Test
//public void mutate() {













