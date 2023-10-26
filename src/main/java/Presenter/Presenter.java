package Presenter;

import Model.ComplexNumberM;
import Loger.Loger;

import java.io.IOException;
import java.util.Scanner;
public class Presenter {

    public void StartCalc() {
        Loger loger = new Loger();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вещественную часть 1-го комплекного числа ");
        double re = scanner.nextDouble();
        System.out.println("Введите мнимую часть числа 1-го комплексного числа ");
        double im = scanner.nextDouble();
        ComplexNumberM.ComplexNumber a = new ComplexNumberM.ComplexNumber(re, im);
        System.out.println("Введите вещественную часть 2-го комплексного числа ");
        double re1 = scanner.nextDouble();
        System.out.println("Введите мнимую часть 2-го комплексного числа ");
        double im1 = scanner.nextDouble();
        ComplexNumberM.ComplexNumber b = new ComplexNumberM.ComplexNumber(re1, im1);
        System.out.println("Выберите действие ");
        System.out.println("1 - Сложение комплексного числа ");
        System.out.println("2 - Вычитание комплексного числа ");
        System.out.println("3 - Умножение комплексного числа ");
        System.out.println("4 - Деление комплексного числа ");
        int swt = scanner.nextInt();
        if (swt == 1) {
            ComplexNumberM.ComplexNumber.add(a, b);
            System.out.println("Сумма комплексных чисел равна: ");
            System.out.println(a.toString() + " + " + b.toString() + " = " + ComplexNumberM.ComplexNumber.add(a, b).toString());
            try {
                loger.loger1("Summa of complex numbers ", ComplexNumberM.ComplexNumber.add(a, b));
            } catch (IOException e) {
                e.getMessage();
            }
        }
        if (swt == 2) {
            ComplexNumberM.ComplexNumber.substract(a, b);
            System.out.println("Разность комплексных чисел равна: ");
            System.out.println(a.toString() + " - " + b.toString() + " = " + ComplexNumberM.ComplexNumber.substract(a, b).toString());
            try {
                loger.loger1("Substract of complex numbers", ComplexNumberM.ComplexNumber.substract(a, b));
            } catch (IOException e) {
                e.getMessage();
            }
            if (swt == 3) {
                ComplexNumberM.ComplexNumber.multiple(a, b);
                System.out.println("Произведение комплексных чисел равно: ");
                System.out.println(a.toString() + " * " + b.toString() + " = " + ComplexNumberM.ComplexNumber.multiple(a, b).toString());
            }
            if (swt == 4) {
                ComplexNumberM.ComplexNumber.divide(a, b);
                System.out.println("Деление комплексных чисел равно: ");
                System.out.println(a.toString() + " / " + b.toString() + " = " + ComplexNumberM.ComplexNumber.divide(a, b).toString());

            }

        }
    }
}



//    View view;
//    Model model;
//
//    public Presenter(Model m, View v){
//        model = m;
//        view = v;
//    }
//    public void ButtonClik(){
//        double a = view.getValue("Введите первое число: ");
//        double b = view.getValue("Введите второе число: ");
//        model.setNumber1(a);
//        model.setNumber2(b);
//        double result = model.result();
//        view.print("Результат: ", result);


//    }

