package model;

import java.util.Random;

/**
 * DataModel class for COMP 305 GUI Demo
 */
public class DataModel {
    public static String[][] getData() {
        // Number of columns
        int NCOLS = 4;
        // Number of rows
        Random rand = new Random();
        int NROWS = 10 + rand.nextInt(20); // 10 to 30 rows
        // Create data
        String[][] data;
        data = new String[NROWS][NCOLS];
        for (int row = 0; row < NROWS; row++) {
            for (int col = 0; col < NCOLS; col++) {
                data[row][col] = String.valueOf(rand.nextInt(1000));
            }
        }
        return data;
    }

    public static String[] getInfo() {
        String[] info = { "COMP 305", "GUI Demo", "Tori Thompson", "Learning Java" };
        return info;
    }
}
