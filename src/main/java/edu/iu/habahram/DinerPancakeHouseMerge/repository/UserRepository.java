package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Repository
public class UserRepository {

    private final Path databasePath = Paths.get("data/customers.txt");

    public UserRepository() {
    }

    private void setupDatabase() {
        Path databaseDir = databasePath.getParent();
        if (databaseDir != null && !databaseDir.toFile().exists()) {
            boolean dirCreated = databaseDir.toFile().mkdirs();
            if (dirCreated) {
                System.out.println("Database directory created at: " + databaseDir);
            } else {
                System.out.println("Database directory already exists at: " + databaseDir);
            }
        }
        if (!databasePath.toFile().exists()) {
            try {
                boolean newFile = databasePath.toFile().createNewFile();
                if (newFile) {
                    System.out.println("Database file created at: " + databasePath);
                } else {
                    System.out.println("Database file already exists at: " + databasePath);
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to create database file", e);
            }
        }
    }

    public void save(String username, String password, String email) {
        setupDatabase();
        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(
                new java.io.FileWriter(databasePath.toFile(), true))) {
            writer.write(username + "," + password + "," + email);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to save user data", e);
        }
    }
}
