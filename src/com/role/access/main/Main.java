package com.role.access.main;

import com.role.access.model.User;
import com.role.access.service.AdminService;
import java.util.HashMap;

public class Main {

    public static HashMap<String,User> hashMap = new HashMap<>();

    public static void main(String[] args) {

        // initializing object for admin user
        AdminService adminService = new AdminService(hashMap);


    }
}
