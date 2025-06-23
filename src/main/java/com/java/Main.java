package com.java;

import java.io.IOException;

import static com.java.BackupFiles.backupFiles;
import static com.java.TicTacToeSave.saveField;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            backupFiles(".");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] field = {
                1, 2, 0,
                0, 1, 2,
                3, 0, 1 };

        saveField(field, "field.dat");
        System.out.println("Файл записан");
    }
}