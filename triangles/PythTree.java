import java.awt.Color;

public class PythTree {
    
    public static void filledSquare(double x, double y, double s, double angle) {
        double[] xArr = { x - (s/2), x + (s/2), x + (s/2), x - (s/2) };
        double[] yArr = { y, y, y + s, y + s };
        // rotate square
        rotateXY(x, y, xArr, yArr, angle);
        StdDraw.filledPolygon(xArr, yArr);
    }

    public static void pythTree(int n, double x, double y, double s, double angle) {
        if(n<1)
            return;
        // draw square
        filledSquare(x, y, s, angle);
        // New positions for next 2 squares
        double[] xArr = { x-(s/4), x+(s/4) };
        double[] yArr = { y+(s+(s/4)), y+(s+(s/4)) };
        // rotate new positions
        rotateXY(x, y, xArr, yArr, angle);
        // add the 2 new squares
        pythTree(n-1, xArr[0], yArr[0], s*(Math.sqrt(2)/2), angle+45);
        pythTree(n-1, xArr[1], yArr[1], s*(Math.sqrt(2)/2), angle-45);
    }

    public static void main(String[] args) {
        int order = Integer.parseInt(args[0]);
        pythTree(order, 0.5, 0, 0.15, 0);
    }

    public static void rotateXY(double x, double y, double[] xArr, double[] yArr, double angle) {
    	for(int i=0; i<xArr.length; i++) {
    		// Normalize position
    		double x1 = xArr[i]-x;
    		double y1 = yArr[i]-y;
    		// apply rotation
    		double tempX = (x1*Math.cos(Math.toRadians(angle))) - (y1*Math.sin(Math.toRadians(angle)));
    		double tempY = (x1*Math.sin(Math.toRadians(angle))) + (y1*Math.cos(Math.toRadians(angle)));
    		// Denormalize position
    		xArr[i] = x + tempX;
    		yArr[i] = y + tempY;
    	}
    }

}