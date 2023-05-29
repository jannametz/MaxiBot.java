package hpi.proj1ct.maxivitaminbot.service;

import hpi.proj1ct.maxivitaminbot.config.BotConfig;
import hpi.proj1ct.maxivitaminbot.model.User;
import hpi.proj1ct.maxivitaminbot.model.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
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
    @Autowired
    private UserRepository userRepository;
    final BotConfig config;
    static final String HELP_TEXT_COMMAND = "This bot is created to know with Vitamins are contained in which products.\n" +
            "You can execute commands from the main menu on the left or by typing command:\n" +
            "Type /start for start and welcome message\n" +
            "Type /mydata to see data story about your self\n" +
            "Type /deletedata to delete you own data\n" +
            "Type /settings here can you set your preferences.\n\n" +
            "If you have any questions, feedback or something is not working\n" +
            " --> contact me jana.metz@stundent.hpi.uni-potsdam.de ";

    public TelegramBot(BotConfig config) {
        this.config = config;
        List <BotCommand> listCommands = new ArrayList<>();
        listCommands.add(new BotCommand("/start","welcome message"));
        listCommands.add(new BotCommand("/mydata","get your data story"));
        listCommands.add(new BotCommand("/deletedata","delete my data"));
        listCommands.add(new BotCommand("/help","Ask for help"));
        listCommands.add(new BotCommand("/settings","set your preferences"));
        try {
            this.execute(new SetMyCommands(listCommands, new BotCommandScopeDefault(),null));
        }
        catch (TelegramApiException e) {
            log.error("Error setting bot command list: " + e.getMessage());
        }
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
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            switch (messageText) {
                case "/start":

                    registerUser(update.getMessage());
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;
                case "/help":
                    sendMessage(chatId, HELP_TEXT_COMMAND);
                    break;
                default:
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

    private void startCommandReceived(long chatId, String name) {
        String answer = "Hi," + name + "!" + "\nМеня зовут Maxi и я помогу тебе узнать пользу интересующего" +
                " витамина и в каких продуктах он находиться!";
        log.info("Replied to user " + name);
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
