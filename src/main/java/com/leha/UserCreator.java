package com.leha;

import validators.Validator;

import java.util.Scanner;

public class UserCreator {

    public static void main(String[] args){

        User user = new User();
        Scanner scanner = new Scanner(System.in);
        String inp = null;
        try{
            do{
                System.out.println("Enter username:");
                inp = scanner.nextLine();
                user.setUsername(inp);
            }while (!Validator.validate(user));
            do{
                System.out.println("Set password:");
                inp = scanner.nextLine();
                user.setPassword(inp);
            }while (!Validator.validate(user));
            do{
                System.out.println("Enter first name:");
                inp = scanner.nextLine();
                user.setFirstname(inp);
            }while (!Validator.validate(user));
            do{
                System.out.println("Enter last name:");
                inp = scanner.nextLine();
                user.setLastname(inp);
            }while (!Validator.validate(user));
            do{
                System.out.println("Enter email:");
                inp = scanner.nextLine();
                user.setEmail(inp);
            }while (!Validator.validate(user));
            do{
                System.out.println("Enter age:");
                inp = scanner.nextLine();
                user.setAge(inp);
            }while (!Validator.validate(user));
            UserStorage userStorage = new UserStorage();
            if(!userStorage.addUser(user)){
                System.out.println("Can not add new user");
            }
        }catch (Exception e){
            System.out.println("Can not add new user");
            return;
        }
    }
}
