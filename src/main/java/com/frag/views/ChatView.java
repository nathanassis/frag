package com.frag.views;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.input.KeyCode;

import com.frag.controllers.ChatController;

public class ChatView {

    @FXML
    private VBox chatBox;

    @FXML
    private TextField messageField;

    @FXML
    private ScrollPane messagesPane;

    @FXML
    public void initialize() {
        messageField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleSendMessage();
            }
        });
    }

    @FXML
    private void addMessage(String message) {
        Label messageLabel = new Label(message);
        messageLabel.setFont(new Font(14));
        messageLabel.setWrapText(true);
        messageLabel.setStyle("-fx-background-color: #DCF8C6; -fx-padding: 8px; -fx-background-radius: 10px;");
        messageLabel.setMaxWidth(300);

        VBox container = new VBox(messageLabel);
        container.setAlignment(Pos.CENTER_RIGHT);

        chatBox.getChildren().add(container);

        messageField.clear();
    }

    @FXML
    private void handleSendMessage() {
        String message = messageField.getText().trim();

        if (!message.isEmpty()) {
            addMessage(message);
            ChatController.talk(message);
            // String responseMessage = sendMessage(message);
            // addMessage(responseMessage);
        }
    }
}
