package com.example.numbershapes;

class Number {
    int number;

    public Number(int parseInt) {

    }

    public boolean isSquare() {
        double squareRoot = Math.sqrt(number);
        if (squareRoot == Math.floor(squareRoot)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isTriangular() {
        int x = 1;
        int triangularNumber = 1;
        while (triangularNumber < number) {
            x++;
            triangularNumber = triangularNumber + x;
        }
        if (triangularNumber == number) {
            return true;
        } else {
            return false;
        }
    }
}
