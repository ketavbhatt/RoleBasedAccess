package com.role.access.service;

import com.role.access.model.Resources;
import com.role.access.model.Role;
import com.role.access.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AdminService extends  AccessControl {
    Scanner scanner = new Scanner(System.in);
    public AdminService () {

    }

    public AdminService(HashMap<String,User> hashMap) {
        List<String> actionType = new ArrayList<String>();
        actionType.add("READ");
        Resources resources = new Resources("A",actionType);
        List<Resources> resourcesList = new ArrayList<Resources>();
        resourcesList.add(resources);
        Role adminRole = new Role("admin",resourcesList);
        List<Role> roleList = new ArrayList<Role>();
        roleList.add(adminRole);
        User adminUser = new User("admin",roleList);
        hashMap.put("admin",adminUser);
        adminMain(hashMap);
    }

    public void adminMain(HashMap<String, User> hashMap) {
        String option = "";
        do {
            System.out.println("hi! you are logged in as admin");
            System.out.println("press 1 for login as another user");
            System.out.println("press 2 for create user");
            System.out.println("press 3 for edit role");
            System.out.println("press * for exit");
            option = scanner.nextLine();
            switch (option) {
                case "1":
                    loginDifferentUser(hashMap);
                    break;
                case "2":
                    createUser(hashMap);
                    break;
                case "3":
                    editRole(hashMap);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (!option.equalsIgnoreCase("*"));

    }

    public User createUser(HashMap<String,User> hashMap) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Enter New UserName: ");
            String userName = scanner.nextLine();
            System.out.println("Please Enter Resource name and their action type space separated eg. A READ press * to exit:");
            List<Resources> resourcesList = new ArrayList<Resources>();
            String accessType = "";
            do {
                accessType = scanner.nextLine();
                if (!accessType.equalsIgnoreCase("*")) {
                    String resourceName = accessType.split(" ")[0];
                    String actionType = accessType.split(" ")[1];
                    List<String> actionTypeList = new ArrayList<>();
                    actionTypeList.add(actionType);
                    Resources resources = new Resources(resourceName, actionTypeList);
                    resourcesList.add(resources);
                }
                System.out.println("Press Enter for more entries to exit press * ");
            } while (!accessType.equalsIgnoreCase("*"));

            Role role = new Role(userName, resourcesList);
            List<Role> roleList = new ArrayList<Role>();
            roleList.add(role);
            User user = new User(userName, roleList);
            hashMap.put(userName, user);
            System.out.println("User: " + userName + " created successfully!");
            return user;
        } catch (Exception e) {
            System.out.println("Exception occurred!");
            return null;
        }
    }

    public void editRole(HashMap<String,User> hashMap) {
        try {
            System.out.println("Enter userName whose role is to be edited: ");
            String userName = scanner.nextLine();
            User user = hashMap.get(userName);
            List<Role> roleList = user.getRole();
            System.out.println("Current Role: ");
            for (Role i : roleList) {
                System.out.println("Role Name: " + i.roleName);

                for (Resources j : i.resources) {
                    System.out.println("Resource name and action type: " + j.resourceName + " " + j.actionType.toString());
                }
            }
            System.out.println("Please enter resource name, old action type and new action type to be edited for eg. A READ WRITE press * to exit: ");
            String roleName = scanner.nextLine();
            String resource = roleName.split(" ")[0];
            String oldActionType = roleName.split(" ")[1];
            String newActionType = roleName.split(" ")[2];
            for (Role i : user.getRole()) {
                for (Resources j : i.getResources()) {
                    if (j.resourceName.equalsIgnoreCase(resource)) {
                        j.getActionType().add(newActionType);
                        j.getActionType().remove(oldActionType);
                    }
                }
            }
            System.out.println("Edited role successfully!");
        } catch (Exception e) {
            System.out.println("Exception occurred!");
        }

    }
}
