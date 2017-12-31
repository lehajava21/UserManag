package com.leha;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.HashMap;

public class UserStorage {


    private final static String fileName = "users.dat";
    private StorageMap storageMap = new StorageMap();

    public boolean addUser(User user) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        if(file == null){
            return false;
        }
        if (!file.exists()) {
            file.createNewFile();
        } else {
            if(file.length() > 0){
                storageMap = loadStorage(file);
                if (storageMap.users.containsKey(user.getUsername())) {
                    return false;
                }
            }
        }
        user.setId(storageMap.users.size()+1);
        storageMap.users.put(user.getUsername(),user);
        saveStorage(file);
        return true;
    }

    public User getUser(String username, String password) throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        if(file == null || !file.exists()){
            return  null;
        }
        storageMap = loadStorage(file);
        if(!storageMap.users.containsKey(username)){
            return null;
        }
        User user = storageMap.users.get(username);
        if(!user.getPassword().equals(password)){
            return null;
        }
        return user;
    }

    private StorageMap loadStorage(File file) throws IOException {
        storageMap.users =  new ObjectMapper()
                    .readValue(file, new TypeReference<HashMap<String,User>>(){});
        return storageMap;
    }

    private void saveStorage(File file) throws IOException {
        FileUtils.write(file,new ObjectMapper().writeValueAsString(storageMap.users));
    }

}
