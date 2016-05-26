package _17Chain;

/**
 * дослушать по оптимизации кода
 */
public class ChainApp {
    public static void main(String[] args) {
        SMSLogger logger0 = new SMSLogger(Level.ERROR);
        FileLogger logger1 = new FileLogger(Level.DEBUG);
        EmailLogger logger2 = new EmailLogger(Level.INFO);

        logger0.setNext(logger1);
        logger1.setNext(logger2);

        logger0.writeMessage("Everything is ok", Level.INFO);
        logger0.writeMessage("Debugging", Level.DEBUG);
        logger0.writeMessage("Failures", Level.ERROR);
    }
}

class Level {
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

interface Logger {
    void writeMessage(String message, int level);
}

class SMSLogger implements Logger {
    int priority;
    Logger next;

    public SMSLogger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    @Override
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("SMS: " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
}

class FileLogger implements Logger {
    int priority;
    Logger next;

    public FileLogger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    @Override
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("Записываем в файл: " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
}

class EmailLogger implements Logger {
    int priority;
    Logger next;

    public EmailLogger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    @Override
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("E-mail message: " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
}