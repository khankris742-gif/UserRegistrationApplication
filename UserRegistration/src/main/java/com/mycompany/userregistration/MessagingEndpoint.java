/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.userregistration;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.*;





@ServerEndpoint("/message")
public class MessagingEndpoint {
    
    
    
    private static final Set<Session> sessions = new CopyOnWriteArraySet<>();
    
    @OnOpen
    public void onOpen(Session session){
        sessions.add(session);
        
        System.out.println("Connected: " + session.getId());
    }
    @OnClose
    private void onClose(Session session){
        sessions.remove(session);
        
        System.out.println("Disconnected: " + session.getId());
    } 
    @OnMessage
    public void broadcastMessage(String message, Session sender) throws IOException{
        System.out.println("Message recieved: " + message);
        for(Session session : sessions){
            if (session.isOpen()){
                session.getBasicRemote().sendText(message);
            }
        }
    }
    
    @Resource(lookup = "jms/churchConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    public void recieveJMSNotification(){
        try{
            Connection connection = connectionFactory.createConnection();
            javax.jms.Session jmsSession = connection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
            javax.jms.Queue queue = (javax.jms.Queue) new javax.naming.InitialContext().lookup("jms/churchNotificationQueue");
            
            MessageConsumer consumer = jmsSession.createConsumer(queue);
            consumer.setMessageListener(new MessageListener(){
            @Override
            public void onMessage(Message message){
                try {
                    if( message instanceof TextMessage){
                        String notification = ((TextMessage)message).getText();
                        broadcastToWebSockets(notification);
                    }
                }catch(JMSException e){
                    e.printStackTrace();
                } catch (IOException ex) {
                    Logger.getLogger(MessagingEndpoint.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
            connection.start();
        }catch(Exception e){
            
            e.printStackTrace();
        }
            
        
        
            
                   
    
    }
    
    private void broadcastToWebSockets(String message) throws IOException {
        for(Session session : sessions){
            if(session.isOpen()){
                session.getBasicRemote().sendText(message);
            }
        }
    }
}
