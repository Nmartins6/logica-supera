package br.com.nicolasmartins.desafios;

import java.util.ArrayList;
import java.util.List;

public class Snail {

    public static List<Integer> snail(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

//  *********** SUGGESTED TEST CASES ***********
//
//        int[][] matrix1 = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//
//        int[][] matrix2 = {
//                {1, 2, 3},
//                {4, 10, 12},
//                {6, 7, 33}
//        };
//
//  *********** BIGGER TEST CASE ***********
//
//        int[][] matrix3 = {
//                {24, 25, 22, 23, 21},
//                {19, 20, 18, 17, 16},
//                {14, 15, 13, 12, 12},
//                {10,  8,  9,  7,  5},
//                {3,   4,  2,  1,  8}
//        };
//
// *********** OUTPUT TESTS ***********
//
//        System.out.println(snail(matrix1)); // [1, 2, 3, 6, 9, 8, 7, 4, 5]
//        System.out.println(snail(matrix2)); // [1, 2, 3, 12, 33, 7, 6, 4, 10]
//        System.out.println(snail(matrix3)); // [6, 2, 3, 8, 15, 6, 11, 22, 33, 7, 4, 10, 12]
    }
}