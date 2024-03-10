import java.util.Scanner;
public class Main3 {
    private static int RomanToArabic(String roman) { //Задаем эквивалент римской системе счисления согласно арабской если не соответствует то возвращаем значение переменной RomanToArabic -1
        if (roman.equals("один")) {
            return 1;
        } else if (roman.equals("два")) {
            return 2;
        } else if (roman.equals("три")) {
            return 3;
        } else if (roman.equals("четыре")) {
            return 4;
        } else if (roman.equals("пять")) {
            return 5;
        } else if (roman.equals("шесть")) {
            return 6;
        } else if (roman.equals("семь")) {
            return 7;
        } else if (roman.equals("восемь")) {
            return 8;
        } else if (roman.equals("девять")) {
            return 9;
        } else if (roman.equals("десять")) {
            return 10;
        }
        return -1;
    }
    private static String numberToRoman(int resultArabic) {
        String[] roman = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать", "двадцать ", "двадцать один", "двадцать два", "двадцать три", "двадцать четыре", "двадцать пять", "двадцать шесть", "двадцать семь", "двадцать восемь", "двадцать девять", "тридцать ", "тридцать один", "тридцать два", "тридцать три", "тридцать четыре", "тридцать пять", "тридцать шесть", "тридцать семь", "тридцать восемь", "тридцать девять", "сорок ", "сорок один", "сорок два", "сорок три", "сорок четыре", "сорок пять", "сорок шесть", "сорок семь", "сорок восемь", "сорок девять", "пятьдесят ", "пятьдесят один", "пятьдесят два", "пятьдесят три", "пятьдесят четыре", "пятьдесят пять", "пятьдесят шесть", "пятьдесят семь", "пятьдесят восемь", "пятьдесят девять", "шестьдесят ", "шестьдесят один", "шестьдесят два", "шестьдесят три", "шестьдесят четыре", "шестьдесят пять", "шестьдесят шесть", "шестьдесят семь", "шестьдесят восемь", "шестьдесят девять", "семьдесят ", "семьдесят один", "семьдесят два", "семьдесят три", "семьдесят четыре", "семьдесят пять", "семьдесят шесть", "семьдесят семь", "семьдесят восемь", "семьдесят девять", "восемьдесят ", "восемьдесят один", "восемьдесят два", "восемьдесят три", "восемьдесят четыре", "восемьдесят пять", "восемьдесят шесть", "восемьдесят семь", "восемьдесят восемь", "восемьдесят девять", "девяносто ", "девяносто один", "девяносто два", "девяносто три", "девяносто четыре", "девяносто пять", "девяносто шесть", "девяносто семь", "девяносто восемь", "девяносто девять", "сто ",


                //Создали массив с римскими цифрами для вывода ответа. Последнее число C так как X*X=C. Это максимально возможное решение.
        };
        return roman[resultArabic];
    }
    public static String calc(String input) throws Exception {             // После ввода строки строки определяем положение операндов поиском по строке
        int cnt = 0;                      // и так же устанавливаем значение переменной cnt (количество операндов)
        int operIndex = -1;
        for (int i = 0; i < input.length() && cnt < 2; i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/'|| input.indexOf("плюс") == i) {
                cnt++;
                operIndex = i;
            }
        }
        if (cnt < 1) {   //если опереранд не найден то переменной cnt присваивается значение 0
            // если более 1 операрнда то присваивается значение в зависимости от количества операндов
            //если cnt не равна 1 то срабатывет новое условие ниже
            throw new Exception("Символ операций не найден (+,-,*,/)");
        } else if (cnt > 1){
            throw new Exception("Вы ввели более 1 символа операции (+,-,*,/)");
        }
        String leftArg = input.substring(0, operIndex).trim();              // Определяем значения левого и правого аргумента
        String rightArg = input.substring(operIndex + 1).trim();  // относительно операнда

        boolean isRome;
        if (RomanToArabic(leftArg) > -1 && RomanToArabic(rightArg) > -1) {  //проверяем тип чисел римские или арабские,
            isRome = true;
        } else if (leftArg.matches("[\\d]{1,2}") && rightArg.matches("[\\d]{1,2}")) { //проверяем соответствует ли регулярному выражению левый и правый аргумент согласно маске и так же в одной системе счисления
            isRome = false;
        } else {
            throw new Exception("Слева и справа должны быть или арабские или римские цифры одновременно в диапозоне от 1 до 10");
        }

        String oper = input.substring(operIndex, operIndex + 1);// Определяем тип переменной

        if (oper.equals("плюс")) {
            return "+";
        } else if (oper.equals("минус")) {
            return "-";
        } else if (oper.equals("умножить")) {
            return "*";
        } else if (oper.equals("разделить")) {
            return "/";
        }


        int leftNum = isRome ? RomanToArabic(leftArg) : Integer.parseInt(leftArg);
        int rightNum = isRome ? RomanToArabic(rightArg) : Integer.parseInt(rightArg);
        if (leftNum < 1 || leftNum > 10 || rightNum < 1 || rightNum > 10) { //проверяем диапазон вводимых аргументов слева и справа должны быть от 1 до 10
            throw new Exception("Числа нужно вводить в диапазоне от 1 до 10");
        }

        int result = 0; //производим вычисление
        switch (oper) {
            case "+":
                result = leftNum + rightNum;
                break;
            case "-":
                result = leftNum - rightNum;
                break;
            case "*":
                result = leftNum * rightNum;
                break;
            case "/":
                result = leftNum / rightNum;
                break;
        }
        if (isRome && result <= 0) { //проверяем если переменная isRome= true и результат < 0 то выполняем условие
            throw new Exception("В римской системе счисления числа должны быть больше >= 1");
        } else if (isRome) {
            return "Ответ (В римской системе счисления):" + numberToRoman(result); // выводим результат в римской системе счисления
        } else {
            return "Ответ (В арабской системе счисления):" + result; //выводим результат в арабской системе счасления
        }
    }
    public static void main(String[] args) {
        // Выводим результат в консоль
        System.out.println("Введите выражение используя числа от 1 до 10 римские или арабские");
        String expr = new Scanner(System.in).nextLine();
        try {
            System.out.println(calc(expr));
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}