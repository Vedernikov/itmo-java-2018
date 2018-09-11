# Тесты к курсу «Введение в программирование»

[Условия домашних заданий](http://www.kgeorgiy.info/courses/prog-intro/homeworks.html)
## Домашнее задание 1. Сумма чисел


* Разработайте класс 'Sum', который при запуске из командной строки будет складывать переданные в качестве аргументов целые числа и выводить их сумму на консоль.
* Примеры запуска программы:
	java Sum 1 2 3
		Результат: 6
	java Sum 1 2 -3
		Результат: 0
	java Sum "1 2 3"
		Результат: 6
	java Sum "1 2" " 3"
		Результат: 6

Аргументы могут содержать цифры и произвольные [пробельные символы](http://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isWhitespace(char)).
* При выполнении задания можно считать что для представления входных данных и промежуточных результатов достаточен тип 'int'.
* При выполнении задания полезно ознакомиться с документацией к классам [String](http://download.oracle.com/javase/8/docs/api/java/lang/String.html) и [Integer](http://download.oracle.com/javase/8/docs/api/java/lang/Integer.html).

Для того, чтобы протестировать исходную программу:

 1. Скачайте откомпилированные тесты ([SumTest.jar](artifacts/sum/SumTest.jar))
 * Откомпилируйте `Sum.java`
 * Проверьте, что создался `Sum.class`
 * В каталоге, в котором находится `Sum.class` выполните команду
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
