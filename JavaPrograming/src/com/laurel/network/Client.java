package com.laurel.network;

import java.io.*;
import java.net.*;

public class Client {
	    public static void main(String[] args) {
	        File src;       //��Ҫ���͵��ļ�
	        Socket socket;  //�׽���
	        FileInputStream open;   //��ȡ�ļ�
	        FileOutputStream out;   //�����ļ�

	        try {
	            //��Ҫ������ļ�
	            src = new File("C:\\xss\\xss.mp4");
	            open = new FileInputStream(src);

	            //���ӷ�����
	            socket = new Socket("192.168.0.0", 8080);
	            out = (FileOutputStream)socket.getOutputStream();

	            //��ʼ����
	            byte[] b = new byte[64];
	            int n = open.read(b);
	            int start = (int)System.currentTimeMillis();
	            while (n != -1) {
	                out.write(b, 0, n);
	                n = open.read(b);
	            }
	            int end = (int)System.currentTimeMillis();
	            System.out.println( "���ͻ��ѵ�ʱ�䣺" + (end-start));
	            //�ر���
	            out.close();
	            socket.close();
	            open.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	}
