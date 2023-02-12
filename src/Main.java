import java.util.Scanner;

enum MessageType {
    // Declare an enum named MessageType that defines,
    // the type of messages in a chat application
    TEXT, // A message that contains text
    EMOTE, // A message that contains an emoticon
    COMMAND // A message that contains a command

}

interface ChatMessage {
    // Declare an interface named ChatMessage that defines the behavior of a chat message
    MessageType getMessageType();
    // Declaring a method getMessageType that returns a MessageType
    String getMessage();
    // Declaring a method getMessage that returns a String
}

abstract class AbstractChatMessage implements ChatMessage {
    // Declare an abstract class named AbstractChatMessage,
    // that implements the ChatMessage interface
    private final MessageType messageType;
    // A private final variable named messageType,
    // that stores the type of the chat message
    private final String message;
    // A private final variable named message that stores the text of the chat message
    AbstractChatMessage(MessageType messageType, String message) {
        this.messageType = messageType;
        this.message = message;
        // A constructor that takes two parameters,
        // messageType and message, and initializes the messageType and message variables
    }

    @Override
    public MessageType getMessageType() {
        return messageType;
        // An implementation of the getMessageType method,
        // that returns the messageType variable
    }

    @Override
    public String getMessage() {
        return message;
        // An implementation of the getMessage method,
        // that returns the message variable
    }
}

class TextMessage extends AbstractChatMessage {
    // Class TextMessage definition which inherited AbstractChatMessage class
    TextMessage(String message) {
        // Constructor for TextMessage class which takes a message as a parameter
        super(MessageType.TEXT, message);
        // Invokes the constructor of the,
        // super class (AbstractChatMessage) with MessageType.TEXT and the message as arguments

    }
}

class User2 extends AbstractChatMessage {
    // Class EmoteMessage definition which inherited AbstractChatMessage class
    User2(String message) {
        // Constructor for EmoteMessage class which takes a message as a parameter
        super(MessageType.EMOTE, message);
        // Invokes the constructor of the super
        // class (AbstractChatMessage) with MessageType.EMOTE and the message as arguments
    }
}

class User1 extends AbstractChatMessage {
    User1(String message) {
        // constructor to create a CommandMessage object
        super(MessageType.COMMAND, message);
        // call the super class constructor with MessageType.COMMAND and the message
        /*

         Class CommandMessage
         This class is a sub-class of AbstractChatMessage and implements a specific type of chat message,
         the CommandMessage.
         @param message a string representing the message of the command type
         The constructor of this class calls its super class constructor,
         passing the message type MessageType.COMMAND and the message as parameters.
         */
    }
}

class ChatRoom {
    void sendMessage(ChatMessage message) {
        // method to send a message to the chat room
        switch (message.getMessageType()) {
            // switch on the type of message being sent
            case TEXT:
                System.out.println("[Text Message]: " + message.getMessage());
                break;
            // print the message with "[Text Message]: " prefix
            case EMOTE:
                System.out.println("[User 2 Msg]: " + message.getMessage());
                break;
            // print the message with "[Emote Message]: " prefix
            case COMMAND:
                System.out.println("[User 1 Msg]: " + message.getMessage());
                break;
            // print the message with "[Command Message]: " prefix
            default:
                throw new IllegalArgumentException("Invalid message type");
                // if the message type is not one of the defined types, throw an exception

                /*

                 Class ChatRoom
                 This class represents a chat room where messages can be sent.
                 @method sendMessage
                 This method takes a ChatMessage object as a parameter and processes the message based on
                 its type.
                 The method uses a switch case to determine the message type and prints a message
                 with a specific format, depending on the message type.
                 If the message type is not recognized, an IllegalArgumentException is
                  thrown with the message "Invalid message type".
                 */
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Creating an instance of Scanner class to read input from user
        ChatRoom chatRoom = new ChatRoom();
        // Creating an instance of ChatRoom class

        while (true) {
            // Running an infinite loop to keep taking user input
            System.out.print("Enter your message: ");
            // Printing a message to the console to ask user for input
            String input = scanner.nextLine();
            // Reading the user input as a string
            ChatMessage message;
            // Initializing a variable message of type ChatMessage
            if (input.startsWith("/")) {
                message = new User1(input);
                // Checking if the user input starts with "/"
                // If the input starts with "/", create an instance of CommandMessage
            } else if (input.startsWith(":")) {
                // Checking if the user input starts with ":"
                message = new User2(input);
                // If the input starts with ":", create an instance of EmoteMessage
            } else {

                message = new TextMessage(input);
                // If the user input does not start with "/" or ":", create an instance of TextMessage
            }

            try {
                chatRoom.sendMessage(message);
                // Surrounding the chatRoom.sendMessage(message) method with a try-catch block
            } catch (IllegalArgumentException e) {
                // Catching an IllegalArgumentException
                System.out.println("Error: " + e.getMessage());
                // Printing the error message to the console
            }
        }
    }
}
/* we have defined an enum named MessageType to represent the different types
of messages that can be sent in the chat room.

Next, we have defined an interface ChatMessage with two methods getMessageType and getMessage.

We have also created an abstract class AbstractChatMessage that
implements the ChatMessage interface and provides a basic implementation for the methods
getMessageType and getMessage.

Then, we have defined three classes TextMessage, EmoteMessage, and `Command Messagethat
extend theAbstractChatMessage` class and provide specific implementations for each type of message.

Finally, we have defined a class ChatRoom that has a method sendMessage to receive and
handle messages sent to the chat room.

In the main method, we create an instance of the ChatRoom class and use a Scanner
to continuously read input from the user. Based on the input, we create a specific
type of ChatMessage (TextMessage, EmoteMessage, or CommandMessage) and send it to the chat
 room using the sendMessage method.

The sendMessage method in the ChatRoom class uses a switch statement to handle the
different types of messages and print appropriate output to the console.
If an invalid message type is received, it throws an IllegalArgumentException with a descriptive error message.

The try-catch block in the main method is used to catch the IllegalArgumentException
and print the error message to the console, in case an invalid message type is sent to the chat room.
 The code is a basic implementation of a chat application using Java. It includes classes and interfaces for handling different types of messages that can be sent in a chat room, such as text messages, emoticon messages, and command messages.

The MessageType enum defines the possible types of messages that can be sent in the chat room,
including TEXT, EMOTE, and COMMAND.

The ChatMessage interface defines the behavior of a chat message and requires
the implementation of two methods: getMessageType and getMessage.

The AbstractChatMessage class implements the ChatMessage interface and
provides a basic implementation of a chat message. It contains two private final variables,
messageType and message, that store the type of the message and its text, respectively.
 The class also provides implementations of the methods defined in the ChatMessage interface.

The TextMessage, EmoteMessage, and CommandMessage classes extend the AbstractChatMessage
 class and provide specific implementations for each type of message. Each class has a constructor
  that takes a message as a parameter and invokes the constructor of the superclass with
   the appropriate message type and message.

The ChatRoom class represents a chat room where messages can be sent.
It contains a method sendMessage that takes a ChatMessage object as a parameter
 and processes the message based on its type. The method uses a switch statement to
  determine the message type and prints a message with a specific format, depending on the message type.

The Main class is the entry point of the program and creates an instance of the Scanner
 class to read input from the user, and an instance of the ChatRoom class.
  It then enters an infinite loop to keep taking user input and sending messages to the chat room.*/