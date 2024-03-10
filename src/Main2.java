import java.util.Scanner;

public class Main2 {
    private static int RomanToArabic(String roman) { //Задаем эквивалент римской системе счисления согласно арабской если не соответствует то возвращаем значение переменной RomanToArabic -1

        return -1;
    }

    public static String calc(String input) throws Exception {             // После ввода строки строки определяем положение операндов поиском по строке
        int cnt = 0;                      // и так же устанавливаем значение переменной cnt (количество операндов)
        int operIndex = -1;
        for (int i = 0; i < input.length() && cnt < 2; i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
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

        String oper = input.substring(operIndex, operIndex + 1); // Определяем тип переменной
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
        }
         else {
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