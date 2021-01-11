import java.util.Scanner;

public class daa006 {
    public static boolean checkCircleInSquare(double aX, double aY, double side, double cX, double cY, double radius) {
        if (aX <= cX - radius && aY <= cY - radius && aX + side >= cX + radius && aY + side >= cY + radius) { return true; }

        return false;
    }

    public static boolean checkSquareInCircle(double aX, double aY, double side, double cX, double cY, double radius) {
        if (
            Math.pow(aX - cX, 2) + Math.pow(aY - cY, 2) <= Math.pow(radius, 2) &&
            Math.pow(aX + side - cX, 2) + Math.pow(aY + side - cY, 2) <= Math.pow(radius, 2) &&
            Math.pow(aX - cX, 2) + Math.pow(aY + side - cY, 2) <= Math.pow(radius, 2) &&
            Math.pow(aX + side - cX, 2) + Math.pow(aY - cY, 2) <= Math.pow(radius, 2)
        ) { return true; } 

        return false;
    }

    public static boolean checkNoneIn(double aX, double aY, double side, double cX, double cY, double radius) {
        if ( 
            Math.sqrt((aX - cX) * (aX - cX) +  (aY - cY) * (aY - cY)) > radius &&
            Math.sqrt((aX + side - cX) * (aX + side - cX) + (aY + side - cY) * (aY + side - cY)) > radius &&
            Math.sqrt((aX - cX) * (aX - cX) + (aY + side - cY) * (aY + side - cY)) > radius &&
            Math.sqrt((aX + side - cX) * (aX + side - cX) + (aY - cY) * (aY - cY)) > radius &&
            !(cX > aX && cX < aX + side) && 
            !(cY > aY && cY < aY + side)
        ) { return true; }

        return false;
    }

    public static double intersection(double aX, double aY, double side, double cX, double cY, double radius) {
        if (checkCircleInSquare(aX, aY, side, cX, cY, radius)) { return Math.PI * Math.pow(radius, 2); }

        if (checkSquareInCircle(aX, aY, side, cX, cY, radius)) { return Math.pow(side, 2); }

        if (checkNoneIn(aX, aY, side, cX, cY, radius)) { return 0; } 

        double area = 0;

        if (side >= 0.001) {
            side /= 2.0;

            area += intersection(aX, aY, side, cX, cY, radius);
            area += intersection(aX + side, aY + side, side, cX, cY, radius);
            area += intersection(aX + side, aY, side, cX, cY, radius);
            area += intersection(aX, aY + side, side, cX, cY, radius);
            return area;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        for (int i = 0; i < N; i++) {
            double aX     = input.nextInt();
            double aY     = input.nextInt();
            double side   = input.nextInt();
            double cX     = input.nextInt();
            double cY     = input.nextInt();
            double radius = input.nextInt();
            
            System.out.println(intersection(aX, aY, side, cX, cY, radius));
        }
    }
}