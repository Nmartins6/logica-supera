package br.com.nicolasmartins.nao_avaliar;

public class FlorSamambaia {

    public static String tentativaDesenhar(int r1, int x1, int y1, int r2, int x2, int y2) {
        double distanciaCentros = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if (r1 >= r2 && distanciaCentros <= (r1 - r2)) {
            return "RICO";
        } else {
            return "MORTO";
        }
    }

    public static void main(String[] args) {

        System.out.println(tentativaDesenhar(5, 0, 0, 3, 1, 1));
        System.out.println(tentativaDesenhar(4, 0, 0, 3, 5, 5));
        System.out.println(tentativaDesenhar(5, 0, 0, 2, 1, 1));
    }
}