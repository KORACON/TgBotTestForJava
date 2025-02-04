import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class Bot extends TelegramLongPollingBot {
    public InlineKeyboardButton sendForStartTest = InlineKeyboardButton.builder()
            .text("Для начала теста нажмите: ")
            .callbackData("start test")
            .build();

    public InlineKeyboardMarkup keyboardForSendStartTest = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(sendForStartTest))
            .build();
    @Override
    public String getBotUsername() {
        return "@bendeliani_unique_tg_bot";
    }

    @Override
    public String getBotToken() {
        return "7688920765:AAEBaMMOGH6EcKWECoYmuO0zu-ghAgT0PMk";
    }

    @Override
    public void onUpdateReceived(Update update) {
        sendMenu(update.getMessage().getText(), update);
    }
    public void sendMenu(String messageText,Update update) {
        if (messageText.equals("/start_test")) {
            Long who = update.getMessage().getFrom().getId();

            String txt = "Используйте кнопку ниже чтобы начать текст: ";
            InlineKeyboardMarkup keyboard = keyboardForSendStartTest;

            SendMessage sendMessage = SendMessage.builder()
                    .chatId(who.toString())
                    .text(txt)
                    .replyMarkup(keyboard)
                    .build();
            try {
                execute(sendMessage);
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
    }
}
