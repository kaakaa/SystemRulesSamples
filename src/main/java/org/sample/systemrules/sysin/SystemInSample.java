package org.sample.systemrules.sysin;

import java.util.Scanner;

/**
 * Created by kaakaa_hoe on 2014/06/24.
 */
public class SystemInSample {
    public static int summerizeFromSystemInput(){
        Scanner scanner = new Scanner(System.in);
        int firstInt = scanner.nextInt();
        int secondInt = scanner.nextInt();
        return firstInt + secondInt;
    }
}
