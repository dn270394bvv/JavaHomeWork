package com.pb.bazeluk.hw15;

import java.util.LinkedList;
import java.util.List;

public class Chat {

    private final List<Message> massages= new LinkedList<>();

    public Chat (){
        massages.add(new Message("Admin","Новый чат начался!\n"));
    }

    public List<Message> getMessages() {
        return massages;
    }

    public void setMessages(Message message) {
        this.massages.add(message);
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("chat{");
        for (Message m:massages){
            s.append(m.getTime().toString()+" - "+ m.getUser()+": "+m.getMessage()+'\n');
        }
        s.append("}");
        return s.toString();
    }
}
