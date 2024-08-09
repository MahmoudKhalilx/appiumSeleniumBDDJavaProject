package Android.SauceLabs.resources.utilities.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmulatorManager {





    public static void startEmulator() throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder(
                ConfigReader.getProperty("EmulatorPath"), "-avd", ConfigReader.getProperty("avdName"));
        builder.redirectErrorStream(true);
        Process process = builder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            if (line.contains("boot completed")||(line.contains("Increasing screen off timeout, logcat buffer size to 2M.")||(line.contains("Successfully loaded snapshot 'default_boot'")))) {
                break;
            }
            // process.waitFor();
        }
//        // Poll for device readiness
//        boolean isDeviceReady = false;
//        while (!isDeviceReady) {
//            ProcessBuilder adbBuilder = new ProcessBuilder(
//                    ADB_PATH, "shell", "getprop", "sys.boot_completed");
//            adbBuilder.redirectErrorStream(true);
//            Process adbProcess = adbBuilder.start();
//
//            BufferedReader adbReader = new BufferedReader(new InputStreamReader(adbProcess.getInputStream()));
//            String adbLine = adbReader.readLine();
//            if (adbLine != null && adbLine.trim().equals("1")) {
//                isDeviceReady = true;
//            }
//
//            adbProcess.waitFor();
//            if (!isDeviceReady) {
//                Thread.sleep(1000); // Wait for 1 second before retrying
//            }
        //}
        System.out.println("Emulator started successfully.");
    }


    public static void stopEmulator() throws IOException, InterruptedException {
        // Stop the emulator
        ProcessBuilder adbBuilder = new ProcessBuilder(
                ConfigReader.getProperty("adbPath"), "emu", "kill");
        adbBuilder.redirectErrorStream(true);
        Process adbProcess = adbBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(adbProcess.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        adbProcess.waitFor();
        System.out.println("Emulator stopped successfully.");
    }

    public void startEmulator1() {
        try {
            startEmulator();
            System.out.println("Emulator started successfully.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopEmulator1() {
        try {
            stopEmulator();
            System.out.println("Emulator started successfully.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

