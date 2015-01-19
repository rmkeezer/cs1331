public class DoomsdayCalendar {
    private int anchorDay = 3;
    private int[] doomsDayArr = {3, 28, 7, 4, 9, 6, 11, 8, 5, 10, 7, 12};
    private String[] daysOfWeek = {"Sunday", "Monday", "Tuesday",
        "Wednesday", "Thursday", "Friday", "Saturday"};

    public static void main(String[] args) {
        new DoomsdayCalendar();
    }

    public DoomsdayCalendar() {
        System.out.println("Welcome to the Doomsday Calculator!");
        boolean noAnswer = true;
        int question = 1;
        int year = 0;
        int month = 0;
        int day = 0;
        while (noAnswer) {
            try {
                if (question == 1) {
                    System.out.print("What year are you looking for? ");
                    year = Integer.parseInt(System.console().readLine());
                    question = 2;
                } else if (question == 2) {
                    System.out.print("What month (1-12)? ");
                    month = Integer.parseInt(System.console().readLine());
                    question = 3;
                } else if (question == 3) {
                    System.out.print("What day? ");
                    day = Integer.parseInt(System.console().readLine());
                    noAnswer = false;
                }
            } catch (ArithmeticException e) {
                System.out.print("Please enter a valid number");
            }
        }
        int calcDay = getDay(month, day, year);
        int finalDay = getFinalDay(day, month, year, calcDay);
        System.out.println(month + "/" + day + "/" + year + " was on a "
            + daysOfWeek[finalDay] + ".");
    }

    private int getDay(int month, int day, int year) {
        int lastTwoNums = year % 100;
        int sum = (lastTwoNums / 12) + (lastTwoNums % 12)
                + ((lastTwoNums % 12) / 4);
        sum += anchorDay;
        return sum % 7;
    }

    private int getFinalDay(int day, int month, int year, int calcDay) {
        int doomsDay = doomsDayArr[month - 1];
        if (isLeap(year)) {
            doomsDay++;
        }
        int diff = day - doomsDay;
        int sum = diff + calcDay;
        return (sum % 7) < 0 ? sum % 7 + 7 : sum % 7;
    }

    private boolean isLeap(int year) {
        return (year != 1900) && ((year - 1800) % 4) == 0;
    }
}