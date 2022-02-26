package oop.labor02.dateutil;

public class DateUtil {
    public static boolean leapYear(int year)
    {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public static boolean isValidDate(int year, int month, int day){
        if (year>0  && (day>0 && day<32))
        {
            switch(month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return true;
                case 2:{ if (day<29 || (leapYear(year) && day<30)) {
                             return true;
                        }
                        break;
                }
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day<31){
                    return true;
                }
                break;
                default:
                    return false;
            }

        }
        return false;
    }

}
