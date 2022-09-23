import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static String calc(String input) {

        String result = "";
        try {

            String[] splitString;

            if (input.length() == 1) {
                throw new Exception("throws Exception //т.к. строка не является математической операцией");
            } else {
                splitString = input.split(" ");
                if (splitString.length != 3) {
                    throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                }
            }

            String numberOneStr = splitString[0];
            String numberTwoStr = splitString[2];
            String operator = splitString[1];

            try {

                int numberOneInt = Integer.parseInt(numberOneStr);
                int numberTwoInt = Integer.parseInt(numberTwoStr);
                result = new ArabicNumbers(numberOneInt, numberTwoInt, operator).calculations();

            } catch (NumberFormatException e) {
                result = new RomanNumbers(numberOneStr, numberTwoStr, operator).calculations();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String result = calc(readerConsole.readLine());
        System.out.println(result);

    }

}
