package com.java;

import java.io.FileOutputStream;
import java.io.IOException;

public class TicTacToeSave {

    public static void saveField(int[] values, String filename) throws IOException {
        if (values.length != 9) {
            throw new IllegalArgumentException("Должно быть ровно 9 значений");
        }

        int packed = 0;
        for (int i = 0; i < 9; i++) {
            int v = values[i];
            if (v < 0 || v > 3) {
                throw new IllegalArgumentException("Значения должны быть в диапазоне 0..3");
            }

            packed |= (v & 0b11) << (2 * i);
        }

        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(packed & 0xFF);
            fos.write((packed >> 8) & 0xFF);
            fos.write((packed >> 16) & 0xFF);
        }
    }
}

