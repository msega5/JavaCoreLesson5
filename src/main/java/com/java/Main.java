package com.java;

import java.io.IOException;

import static com.java.BackupFiles.backupFiles;

public class Main {
    public static void main(String[] args) {
        try {
            backupFiles(".");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}