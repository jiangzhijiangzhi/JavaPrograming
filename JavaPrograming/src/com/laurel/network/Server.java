package com.laurel.network;

import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) {
        File target;    //���յ����ļ������λ��
        FileOutputStream save;  //�����յ����ļ�д�����
        FileInputStream in;     //��ȡ���͹����������ļ�
        ServerSocket server;    //������
        Socket socket;          //�׽���

        //����ͻ��˵�����
        try {
            //����ǰ�ļ���׼��
            target = new File("/root/Desktop/Java/exp/a.jpeg");
            save = new FileOutputStream(target);

            server = new ServerSocket(8080);    //����˿�

            //�ȴ��ͻ��˵ĺ���
            System.out.println("�ȴ��ͻ��˵ĺ���");
            socket = server.accept();   //����
            in = (FileInputStream)socket.getInputStream();

            //��������
            byte[] b = new byte[64];
            int n = in.read(b);
            int start = (int)System.currentTimeMillis();
            while (n != -1) {
                save.write(b, 0, n);    //д��ָ���ط�
                n = in.read(b);
            }
            int end = (int)System.currentTimeMillis();
            System.out.println("���ջ��ѵ�ʱ�䣺" + (end-start));
            socket.close();
            server.close();
            in.close();
            save.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
