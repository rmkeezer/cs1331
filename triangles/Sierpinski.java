import java.awt.Color;

public class Sierpinski {
    
    public static void filledTriangle(double x, double y, double s) {
        double[] xArr = { x, x - (s/2), x + (s/2) };
        double[] yArr = { y, y + (s*(Math.sqrt(3.0)/2.0)), y + (s*Math.sqrt(3.0)/2.0) };
        StdDraw.filledPolygon(xArr, yArr);
    }

    public static void sierpinski(int n, double x, double y, double s) {
        if(n<1)
            return;
        filledTriangle(x, y, s);
        sierpinski(n-1, x-(s/2), y, s/2);
        sierpinski(n-1, x+(s/2), y, s/2);
        sierpinski(n-1, x, y + (s*(Math.sqrt(3.0)/2.0)), s/2);
    }

    public static void main(String[] args) {
        int order = Integer.parseInt(args[0]);
        double[] xArr = { 0, 1.0, 0.5 };
        double[] yArr = { 0, 0, Math.sqrt(3.0)/2.0 };
        StdDraw.setPenColor(Color.GRAY);
        StdDraw.polygon(xArr, yArr);
        StdDraw.setPenColor();
        sierpinski(order, 0.5, 0, 0.5);
    }

}