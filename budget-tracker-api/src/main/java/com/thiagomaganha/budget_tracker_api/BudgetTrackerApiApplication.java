package com.thiagomaganha.budget_tracker_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class BudgetTrackerApiApplication {

	public static void main(String[] args) {
		loadDotEnv();
		SpringApplication.run(BudgetTrackerApiApplication.class, args);
	}

	private static void loadDotEnv() {
		File envFile = new File(".env");
		if (envFile.exists()) {
			Properties props = new Properties();
			try (FileInputStream fis = new FileInputStream(envFile)) {
				props.load(fis);
				props.forEach((key, value) -> {
					System.setProperty(key.toString(), value.toString());
					System.out.println("Loaded: " + key + "=" + value);
				});
				System.out.println("✅ .env file loaded successfully");
			} catch (IOException e) {
				System.err.println("❌ Error loading .env file: " + e.getMessage());
			}
		} else {
			System.out.println("⚠️ .env file not found in project root");
		}
	}

}
