package org.treasure.chest.dev.template.util;



/**
 * @author lj
 * @version 1.0.0
 * @Description 四则运算
 * @createTime 2024-04-24 17:02
 */
public class Calculator {

    public static void main(String[] args) {
        String formulaStr = "1+2*3+4/2-3";
//        String formulaStr = "1+10*3+4/2+3*2";
        System.out.println("运算结果： " + fourCalculate(formulaStr));
    }


    /**
     * 题目：笔试题如下：用java代码实现一个method，这个method的入参是一个字符串，</br>
     * 这个字符串是一个四则运算的算式，比如“1+2*3+4/2-3”；返回值是这个算式的运算结果，</br>
     * 比如“1+2*3+4/2-3”的返回值是6为了简化这个题目，这个入参的算式只包含加减乘除，不包含括号。</br>
     *
     * @param formulaStr 四则运算算式
     * @return
     */
    public static Double fourCalculate(String formulaStr){
        if (formulaStr == null || formulaStr.isEmpty()){
            return null;
        }
        formulaStr = formulaStr + "+";
        Double result = 0.0;
        StringBuilder numberStr = new StringBuilder();
        StringBuilder firstNumberStr = new StringBuilder();
        char operatorSum = '?';
        char operator = '*';
        for (int i = 0; i < formulaStr.length(); i++){
            if (formulaStr.charAt(i) == ' ')
                continue;
            if (formulaStr.charAt(i) == '-'
                    || formulaStr.charAt(i) == '+'){
                if (numberStr.length() > 0){
                    if (firstNumberStr.length() > 0){
                        if (operator == '*'){
                            numberStr = new StringBuilder(String.valueOf(Double.valueOf(firstNumberStr.toString()) * Double.valueOf(numberStr.toString())));
                        }else if (operator == '/'){
                            numberStr = new StringBuilder(String.valueOf(Double.valueOf(firstNumberStr.toString()) / Double.valueOf(numberStr.toString())));
                        }
                    }
                    if (operatorSum == '?' || operatorSum == '+'){
                        result = result + Double.valueOf(numberStr.toString());
                    }else if (operatorSum == '-'){
                        result = result - Double.valueOf(numberStr.toString());
                    }
                }
                operatorSum = formulaStr.charAt(i);
                firstNumberStr = firstNumberStr.delete(0, firstNumberStr.length());
                numberStr = numberStr.delete(0, numberStr.length());
                continue;
            } else if (formulaStr.charAt(i) == '*'
                    ||formulaStr.charAt(i) == '/'){
                firstNumberStr = new StringBuilder(numberStr);
                operator = formulaStr.charAt(i);
                numberStr = numberStr.delete(0, numberStr.length());
                continue;
            }
            numberStr.append(formulaStr.charAt(i));
        }
        return result;
    }

    /**
     * 题目：笔试题如下：用java代码实现一个method，这个method的入参是一个字符串，</br>
     * 这个字符串是一个四则运算的算式，比如“1+2*3+4/2-3”；返回值是这个算式的运算结果，</br>
     * 比如“1+2*3+4/2-3”的返回值是6为了简化这个题目，这个入参的算式只包含加减乘除，不包含括号。</br>
     * TODO
     * @param formulaStr 四则运算算式
     * @return
     */
    public static Double fourCalculate2(String formulaStr){

        if (formulaStr == null || formulaStr.isEmpty()){
            return null;
        }

        String[] splitFormula = formulaStr.split("\\+|-");
        for (int i = 0; i < splitFormula.length; i++){
            String formula = splitFormula[i];
        }


        return 0.0;
    }


}
