package com.util.rabbit;

import lombok.Data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@Data
public class RabbitMessage implements Serializable {
    private static final long serialVersionUID = 3769564867905802785L;


    private Class<?>[] paramsType;
    private String exchange;
    private Object[] params;
    private String routeKey;
    private String methodName;
    private String beanName;

    public RabbitMessage() {
    }

    public RabbitMessage(String exchange, String routeKey, Object... params) {
        this.params = params;
        this.exchange = exchange;
        this.routeKey = routeKey;
    }

    public RabbitMessage(String exchange, String routeKey,String beanName, String methodName, Object... params) {
        this.params = params;
        this.exchange = exchange;
        this.routeKey = routeKey;
        this.methodName=methodName;
        this.beanName=beanName;
        int len = params.length;
        Class[] clazzArray = new Class[len];
        for (int i = 0; i < len; i++)
            clazzArray[i] = params[i].getClass();
        this.paramsType = clazzArray;
    }

    public byte[] getSerialBytes() {
        byte[] res = new byte[0];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.close();
            res = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;

    }
}
