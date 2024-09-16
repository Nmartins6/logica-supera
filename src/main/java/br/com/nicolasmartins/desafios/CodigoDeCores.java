package br.com.nicolasmartins.desafios;

import java.util.HashMap;
import java.util.Map;

public class CodigoDeCores {

        private static final Map<Integer, String> DIGIT_COLORS = new HashMap<>();
        private static final String TOLERANCE_COLOR = "dourado";

        static {
            DIGIT_COLORS.put(0, "preto");
            DIGIT_COLORS.put(1, "marrom");
            DIGIT_COLORS.put(2, "vermelho");
            DIGIT_COLORS.put(3, "laranja");
            DIGIT_COLORS.put(4, "amarelo");
            DIGIT_COLORS.put(5, "verde");
            DIGIT_COLORS.put(6, "azul");
            DIGIT_COLORS.put(7, "violeta");
            DIGIT_COLORS.put(8, "cinza");
            DIGIT_COLORS.put(9, "branco");
        }

        public static String getResistorColors(String input) {
            String valueStr = input.split(" ")[0]; // Pega o valor de ohms da string
            double value;

            if (valueStr.endsWith("k")) {
                value = Double.parseDouble(valueStr.replace("k", "")) * 1000;
            } else if (valueStr.endsWith("M")) {
                value = Double.parseDouble(valueStr.replace("M", "")) * 1000000;
            } else {
                value = Double.parseDouble(valueStr);
            }

            int firstDigit, secondDigit, multiplier;
            String color1, color2, color3;

            if (value < 10) {
                firstDigit = (int) value;
                secondDigit = 0;
                multiplier = 0;
            } else if (value < 100) {
                firstDigit = (int) (value / 10);
                secondDigit = (int) (value % 10);
                multiplier = 0;
            } else if (value < 1000) {
                firstDigit = (int) (value / 100);
                secondDigit = (int) ((value % 100) / 10);
                multiplier = 1;
            } else if (value < 10000) {
                firstDigit = (int) (value / 1000);
                secondDigit = (int) ((value % 1000) / 100);
                multiplier = 2;
            } else if (value < 100000) {
                firstDigit = (int) (value / 10000);
                secondDigit = (int) ((value % 10000) / 1000);
                multiplier = 3;
            } else if (value < 1000000) {
                firstDigit = (int) (value / 100000);
                secondDigit = (int) ((value % 100000) / 10000);
                multiplier = 4;
            } else if (value < 10000000) {
                firstDigit = (int) (value / 1000000);
                secondDigit = (int) ((value % 1000000) / 100000);
                multiplier = 5;
            } else {
                return "Valor inválido";
            }

            color1 = DIGIT_COLORS.get(firstDigit);
            color2 = DIGIT_COLORS.get(secondDigit);
            color3 = DIGIT_COLORS.get(multiplier);

            return String.join(" ", color1, color2, color3, TOLERANCE_COLOR);
        }

        public static void main(String[] args) {
//            System.out.println(getResistorColors("10 ohms"));   // marrom preto preto dourado
//            System.out.println(getResistorColors("100 ohms"));  // marrom preto marrom dourado
//            System.out.println(getResistorColors("220 ohms"));  // vermelho vermelho marrom dourado
//            System.out.println(getResistorColors("330 ohms"));  // laranja laranja marrom dourado
//            System.out.println(getResistorColors("470 ohms"));  // amarelo violeta marrom dourado
//            System.out.println(getResistorColors("680 ohms"));  // azul cinza marrom dourado
//            System.out.println(getResistorColors("1k ohms"));   // marrom preto vermelho dourado
            System.out.println(getResistorColors("47 ohms"));
        }
    }