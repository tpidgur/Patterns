package _11Mediator_2;

import java.util.ArrayList;
import java.util.List;

/**
 * проверить код
 */
public class MediatorApp {
    public static void main(String[] args) {
        TextChat textChat = new TextChat();

        User admin = new Admin(textChat,"Ivan Ivanovich");
        User user1 = new SimpleUser(textChat,"Vania");
        User user2 = new SimpleUser(textChat,"Ira");
        User user3 = new SimpleUser(textChat,"Kate");
        user2.setEnable(false);

        textChat.setAdmin(admin);
        textChat.addUser(user1);
        textChat.addUser(user2);
        textChat.addUser(user3);

        admin.sendMessage("Привет");

    }
}

abstract class User {
    Chat chat;
    String name;
    boolean isEnable = true;

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public User(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    abstract void getMessage(String message);

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}

interface Chat {
    void sendMessage(String message, User user);
}


class Admin extends User {
    Chat chat;

    public Admin(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Администратор '" + getName() + " получает сообщение " + message + "'");
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }


}

class SimpleUser extends User {


    public SimpleUser(Chat chat, String name) {
        super(chat, name);
        this.chat = chat;
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Пользователь '" + getName() + " получает сообщение " + message + "'");
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }
}

class TextChat implements Chat {
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        if (admin != null && admin instanceof Admin) {
            this.admin = admin;
        } else {
            throw new RuntimeException("Не хватает прав");
        }
    }

    public void addUser(User u) {
        if (admin == null) {
            throw new RuntimeException("В чате нет админа");
        }
        if (u instanceof SimpleUser) {
            users.add(u);
        } else {
            throw new RuntimeException("Админ не может входить в другой чат");
        }
    }

    @Override
    public void sendMessage(String message, User user) {
        if (user instanceof Admin) {
            for (User u : users) {
                u.getMessage(user.getName() + ": " + message);
            }
        }
        if (user instanceof SimpleUser) {
            for (User u : users) {
                if (u != user && u.isEnable())
                    u.getMessage(user.getName() + ": " + message);
            }
            if (admin.isEnable())
                admin.getMessage(user.getName() + ": " + message);
        }

        admin.getMessage(message);

    }
}
