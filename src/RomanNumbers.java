import java.util.List;

public class RomanNumbers {

    private final int numberOne;
    private final int numberTwo;
    private final String operator;

    public RomanNumbers(String numberOne, String numberTwo, String operator) throws Exception {

        if (!numberOne.matches("\\d") && !numberTwo.matches("\\d")) {
            this.numberOne = romanToArabic(numberOne);
            this.numberTwo = romanToArabic(numberTwo);
        } else {
            throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
        }
        this.operator = operator;

    }

    public String calculations() throws Exception {

        int resultInt;

        resultInt = switch (operator) {
            case "+" -> numberOne + numberTwo;
            case "-" -> numberOne - numberTwo;
            case "*" -> numberOne * numberTwo;
            case "/" -> numberOne / numberTwo;
            default -> 0;
        };
        if (resultInt < 1)
            throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел");
        return arabicToRoman(resultInt);
    }

    public static int romanToArabic(String input) {
        String romanNumeral = input;
        int result = 0;

        List romanNumerals = RomanValues.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanValues symbol = (RomanValues) romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        return result;
    }

    public static String arabicToRoman(int number) throws Exception {
        if ((number <= 0) || (number > 4000)) {
            throw new Exception("Число не может быть меньше 1(I) и больше 3999(MMMCMXCIX)");
        }

        List romanNumerals = RomanValues.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanValues currentSymbol = (RomanValues) romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

}
