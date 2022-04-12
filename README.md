# Лабораторные работы по дисциплине "Вычислительная математетика"
## ИТМО 4 семестр
**Лабораторная работа 1**  
В лабораторной работе нужно реализовать метод Гаусса для решения систем линейных алгебраических уравнений, который бы позволял находить столбец неизвестных для системы линейных алгебраических уравнений. Размер системы предполагается ограниченным 20, это означает, что программу после реализации необходимо будет проверить на матрице размером 20 x 20 + 20 элементов (количество неизвестных в матрице A и столбце B).Традиционно предлагается сделать следующие методы ввода данных в программу:
* Пользовательский ввод
* Ввод данных из файла
* Генерация случайных матриц

Так же в программе необходимо реализовать :
* Вычисление определителя
* Вывод треугольной матрицы (включая преобразованный столбец В)
* Столбец неизвестных
* Столбец невязок

Невязка представляет собой разницу между левой и правой частью уравнения. Таким образом для каждого уравнения в системе будет рассчитываться собственное значение невязки. Если правая часть уравнения у нас уже есть – это соответствующий элемент матрицы B, то левую часть нужно рассчитать, подставив на
места неизвестных 𝑥 рассчитанные при помощи численного метода значения, а затем произведя операции умножения и сложения.   
Невязка – это то, на сколько правая часть уравнения не равна левой, в то время как в уравнении по определению обе части должны быть равны.  
При расчёте определителя необходимо помнить и учитывать свойства определителя.  
