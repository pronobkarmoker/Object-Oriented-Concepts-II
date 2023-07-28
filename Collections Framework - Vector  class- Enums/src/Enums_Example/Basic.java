package Enums_Example;

public class Basic {
    enum week implements Hello{
        saturday, sunday,monday, tuesday, wednesday, thursday, Friday;
        //these are enum constant
        // public static and final
        //since it final you can not create child enums
        //type is week


        week() {
            System.out.println("Constructor called for " + this);
        }

        @Override
        public void hi() {
            System.out.println("HIW ! Welcome");
        }

        // this is not public or protected, only private or default
        // we don't want to create new object
        // this is not the enum concepts

        // internally: public static final week monday = new week();
    }

    public static void main(String[] args) {
        week w ;
        w = week.sunday;

        System.out.println(w);

        System.out.println(w.ordinal()); // position of sunday

        for (week day : week.values()) {
            System.out.println(day);
        }
        w.hi();
    }
}


//            OUTPUT:
//Constructor called for saturday
//Constructor called for sunday
//Constructor called for monday
//Constructor called for tuesday
//Constructor called for wednesday
//Constructor called for thursday
//Constructor called for Friday
//sunday
//1
//saturday
//sunday
//monday
//tuesday
//wednesday
//thursday
//Friday
//HIW ! Welcome
