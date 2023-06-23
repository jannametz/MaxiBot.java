package hpi.proj1ct.maxivitaminbot.service;

import hpi.proj1ct.maxivitaminbot.config.BotConfig;
import hpi.proj1ct.maxivitaminbot.repository.SubscriptionRepository;
import hpi.proj1ct.maxivitaminbot.model.User;
import hpi.proj1ct.maxivitaminbot.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jana Metz on 20.05.23
 */
@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {
    private final SubscriptionRepository subscriptionRepository;
    @Autowired
    private UserRepository userRepository;
    final BotConfig config;
    static final String HELP_TEXT_COMMAND = "This bot is created to know with Vitamins are contained in which products.\n" +
            "You can execute commands from the main menu on the left or by typing command:\n" +
            "Type /start for start and welcome message\n\n" +
            "Type /subscription user can subscription\n\n" +
            "Type /help say this massage again\n\n" +
            "Type /settings here can you set your preferences.\n\n" +
            "If you have any questions, feedback or something is not working\n\n" +
            " --> contact me jana.metz@stundent.hpi.uni-potsdam.de ";
    static final String SUBSCRIPTION_COMMAND = "Subscription articles about vitamin and health.\n" +
            "Subscribe to know the latest info and interesting scientific data";
    static final String VITAMIN_COMMAND = "Please, write the vitamin yor are interested in";

    public TelegramBot(BotConfig config,
                       SubscriptionRepository subscriptionRepository) {
        this.config = config;
        List <BotCommand> listofCommands = new ArrayList<>();
        listofCommands.add(new BotCommand("/start","get welcome message"));
        listofCommands.add(new BotCommand("/settings","set your preferences"));
        listofCommands.add(new BotCommand("/subscription","Info for subscription "));
        listofCommands.add(new BotCommand("/help","Information how to use this bot."));
        listofCommands.add(new BotCommand("/vitamin","Information about vitamin."));

        try {
            this.execute(new SetMyCommands(listofCommands, new BotCommandScopeDefault(),null));
        }
        catch (TelegramApiException e) {
            log.error("Error setting bot command list: " + e.getMessage());
        }
       this.subscriptionRepository = subscriptionRepository;

    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public void onUpdateReceived(Update update) {
        //We check if the update has the message and the message..
        if (update.hasMessage() && update.getMessage().hasText()) {
            //Set variables
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            switch (messageText) {
                case "/start" ->
                   // registerUser(update.getMessage());
                    showStart(chatId, update.getMessage().getChat().getFirstName());
                case "/help" ->
                    sendMessage(chatId, HELP_TEXT_COMMAND);
                case "/subscription" ->
                    sendMessage(chatId, SUBSCRIPTION_COMMAND);
                case "/vitamin" ->
                    sendMessage(chatId, VITAMIN_COMMAND);
                default ->
                    sendMessage(chatId, "Sorry, command not recognized!");
            }
        }

    }

    private void registerUser(Message message) {
        if(userRepository.findById(message.getChatId()).isEmpty()){
            var chatId = message.getChatId();
            var chat  = message.getChat();
            User user = new User();
            user.setChatId(chatId);
            user.setFirstName(chat.getFirstName());
            user.setLastName(chat.getLastName());
            user.setUsername(chat.getUserName());
            user.setRegisteredAt(new Timestamp(System.currentTimeMillis()));
            userRepository.save(user);
            log.info("user saved: " + user);
        }
    }

    private void showStart(long chatId, String name) {
        String answer = "Hi," + name + "!" + "\n My name is Maxi, and I will " +
                "\n help you to find out, using the content of interest, " +
                "\n and what products it is in!";
        //log.info("Replied to user " + name);
        sendMessage(chatId, answer);
    }

    private void sendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        try {
            execute(message);
        } catch (TelegramApiException e) {
           throw new RuntimeException(e);
          // log.error("Error occurred: " + e.getMessage());
        }
    }
}
