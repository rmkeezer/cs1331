class ImageProcessor {

    private Pic regPic;

    public static void main(String[] args) {
        ImageProcessor myProc = new ImageProcessor(new Pic("examplePic1.jpg"));
        myProc.greyscale().show();
        myProc.invert().show();
        myProc.noRed().show();
        myProc.blackAndWhite().show();
        myProc.maximize().show();
        myProc.overlay(new Pic("examplePic2.jpg")).show();
    }

    public ImageProcessor(Pic img) {
        regPic = img;
    }

    public Pic greyscale() {
        Pic tempPic = regPic.deepCopy();
        Pixel[][] tempPxls = regPic.getPixels();
        for (int i = 0; i < regPic.getHeight(); i++) {
            for (int j = 0; j < regPic.getWidth(); j++) {
                int avg = tempPxls[i][j].getRed()
                    + tempPxls[i][j].getGreen()
                    + tempPxls[i][j].getBlue();
                avg /= 3;
                Pixel[][] tmpArr = tempPic.getPixels();
                tmpArr[i][j] = new Pixel(avg, avg, avg, 255);
            }
        }
        return tempPic;
    }

    public Pic invert() {
        Pic tempPic = regPic.deepCopy();
        Pixel[][] tempPxls = regPic.getPixels();
        for (int i = 0; i < regPic.getHeight(); i++) {
            for (int j = 0; j < regPic.getWidth(); j++) {
                Pixel tmpPx = tempPxls[i][j];
                Pixel[][] tmpArr = tempPic.getPixels();
                tmpArr[i][j] = new Pixel(
                    Math.abs(tmpPx.getRed() - 255),
                    Math.abs(tmpPx.getGreen() - 255),
                    Math.abs(tmpPx.getBlue() - 255), 255);
            }
        }
        return tempPic;
    }

    public Pic noRed() {
        Pic tempPic = regPic.deepCopy();
        for (int i = 0; i < regPic.getHeight(); i++) {
            for (int j = 0; j < regPic.getWidth(); j++) {
                tempPic.getPixels()[i][j].setRed(0);
            }
        }
        return tempPic;
    }

    public Pic blackAndWhite() {
        Pic tempPic = regPic.deepCopy();
        Pixel[][] tempPxls = regPic.getPixels();
        for (int i = 0; i < regPic.getHeight(); i++) {
            for (int j = 0; j < regPic.getWidth(); j++) {
                int avg = tempPxls[i][j].getRed()
                    + tempPxls[i][j].getGreen()
                    + tempPxls[i][j].getBlue();
                avg /= 3;
                if (avg > 127) {
                    avg = 255;
                } else {
                    avg = 0;
                }
                Pixel[][] tmpArr = tempPic.getPixels();
                tmpArr[i][j] = new Pixel(avg, avg, avg, 255);
            }
        }
        return tempPic;
    }

    public Pic maximize() {
        Pic tempPic = regPic.deepCopy();
        Pixel[][] tempPxls = regPic.getPixels();
        for (int i = 0; i < regPic.getHeight(); i++) {
            for (int j = 0; j < regPic.getWidth(); j++) {
                int red = tempPxls[i][j].getRed();
                int green = tempPxls[i][j].getGreen();
                int blue = tempPxls[i][j].getBlue();
                if (red > green && red > blue) {
                    green = 0;
                    blue = 0;
                } else if (red > green && red == blue) {
                    green = 0;
                } else if (red == green && red > blue) {
                    blue = 0;
                } else if (blue > green && blue > red) {
                    green = 0;
                    red = 0;
                } else if (blue > green && blue == red) {
                    green = 0;
                } else if (blue == green && blue > red) {
                    red = 0;
                } else if (green > blue && green > red) {
                    blue = 0;
                    red = 0;
                } else if (green > blue && green == red) {
                    blue = 0;
                } else if (green == blue && green > red) {
                    red = 0;
                }
                Pixel[][] tmpArr = tempPic.getPixels();
                tmpArr[i][j] = new Pixel(red, green, blue, 255);
            }
        }
        return tempPic;
    }

    public Pic overlay(Pic other) {
        Pic tempPic = regPic.deepCopy();
        Pic tempPic2 = other.deepCopy();
        Pixel[][] tempPxls = regPic.getPixels();
        Pixel[][] tempPxls2 = other.getPixels();
        for (int i = 0; i < regPic.getHeight(); i++) {
            for (int j = 0; j < regPic.getWidth(); j++) {
                int avgRed = tempPxls[i][j].getRed()
                    + tempPxls2[i][j].getRed();
                int avgGreen = tempPxls[i][j].getGreen()
                    + tempPxls2[i][j].getGreen();
                int avgBlue = tempPxls[i][j].getBlue()
                    + tempPxls2[i][j].getBlue();
                avgRed /= 2;
                avgGreen /= 2;
                avgBlue /= 2;
                Pixel[][] tmpArr = tempPic.getPixels();
                tmpArr[i][j] = new Pixel(avgRed,
                    avgGreen, avgBlue, 255);
            }
        }
        return tempPic;
    }

}