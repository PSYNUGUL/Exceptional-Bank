import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ExceptionalBank
// Files: ExceptionalBank.java , ExceptionalBankTester.java, Coin.java
// Course: CS300 Spring 2020
//
// Author: Yeon Jae Cho
// Email: ycho226@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understood the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources:
// https://www.geeksforgeeks.org/check-if-a-string-contains-only-alphabets-in-java-using-regex/
// - helped for creating method to throw Exception when the coinNumber is not in Integer String
// - Example: "one" instead of "1"
//
///////////////////////////////////////////////////////////////////////////////

public class ExceptionalBankTester {
  /**
   * This method checks if ExceptionalBank constructor works if there is valid input
   * 
   * @return true when exceptionalBankConstructor() method is working as expected
   */
  public static boolean testGoodExceptionalBankConstructor() {
    try {
      ExceptionalBank bank = new ExceptionalBank(20);
      if (bank.capacity() != 20) {
        return false;
      }
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    return true;
  }

  /**
   * This method checks whether the ExceptionalBank constructor throws an IllegalArgumentException
   * with appropriate error message, when it is passed a zero or a negative capacity. This test must
   * fail if another kind of exception is thrown for such test scenario.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   * 
   */
  public static boolean testExceptionalBankConstructor() {
    try {
      // create an exceptional bank with a negative capacity
      ExceptionalBank bank = new ExceptionalBank(-10);
      System.out
          .println("Problem detected. The constructor call of the ExceptionalBank class did not "
              + "throw an IllegalArgumentException when it is passed a negative capacity.");
      return false; // return false if no exception has been thrown
    } catch (IllegalArgumentException e1) {
      // check that the caught IllegalArgumentException includes
      // an appropriate error message
      if (e1.getMessage() == null // your test method should not throw
          // a NullPointerException,but must return false if e1.getMessage is null
          || !e1.getMessage().toLowerCase().contains("must be a non-zero positive integer")) {
        System.out
            .println("Problem detected. The IllegalArgumentException thrown by the constructor "
                + "call of the ExceptionalBank class when it is passed a negative capacity "
                + "does not contain an appropriate error message.");
        return false;
      }
    }

    catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "constructor of the ExceptionBank class with a negative argument. "
              + "An IllegalArgumentException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    return true; // test passed
  }

  /**
   * This test checks whether addCoin() method throws IllegalArgumentException with appropriate
   * message, when negative capacity is passed. This test must fail if there is another type of
   * Exception thrown.
   * 
   * @return true when test IllegalArgumentException is thrown as expected
   */
  public static boolean testAddCoin() {
    try {
      // create an exceptional bank with a negative capacity
      ExceptionalBank bank = new ExceptionalBank();
      bank.addCoin(null);
      System.out.println("Problem detected. The addCoin method did not "
          + "throw an IllegalArgumentException when it is passed a null reference to bank.");
      return false; // return false if no exception has been thrown
    } catch (IllegalArgumentException e1) {
      // check that the caught IllegalArgumentException includes
      // an appropriate error message
      if (e1.getMessage() == null // your test method should not throw
          // a NullPointerException,but must return false if e1.getMessage is null
          || !e1.getMessage().toLowerCase().contains("cannot add a null reference to this bank")) {
        System.out.println("Problem detected. The IllegalArgumentException thrown by the method "
            + "call of the addCoin when it is passed a null reference "
            + "does not contain an appropriate error message.");
        return false;
      }
    }

    catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "method of the addCoin with a null reference. "
              + "An IllegalArgumentException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace(); // to help locate the error within the bad ExceptionalBank
      // constructor code.
      return false;
    }
    return true; // test passed
  }

  /**
   * This test checks whether removeCoin() method throws NoSuchElementException in case of empty
   * bank. This test must fail if other type of exception is thrown.
   * 
   * @return true when NoSuchException is thrown as expected
   */
  public static boolean testRemoveCoinEmptyBank() {
    try {
      ExceptionalBank bank = new ExceptionalBank();
      bank.removeCoin();
      System.out.println("Problem detected. The removeCoin method did not "
          + "throw an NoSuchElementException when it tried to remove empty bank.");
      return false; // return false if no exception has been thrown
    } catch (NoSuchElementException e1) {
      // check that the caught NoSuchElementException includes
      // an appropriate error message
      if (e1.getMessage() == null || !e1.getMessage().contains("This bank is empty")) {
        System.out.println("Problem detected. The NoSuchElementException thrown by the method "
            + "call of the removeCoin when it tried to remove empty bank "
            + "does not contain an appropriate error message.");
        return false;
      }
    }

    catch (Exception e2) {
      // an exception other than NoSuchElementException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "method of the addCoin with a null reference. "
              + "The NoSuchElementException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace();

      return false;
    }
    return true;
  }

  /**
   * This test checks whether addCoins() method throws IllegalArgumentException when the null
   * reference is passed. This test must fail when other type of exception is thrown.
   * 
   * @return true when IllegalArgumentException is thrown as expected
   */
  public static boolean testAddCoinsIllegalArgument() {
    try {
      ExceptionalBank e1 = new ExceptionalBank();
      e1.addCoins(null);
      System.out.println("Problem detected. The addCoins method did not "
          + "throw an IllegalArgumentException when it is passed a null reference to bank.");
      return false;
    } catch (IllegalArgumentException e1) {
      // check that the caught IllegalArgumentException includes
      // an appropriate error message
      if (e1.getMessage() == null
          || !e1.getMessage().toLowerCase().contains("does not accept a null reference as input")) {
        System.out.println("Problem detected. The IllegalArgumentException thrown by the method "
            + "call of the addCoins when it is passed a null reference "
            + "does not contain an appropriate error message.");
        return false;
      }
    }

    catch (Exception e2) {
      // an exception other than IllegalArgumentException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "method of the addCoin with a null reference. "
              + "An IllegalArgumentException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * This test checks whether addCoins() method throws DataFormatException when negative number of
   * coinNumber, invalid format of input, and coinNumber represented in alphabet is passed. This
   * test must fail if other type of exception is thrown.
   * 
   * @return true when DataFormatException is thrown as expected
   */
  public static boolean testAddCoinsInvalidDataFormat() {
    try {
      // negative number of coinNumber
      ExceptionalBank bank1 = new ExceptionalBank();
      bank1.addCoins("NICKEL:-3");
      System.out.println("Problem detected. The call of the addCoins method did not "
          + "throw an DataFormatException when coinNumber is negative");
      return false;
    } catch (DataFormatException e4) {
      if (e4.getMessage() == null || !e4.getMessage().contains("The format of the command line")) {
        System.out.println("Problem detected. The DataFormatException thrown by the"
            + " call of the addCoins method when it has negative form of coinNumber "
            + "does not contain an appropriate error message.");
        return false;
      }
    }

    try {
      // invalid format of input String
      ExceptionalBank bank2 = new ExceptionalBank();
      bank2.addCoins("10 QUARTERS");
      System.out.println("Problem detected. The call of the addCoins method did not "
          + "throw an DataFormatException when input is not in right format");
      return false;
    } catch (DataFormatException e5) {
      if (e5.getMessage() == null || !e5.getMessage().contains("The format of the command line")) {
        System.out.println("Problem detected. The DataFormatException thrown by the"
            + " call of the addCoins method when it has invalid format "
            + "does not contain an appropriate error message.");
        return false;
      }
    }

    try {
      // coinNumber not representable as integer value equal to its definition
      ExceptionalBank bank3 = new ExceptionalBank();
      bank3.addCoins("Penny:one");
      System.out.println("Problem detected. The call of the addCoins method did not "
          + "throw an DataFormatException when coinAmount is not in right format");
      return false;
    } catch (DataFormatException e6) {
      if (e6.getMessage() == null // your test method should not throw
          // a NullPointerException,but must return false if e1.getMessage is null
          || !e6.getMessage().contains("The format of the command line")) {
        System.out.println("Problem detected. The DataFormatException thrown by the"
            + " call of the addCoins method when it has invalid format "
            + "does not contain an appropriate error message.");
        return false;
      }
    }

    catch (Exception e2) {
      // an exception other than DataFormatException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "addCoins method with a negative coinNumber. "
              + "An DataFormatException was expected to be thrown. " + "But, it was NOT the case.");
      e2.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * This test checks whether addCoins() method throws NoSuchElementException when the CoinName is
   * not equal to Coin enum values. This test must fail if other type of exception is thrown.
   * 
   * @return true when NoSuchElementException is thrown as expected
   */
  public static boolean testAddCoinsNoSuchElement() {
    try {
      ExceptionalBank e1 = new ExceptionalBank();
      e1.addCoins("Gold:5");
      System.out.println("Problem detected. The addCoins method did not "
          + "throw an NoSuchElementException when it does not have equal Coin enum value as coinName.");
      return false;
    } catch (NoSuchElementException e1) {
      // check that the caught NoSuchElementException includes
      // an appropriate error message
      if (e1.getMessage() == null
          || !e1.getMessage().contains("The coin name provided in the command line ")) {
        System.out.println("Problem detected. The NoSuchElementException thrown by the method "
            + "call of the addCoins when it does not have proper Coin enum String as coinName "
            + "does not contain an appropriate error message.");
        return false;
      }
    }

    catch (Exception e2) {
      // an exception other than NoSuchElementException has been thrown
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "method of the addCoins with coinName different to Coin enum values. "
              + "An NoSuchElementException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * This test checks whether addCoins() method works as expected with valid input
   * 
   * @return true when this method works as expected
   */
  public static boolean testAddCoinsValidFormat() {
    ExceptionalBank bank = new ExceptionalBank();
    try {
      bank.addCoins("PENNY:5");
    } catch (DataFormatException e) {

      e.printStackTrace();
    }
    String answer = "(PENNY, 1) (PENNY, 1) (PENNY, 1) (PENNY, 1) (PENNY, 1)";
    if (!bank.getCoins().equals(answer)) {
      return false;
    }
    return true;
  }



  /**
   * This test checks whether loadCoins() method works as expected with valid inputs
   * 
   * @return true when this test works as expected
   */
  public static boolean testLoadCoinsFileFound() {
    ExceptionalBank bank = new ExceptionalBank();
    File file = new File("C:\\Users\\yeonj\\Desktop\\새 폴더\\P04 Exceptional Bank\\sample3.txt");
    try {
      bank.loadCoins​(file);
    } catch (FileNotFoundException e) {

      e.printStackTrace();
    }
    String answer =
        "(PENNY, 1) (PENNY, 1) (PENNY, 1) (PENNY, 1) (PENNY, 1) (PENNY, 1) (DIME, 10) (DIME, 10) (DIME, 10) (NICKEL, 5) (NICKEL, 5) (NICKEL, 5) (NICKEL, 5) (NICKEL, 5)";
    if (!bank.getCoins().equals(answer)) {
      return false;
    }
    return true;
  }

  /**
   * This test checks whether FileNotFoundException is thrown when the stated file does not exist.
   * This test must fail if other type of exception is thrown.
   * 
   * @return true when FileNotFoundException is thrown as expected
   */
  public static boolean testLoadCoinsFileNotFound() {
    try {
      ExceptionalBank bank = new ExceptionalBank();
      File file = new File("sample234.txt");
      bank.loadCoins​(file);
      System.out.println("Problem detected. The loadCoins method did not "
          + "throw an FileNotFoundException when it is passed a non-existing file in stated path.");
      return false;
    } catch (FileNotFoundException e0) {
      if (e0.getMessage() == null | !e0.getMessage().contains("The file located in")) {
        System.out.println("Problem detected. The FileNotFoundException thrown by the method "
            + "call of the loadCoins when it is passed non-existing file in stated path "
            + "does not output an appropriate error message.");
        return false;
      }
    }

    catch (Exception e2) {
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "method of the loadCoins with invalid file. "
              + "An FileNotFoundException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * This test checks whether loadCoins() method throws NullPointerException when null reference is
   * passed. This test must fail if other type of exception is thrown.
   * 
   * @return true when test throws NullPointerException as expected
   */
  public static boolean testLoadCoinsNullReference() {
    try {
      ExceptionalBank bank = new ExceptionalBank();
      File file = new File("");
      bank.loadCoins​(file);
      System.out.println("Problem detected. The loadCoins method did not "
          + "throw an NullPointerException when it is passed a null reference");
      return false;
    } catch (NullPointerException e1) {
      if (e1.getMessage() == null | !e1.getMessage().contains("the file must have a name")) {
        System.out.println("Problem detected. The NullPointerException thrown by the method "
            + "call of the loadCoins when it is passed null reference "
            + "does not output an appropriate error message.");
        return false;
      }
    }

    catch (Exception e2) {
      System.out
          .println("Problem detected. An unexpected exception has been thrown when calling the "
              + "method of the loadCoins with null reference. "
              + "An NullPointerException was expected to be thrown. "
              + "But, it was NOT the case.");
      e2.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * This test checks whether saveBankSummary() works as expected
   * 
   * @return true when test works as expected
   */
  public static boolean testSaveBankSummary() {
    try {
      ExceptionalBank bank = new ExceptionalBank();
      File file = new File("sample6.txt");
      try {
        bank.addCoins("PENNY:5");
      } catch (DataFormatException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      try {
        bank.addCoins("DIME: 2");
      } catch (DataFormatException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      try {
        bank.addCoins("penny: 2");
      } catch (DataFormatException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      bank.saveBankSummary​(file);
      try {
        bank.loadCoins​(file);
      } catch (FileNotFoundException | NullPointerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      String answer = "PENNY:14\n" + "DIME:4";
      if (!bank.getSummary().equals(answer)) {
        return false;
      }
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }
    return true;
  }


  public static void main(String[] args) {
    System.out.println("Testing exceptionalBankConstructor() method without errors: "
        + testGoodExceptionalBankConstructor());
    System.out.println("Testing exceptionalBankConstructor() method w/ negative capacity: "
        + testExceptionalBankConstructor());
    System.out.println("Testing addCoin() method: " + testAddCoin());
    System.out.println("Testing removeCoin() method w/ empty bank: " + testRemoveCoinEmptyBank());
    System.out.println(
        "Testing addCoins() method w/ invalid data format: " + testAddCoinsInvalidDataFormat());
    System.out
        .println("Testing addCoins() method w/ valid data format: " + testAddCoinsValidFormat());
    System.out.println(
        "Testing addCoins() method w/ null reference as input: " + testAddCoinsIllegalArgument());
    System.out.println(
        "Testing addCoins() method w/ improper Coin enum name: " + testAddCoinsNoSuchElement());
    System.out.println(
        "Testing loadCoins() method w/ valid file and no errors: " + testLoadCoinsFileFound());
    System.out
        .println("Testing loadCoins() method w/ invalid file: " + testLoadCoinsFileNotFound());
    System.out
        .println("Testing loadCoins() method w/ null reference: " + testLoadCoinsNullReference());
    System.out.println("Testing saveBankSummary() method: " + testSaveBankSummary());
  }
}
