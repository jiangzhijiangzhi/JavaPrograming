package com.laurel.interfaceAndPolymorphism;

import java.util.Scanner;

interface Soundable{
	public void playSound();
	public void decreaseVolume();
	public void stopSound();
}

class Radio implements Soundable{
	public void playSound() {
		System.out.println("收音机播放广播：中央人民广播电台");
	}
	 public void decreaseVolume() {
	        System.out.println("降低收音机音量。");
	    }
	 public void stopSound() {
	        System.out.println("关闭收音机。");
	    }
}

class Walkman implements Soundable{
	public void playSound() {
        System.out.println("随身听发出音乐：1234567");
    }
    public void decreaseVolume() {
        System.out.println("降低随身听音量");
    }
     public void stopSound() {
        System.out.println("关闭随身听");
    }
}

class MobilePhone implements Soundable{
    public void playSound() {
        System.out.println("手机发出来电铃声：叮当 ， 叮当");
    }
    public void decreaseVolume() {
        System.out.println("降低手机音量");
    }
    public void stopSound() {
        System.out.println("关闭手机");
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
        System.out.println("你想听什么？请输入选择：");
        System.out.println("0-收音机  1-随身听  2-手机");
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
            System.out.println("输入错误");
        in.close();
	}

}
