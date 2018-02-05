package cn.hotol.bp.dingding;

import com.dingtalk.chatbot.DingtalkChatbotClient;
import com.dingtalk.chatbot.SendResult;
import com.dingtalk.chatbot.message.Message;
import com.dingtalk.chatbot.message.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MyDing {
    private final static Logger logger = LoggerFactory.getLogger(MyDing.class);
    private String hook;
    private DingtalkChatbotClient client;

    //发送钉钉消息
    public String sendTextMessage(String message){
        try {
            TextMessage textMessage = new TextMessage(message);
            SendResult result = client.send(hook,textMessage);
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("【钉钉消息发送】错误原因："+e.getMessage());
        }
        return null;
    }

    public String sendMessage(Message message){
        try {
            SendResult result = client.send(hook,message);
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("【钉钉消息发送】错误原因："+e.getMessage());
        }
        return null;
    }

    public void init(){
        logger.info("钉钉初始化");
        client = new DingtalkChatbotClient();
    }

    public void destroy(){
    logger.info("钉钉销毁");
    }

    public String getHook() {
        return hook;
    }

    public void setHook(String hook) {
        this.hook = hook;
    }

    public DingtalkChatbotClient getClient() {
        return client;
    }

    public void setClient(DingtalkChatbotClient client) {
        this.client = client;
    }
}
