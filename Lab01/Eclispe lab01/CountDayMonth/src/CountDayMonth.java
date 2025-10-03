import javax.swing.JOptionPane;
public class CountDayMonth {
    public static void main(String[] args) {
        int year = -1;
        int month = -1;
        String yearStr;
        String monthStr;
        while (month == -1 || year == -1) {
            monthStr = JOptionPane.showInputDialog("Please enter the month:");
            yearStr = JOptionPane.showInputDialog("Please enter the year:");
            month = -1;
            year = -1;
            month = ConvertMonth(monthStr);
            try {
                if (yearStr == null || yearStr.trim().length() != 4) {
                } else {
                    year = Integer.parseInt(yearStr.trim());
                    if (year < 0) {
                        year = -1;
                    }
                }
            } catch (NumberFormatException e) {
            }
            if (month == -1 || year == -1) {
                String errorMsg = "Invalid input! Please re-enter both month and year.\n";
                if (month == -1 && monthStr != null) errorMsg += " - Invalid Month (Enter name or number 1-12).\n";
                if (year == -1 && yearStr != null) errorMsg += " - Invalid Year (Must be a 4-digit non-negative number).\n";
                if (monthStr == null || yearStr == null) errorMsg += " - Input cancelled. Please enter valid values.\n";
                JOptionPane.showMessageDialog(null, errorMsg);
            }
        }
        int days = CheckMonth(month, year);
        JOptionPane.showMessageDialog(null,
                "Month " + month + " of year " + year + " has " + days + " days.");
        System.exit(0);
    }
    public static int CheckMonth(int month, int year) {
        int days;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: days = 31; break;
            case 4: case 6: case 9: case 11: days = 30; break;
            case 2:
                if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            default: days = -1;
        }
        return days;
    }

    public static int ConvertMonth(String monthStr) {
        if (monthStr == null) return -1;
        monthStr = monthStr.toLowerCase().trim();
        switch (monthStr) {
            case "1": case "january": case "jan": case "jan.": return 1;
            case "2": case "february": case "feb": case "feb.": return 2;
            case "3": case "march": case "mar": case "mar.": return 3;
            case "4": case "april": case "apr": case "apr.": return 4;
            case "5": case "may": return 5;
            case "6": case "june": case "jun": return 6;
            case "7": case "july": case "jul": return 7;
            case "8": case "august": case "aug": case "aug.": return 8;
            case "9": case "september": case "sep": case "sept": case "sept.": return 9;
            case "10": case "october": case "oct": case "oct.": return 10;
            case "11": case "november": case "nov": case "nov.": return 11;
            case "12": case "december": case "dec": case "dec.": return 12;
            default: return -1;
        }
    }
}