package com.role.access.service;

import com.role.access.model.User;

import java.util.HashMap;
import java.util.Scanner;

public abstract class AccessControl {
    Scanner scanner = new Scanner(System.in);
    public void loginDifferentUser(HashMap<String,User> hashMap) {
        try {
            System.out.println("Following is the user list please select appropriate username: ");
            for (String i : hashMap.keySet()) {
                System.out.println("Use Name: " + i);
            }
            String userName = scanner.nextLine();
            if (userName.equalsIgnoreCase("admin")) {
                AdminService adminService = new AdminService();
                adminService.adminMain(hashMap);
            } else {
                NormalUserService normalUserService = new NormalUserService();
                normalUserService.normalUserMain(hashMap, userName);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred!");
        }

    }
}
