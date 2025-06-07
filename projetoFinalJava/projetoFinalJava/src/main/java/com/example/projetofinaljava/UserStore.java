package com.example.projetofinaljava;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserStore {
    private static final String FILE_NAME = "users.dat";
    private List<User> users;

    public UserStore() {
        users = loadUsers();
    }

    public boolean addUser(User user) {
        if (getUser(user.getUsername()) != null) return false;
        users.add(user);
        saveUsers();
        return true;
    }

    public User getUser(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) return u;
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean removeUser(User user) {
        boolean removed = users.remove(user);
        if (removed) saveUsers();
        return removed;
    }

    public void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private List<User> loadUsers() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<User>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.dat"))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                for (Object o : (List<?>) obj) {
                    if (o instanceof User) {
                        users.add((User) o);
                    }
                }
            }
        } catch (Exception e) {
            // File may not exist yet, return empty list
        }
        return users;
    }
}