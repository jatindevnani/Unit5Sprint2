package com.Question_3;

public class Main {
    public static void main(String[] args) {
        //After going through the given code some problems are very apparent and must
        //be immediately fixed

        //The following SOLID principles and other general clean code ideologies were violated

        //_1_ Interface Segregation ---> The given code very blatantly violates the principles laid out
        //by the Interface Segregation principle.

        //According to the Interface Segregation principle -->
                    //The larger interfaces must be broken down into smaller interfaces. This makes sure
                    //that the implementing classes only have to be concerned about providing the behavior
                    //of the methods that are of interest to them.

        //In the given case InMemoryRealmManager doesn't need the write method.

        //_2_ Single Responsibility Principle (High Cohesion Needed) The given interface is also breaking the
        /*Single responsibility principle in addition to the Interface segregation principle.

        //According to the Single Responsibility Principle -->
                    //All the modules should have only one single responsibility and it should only have
                    //One reason to change.

        * Currently, we're in violation of this principle.
        * This is apparent by the fact that the data manager is trying to achieve two things inside a single
        * Block of code.

        We currently have low Cohesion because of this. Our code isn't just concerned with one single thing.
        To achieve high cohesion we'll break the interface into relevant interfaces*/
    }
}

//Solution --> Proper and clean code

//We have segregated the previously created interface into two interfaces with well-defined responsibility
interface DataManager {

}

interface DataReader{
    void read();
}

interface DataWriter{
    void write();
}

//Our DiskRealmManager needs to read and write the data
class DiskRealmManager implements DataReader, DataWriter {

    @Override
    public void read() {
        System.out.println("Reading DiskRealmManager");
    }

    @Override
    public void write() {
        System.out.println("Saving Into Realm");
    }
}

//Our DiskCoreDataManager can also read and write the data
class DiskCoreDataManager implements DataWriter, DataReader {

    @Override
    public void read() {
        System.out.println("Reading DiskCoreDataManager");
    }

    @Override
    public void write() {
        System.out.println("Saving Into Realm");
    }
}

//Here our InMemoryRealmManager class cannot write to disk
//Previously this was leading to issues.
//Now since we have followed the Interface Segregation principle it
//is error free because we do not have to provide behavior to the functionality that we
//know that our MemoryRealmManager is incapable of doing
//So we only implement the Data reader interface
class InMemoryRealmManager implements DataReader {

    @Override
    public void read() {
        System.out.println("Reading " + getClass().getName());
    }
}


