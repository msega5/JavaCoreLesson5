package com.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class BackupFiles {

    public static void backupFiles(String sourceDirPath) throws IOException {

        File sourceDir = new File(sourceDirPath);
        if (!sourceDir.isDirectory()) {
            throw new IllegalArgumentException("Указанный путь не является директорией");
        }

        File backupDir = new File(sourceDir, "backup");
        if (!backupDir.exists()) {
            boolean created = backupDir.mkdir();
            if (!created) {
                throw new IOException("Не удалось создать папку backup");
            }
        }

        File[] files = sourceDir.listFiles();
        if (files == null) {
            System.out.println("Директория пуста или недоступна");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                Path sourcePath = file.toPath();
                Path targetPath = new File(backupDir, file.getName()).toPath();
                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
            }
        }
        System.out.println("Резервное копирование завершено.");
    }
}
