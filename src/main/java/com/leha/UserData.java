package com.leha;

import java.util.Scanner;

public class UserData {

    public static void main(String[] args){

        String username;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Enter username:");
        }while ((username = scanner.nextLine().trim()).isEmpty());
        String password;
        do{
            System.out.println("Enter password:");
        }while ((password = scanner.nextLine().trim()).isEmpty());
        UserStorage userStorage = new UserStorage();
        User user = null;
        try {
            user = userStorage.getUser(username, password);
        } catch (Exception e) {
            System.out.println("User not found");
            return;
        }
        if(user == null){
            System.out.println("User not found");
            return;
        }
        System.out.println("Username:  " + user.getUsername());
        System.out.println("Password:  " + user.getPassword());
        System.out.println("Firstname: " + user.getFirstname());
        System.out.println("Lastname:  " + user.getLastname());
        System.out.println("Email:     " + user.getEmail());
        System.out.println("Age:       " + user.getAge());
    }
}
