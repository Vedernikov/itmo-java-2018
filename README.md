# Тесты к курсу «Введение в программирование»

## Домашнее задание 2. Реверс
Модификации
 * *Транспозиция*
    * Рассмотрим входные данные как (не полностью определенную) матрицу,
      выведите ее в транспонированном виде
    * Класс должен иметь имя `ReverseTranspose`
    * [Исходный код тестов](java/reverse/ReverseTransposeTest.java)
    * [Откомпилированные тесты](artifacts/reverse/ReverseTransposeTest.jar)



1. Разработайте класс `Reverse`, читающий числа из стандартного входа, и выводящий их на стандартный вывод в обратном порядке.
2. В каждой строке входа содержится некоторое количество целых чисел (может быть 0). Числа разделены пробелами. Каждое число помещается в тип `int`.
3. Порядок строк в выходе должен быть обратным по сравнению с порядком строк во входе. Порядок чисел в каждой строки так же должен быть обратным к порядку чисел во входе.
4. Примеры работы программы:
	```
     Вход:
         1 2
         3
     Выход:
         3
         2 1
     Вход:
         1

         2 -3
     Выход:
         -3 2

         1
    ```
Исходный код тестов:

* [ReverseTest.java](java/reverse/ReverseTest.java)
* [ReverseChecker.java](java/reverse/ReverseChecker.java)

Откомпилированные тесты: [ReverseTest.jar](artifacts/reverse/ReverseTest.jar)


## Домашнее задание 1. Сумма чисел

 * *SumHex*
    * Входные данные помещаются в тип `int` либо десятичные, либо шестнадцатиричное начинается с `0x`
    * Класс должен иметь имя `SumHex`
    * Нельзя использоваться классы `Long` и `BigInteger`
    * [Исходный код тестов](java/sum/SumHexTest.java)
    * [Откомпилированные тесты](artifacts/sum/SumHexTest.jar)

 * *BigIntegerDigit*
    * Входные данные помещаются в тип [BigInteger](https://docs.oracle.com/javase/8/docs/api/java/math/BigInteger.html)
    * Класс должен иметь имя `SumBigInteger`
    * Числа имеют вид `[знак]цифры`
    * [Исходный код тестов](java/sum/SumBigIntegerDigitTest.java)
    * [Откомпилированные тесты](artifacts/sum/SumBigIntegerDigitTest.jar)


1. Разработайте класс `Sum`, который при запуске из командной строки будет складывать переданные в качестве аргументов целые числа и выводить их сумму на консоль.
2. Примеры запуска программы:
	```
	java Sum 1 2 3
		Результат: 6
	java Sum 1 2 -3
		Результат: 0
	java Sum "1 2 3"
		Результат: 6
	java Sum "1 2" " 3"
		Результат: 6
	```
	Аргументы могут содержать цифры и произвольные [пробельные символы](https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isWhitespace-char-).
3. При выполнении задания можно считать что для представления входных данных и промежуточных результатов достаточен тип `int`.
4. При выполнении задания полезно ознакомиться с документацией к классам [String](http://download.oracle.com/javase/8/docs/api/java/lang/String.html) и [Integer](http://download.oracle.com/javase/8/docs/api/java/lang/Integer.html).

Для того, чтобы протестировать исходную программу:

 1. Скачайте откомпилированные тесты ([SumTest.jar](artifacts/sum/SumTest.jar))
 2. Откомпилируйте `Sum.java`
 3. Проверьте, что создался `Sum.class`
 4. В каталоге, в котором находится `Sum.class` выполните команду
    ```
       java -jar <путь к SumTest.jar>
    ```
    * Например, если `SumTest.jar` находится в текущем каталоге, выполните команду
    ```
        java -jar SumTest.jar
    ```

Исходный код тестов:

* [SumTest.java](java/sum/SumTest.java)
* [SumChecker.java](java/sum/SumChecker.java)
* [SChecker.java](java/sum/SChecker.java)
* [Базовые классы](java/base/)
