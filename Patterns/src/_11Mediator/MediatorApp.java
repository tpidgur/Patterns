package _11Mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Зая on 26.05.2016.
 */
public class MediatorApp {
    public static void main(String[] args) {
TextChat textChat=new TextChat();
        User admin =new Admin(textChat);
        User user1 =new SimpleUser(textChat);
        User user2 =new SimpleUser(textChat);
        textChat.setAdmin(admin);
        textChat.addUser(user1);
        textChat.addUser(user2);

        user1.sendMessage("Привет, я пользователь");
       admin.sendMessage("Админ зашел в чат");
    }
}
interface User{
    void sendMessage(String message);
    void getMessage(String message);
}

class Admin implements User {
    Chat chat;

    public Admin(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Администратор получает сообщение '" + message + "'");
    }
}
class SimpleUser implements User{
    Chat chat;

    public SimpleUser(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message,this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Пользователь получает сообщение '"+message+"'");
    }
}
interface Chat{
    void sendMessage(String message, User user);
}
class TextChat implements Chat{
    User admin;
    List<User> users=new ArrayList<>();
    public void setAdmin(User admin){
        this.admin=admin;
    }
    public void addUser(User u){
        users.add(u);
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u:  users){
            u.getMessage(message);
        }
        admin.getMessage(message);

    }
}