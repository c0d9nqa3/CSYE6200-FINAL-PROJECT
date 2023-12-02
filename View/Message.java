package view;


import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Message {

    public static VBox getView() {
        // 创建主VBox布局
        VBox messagesLayout = new VBox(10);
        messagesLayout.setPadding(new Insets(20));

        // 创建用于显示消息的ListView
        ListView<String> messageList = new ListView<>();
        messageList.getItems().addAll("Message 1", "Message 2", "Message 3"); // 示例消息，应替换为实际消息

        // 创建文本来显示选中的消息的详细信息
        Text messageDetails = new Text("Select a message to view its details.");

        // 将ListView和Text添加到VBox布局中
        messagesLayout.getChildren().addAll(messageList, messageDetails);

        // 添加事件处理以更新消息详情
        messageList.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            // 这里可以填充实际的消息内容
            messageDetails.setText("Details for " + newVal);
        });

        return messagesLayout;
    }
}



