# Тесты к курсу «Введение в программирование»
Домашнее задание 5. Быстрый реверс
----
* Для групп 36-39 надо написать `Scanner` используя побайтовое считывание, то есть нельзя использовать `BufferedReader` и аналоги!
* Для групп 38-39 запрешено использовать регулярные выражения, функцию `split`, класс `StringTokenizer` и аналоги.

Модификации
 * *Минимум*
    * Рассмотрим входные данные как (не полностью определенную) матрицу,
      вместо каждого числа выведите минимум из чисел в его столбце и строке.
    * Сравнить время работы вашего сканера и встроенного в java
    * Класс должен иметь имя `ReverseMin`
    * [Исходный код тестов](java/reverse/ReverseMinFastTest.java)
    * [Откомпилированные тесты](artifacts/reverse/ReverseMinFastTest.jar)

1. Реализуйте свой аналог класса `Scanner`. Разработайте класс Reverse, читающий числа из стандартного входа, и выводящий их на стандартный вывод в обратном порядке.
2. Примените разработанный `Scanner` для решения задания "Реверc".
3. Модифицируйте решени задания "Реверc" так, что бы оно работало за линейное время.
Исходный код тестов:

* [ReverseFastTest.java](java/reverse/ReverseFastTest.java)
* [ReverseChecker.java](java/reverse/ReverseChecker.java)

Откомпилированные тесты: [ReverseFastTest.jar](artifacts/reverse/ReverseFastTest.jar)




Домашнее задание 4. Подсчет слов
----
Модификации
 * *Words*
    * В выходном файле слова должны быть упорядочены в лексикографическом порядке
    * Класс должен иметь имя `WordStatWords`
    * [Исходный код тестов](java/wordStat/WordStatWordsTest.java)
    * [Откомпилированные тесты](artifacts/wordStat/WordStatWordsTest.jar)

1. Разработайте класс `WordStatInput`, который будет подсчитывать статистику встречаемости слов во входном файле.
2. Словом называется неперывная последовательность букв, апострофов и тире (Unicode category Punctuation, Dash). Для подсчета статистики, слова приводятся к нижнему регистру.
3. Выходной файл должен содержать все различные слова, встречающиеся во входном файле, в порядке их появения. Для каждого слова должна быть выведена одна строка, содежащая слово и число его вхождений во входной файл.
4. Имена входного и выходного файла задаются в качестве аргументов командной строки. Кодировка файлов: UTF-8.
5. Примеры работы программы:
```
     Входной файл:
         To be, or not to be, that is the question:
     Выходной файл:
         to 2
         be 2
         or 1
         not 1
         that 1
         is 1
         the 1
         question 1
     Входной файл:
         Monday's child is fair of face.
         Tuesday's child is full of grace.
     Выходной файл:
         monday's 1
         child 2
         is 2
         fair 1
         of 2
         face 1
         tuesday's 1
         full 1
         grace 1
     Входной файл:
         Шалтай-Болтай
         Сидел на стене.
         Шалтай-Болтай
         Свалился во сне.
     Выходной файл:
         шалтай-болтай 2
         сидел 1
         на 1
         стене 1
         свалился 1
         во 1
         сне 1
```

Исходный код тестов:

* [WordStatInputTest.java](java/wordStat/WordStatInputTest.java)
* [WordStatChecker.java](java/wordStat/WordStatChecker.java)

Откомпилированные тесты: [WordStatInputTest.jar](artifacts/wordStat/WordStatInputTest.jar)


Домашнее задание 3. Сумма чисел в файле
----
Модификации
 * *Abc*
    * На вход подаются числа, представленные буквами.
      Нулю соответствует буква `a`, единице – `b` и так далее
    * Ввод регистронезависим
    * Класс должен иметь имя `SumAbcFile`
    * [Исходный код тестов](java/sum/SumAbcFileTest.java)
    * [Откомпилированные тесты](artifacts/sum/SumAbcFileTest.jar)
 * *Hex*
    * На вход подаются десятичные и шестнадцатеричные числа
    * Шестнадцатеричные числа имеют префикс `0x`
    * Ввод регистронезависим
    * Класс должен иметь имя `SumHexFile`
    * [Исходный код тестов](java/sum/SumHexFileTest.java)
    * [Откомпилированные тесты](artifacts/sum/SumHexFileTest.jar)

1. Разработайте класс `SumFile`, записывающий сумму чисел из входного файла в выходной файл.
2. Числа во входном файле разделены переводами строк и/или пробельными символами.
3. Имена входного и выходного файла задаются в качестве аргументов командной строки.
4. Примеры работы программы:
```
    Входной файл:
        1 2 3
    Выходной файл:
        6
    Входной файл:
        1 2 -3
    Выходной файл:
        0
    Входной файл:
        1 2
          3
    Выходной файл:
        6     
```
5. При выполнении задания можно считать что для представления входных данных и промежуточных результатов достаточен тип `int`.
6. В этом и последующих домашних заданиях, метод main не должен выбрасывать никаких исключений при любых (в том числе некорректных) входных данных.
7. В этом и последующих домашних заданиях, все ресурсы должны закрываться при любых (в том числе некорректных) входных данных.
Исходный код тестов:

* [SumFileTest.java](java/sum/SumFileTest.java)
* [SumFileChecker.java](java/sum/SumFileChecker.java)

Откомпилированные тесты: [SumFileTest.jar](artifacts/sum/SumFileTest.jar)


## Домашнее задание 2. Реверс
Модификации
 * *Транспозиция*
    * Рассмотрим входные данные как (не полностью определенную) матрицу,
      выведите ее в транспонированном виде
    * Класс должен иметь имя `ReverseTranspose`
    * [Исходный код тестов](java/reverse/ReverseTransposeTest.java)
    * [Откомпилированные тесты](artifacts/reverse/ReverseTransposeTest.jar)
 * *Максимум*
    * Рассмотрим входные данные как (не полностью определенную) матрицу,
      вместо каждого числа выведите максимум из чисел в его столбце и строке.
    * Класс должен иметь имя `ReverseMax`
    * [Исходный код тестов](java/reverse/ReverseMaxTest.java)
    * [Откомпилированные тесты](artifacts/reverse/ReverseMaxTest.jar)



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
