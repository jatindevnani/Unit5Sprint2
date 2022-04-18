package com.Question_2;

public class Main {
    public static void main(String[] args) {
        //Liskov's substitution principle

        /*It is one of the SOLID Principles published by Robert Martin
        * It states that
        *               -If class Child is subtype of class Parent. Then
        *                Child must be able to replace Parent without breaking
        *                the functionality of the program*/
        /*Below are two snippets of code where I have designed a system in violation of Liskov's substitution principle
        * and other follows the LSP*/

        //Works properly for the keypad phones
        WithoutLS_Nokia_2690 nokiaPhone = new WithoutLS_Nokia_2690();
        nokiaPhone.makeCall();
        nokiaPhone.pressKey("NUMPAD 2");

        //Functionality breaks for the touchscreen phones
        WithoutLS_SamsungGalaxy11 samsungGalaxy11 = new WithoutLS_SamsungGalaxy11();
        //samsungGalaxy11.pressKey("NUMPAD 1"); //Throws an exception

        //Following proper interface design
        With_LS_TouchScreenPhone samsungGalaxy = new With_LS_TouchScreenPhone();
        samsungGalaxy.playGames();
        samsungGalaxy.makeCall();
    }
}

    //Code without following the Liskov substitution
    //We have a phone class which can make call and it can have keys
    //Which can be pressed
    interface WithoutLS_Phone {
        void makeCall();
        void pressKey(String key);
    }

    //We have a good old nokia phone (Keypad)
    //We can make calls and play games on our small keypad!
    class WithoutLS_Nokia_2690 implements WithoutLS_Phone {

        @Override
        public void makeCall() {
            System.out.println("Make a call");
        }

        @Override
        public void pressKey(String key) {
            System.out.println(key + " was pressed");
        }
    }

    //Now we want to have a brand new samsung galaxy phone
    //It is a touchscreen phone
    //But our phone class cannot extend to provide support
    //to our smartphone since it doesn't have keys but a touchscreen
    //Therefore it will throw an exception

    class WithoutLS_SamsungGalaxy11 implements WithoutLS_Phone {

        @Override
        public void makeCall() {
            System.out.println("Make a call");
        }

        @Override
        public void pressKey(String key) {
            throw new ImpossiblePhoneSpecifications("Wait what! I do not have keys brother!!!");
        }
    }

    //This is blatant violation of the Liskov's substitution principle
    //Because we cannot use Phone's reference for our samsung smartphone without keypad
    //without breaking the functionality of our program

    //However, this can be fixed
    //By doing something like this -

    abstract class With_LS_Phone {
        public void makeCall() {
            System.out.println("Dialing..brr brr...brr brr...");
        }
    }

    //We have now designed our abstract class Phone in such a way
    //that we can reference all kinds of phones with the superclass reference
    //without breaking the functionality
    //The only method our superclass provides is the makecall method
    //because we know that every phone can make a call
    // we have not included the touchscreen or keypad functionality beforehand
    //because each phone might be different

    class With_LS_TouchScreenPhone extends With_LS_Phone {
        public void useTouchScreen() {
            System.out.println("Wow this is like magic!! A touchscreen");
        }

        public void playGames() {
            System.out.println("I am playing touchscreen games on my Touchscreen Phone");
        }
    }

    class With_LS_Keypad_Phone extends With_LS_Phone {
        public void pressKey(String key) {
            System.out.println( key + " was pressed." );
        }

        public void dropPhone () {
            System.out.println("I am so strong that even if I fall dont break. I am good old " + getClass().getName() );
        }
    }




