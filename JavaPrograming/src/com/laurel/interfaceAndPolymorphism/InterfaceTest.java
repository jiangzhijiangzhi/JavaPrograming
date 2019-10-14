package com.laurel.interfaceAndPolymorphism;

import java.util.Scanner;

interface Soundable{
	public void playSound();
	public void decreaseVolume();
	public void stopSound();
}

class Radio implements Soundable{
	public void playSound() {
		System.out.println("���������Ź㲥����������㲥��̨");
	}
	 public void decreaseVolume() {
	        System.out.println("����������������");
	    }
	 public void stopSound() {
	        System.out.println("�ر���������");
	    }
}

class Walkman implements Soundable{
	public void playSound() {
        System.out.println("�������������֣�1234567");
    }
    public void decreaseVolume() {
        System.out.println("��������������");
    }
     public void stopSound() {
        System.out.println("�ر�������");
    }
}

class MobilePhone implements Soundable{
    public void playSound() {
        System.out.println("�ֻ������������������� �� ����");
    }
    public void decreaseVolume() {
        System.out.println("�����ֻ�����");
    }
    public void stopSound() {
        System.out.println("�ر��ֻ�");
    }
}

class SampleDisplay {
    public void display(Soundable soundable) {
        soundable.playSound();
        soundable.decreaseVolume();
        soundable.stopSound();
    }
}

public class InterfaceTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        System.out.println("������ʲô��������ѡ��");
        System.out.println("0-������  1-������  2-�ֻ�");
        int choice;
        choice = in.nextInt();
        SampleDisplay sampledisplay = new SampleDisplay();
        if (choice == 0)
            sampledisplay.display(new Radio());
        else if(choice == 1)
            sampledisplay.display(new Walkman());
        else if(choice == 2)
            sampledisplay.display(new MobilePhone());
        else
            System.out.println("�������");
        in.close();
	}

}
