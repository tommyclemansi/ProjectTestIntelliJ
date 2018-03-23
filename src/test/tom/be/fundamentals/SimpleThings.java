package test.tom.be.fundamentals;

import java.util.ArrayList;
/**
 * this Class just contains just some simple things to remember
 */


public class SimpleThings {
  static short a,b=1,c=2;
  int myArr [] = new int [3]; // arrays, fixed size, prim + Obj types
  static ArrayList myList; // arraylist only Object types

  public static void main(String... args)
  {
  sum();
  myString();
  testFile();
  }

  public static void testFile()
  {
    AbstractFile tom = new MyFile();
    Savable mysavabletom = tom;
    mysavabletom.doSave();
  }

  public static void sum()
  {   // with arithmic short is promoted to int , hence the result will require typecasting..
      // with arithmic, types will generate int or long by default
      a= (short) (b+c);
  }

  public static void myString(){
    /*
     using new operator creates actually 2 strings.. better to use direct assignment..
     if manipulated, use StringBuilder (mutable)
     */
    String myString = new String("testrrr");
    myString="test";
  }

  public static void testSwitch( int mynum)
  {
    /*switch is for int, short, byte, char , String
     */
    switch (mynum)
    {
      case 1:
      case 3: System.out.println("breaked at 3");
              break;
      default:  System.out.println("sorry no value found");
                break;
    }

  }

  public void workWithArray()
  {
    myList = new ArrayList();
  }

}
