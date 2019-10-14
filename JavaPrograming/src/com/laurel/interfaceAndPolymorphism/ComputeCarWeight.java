package com.laurel.interfaceAndPolymorphism;

import java.util.Random;

interface ComputeWeight{
	public double computeWeight();
}

class Television implements ComputeWeight{
	double tweight;
	Television(double t){
		this.tweight=t;
	}
	public double computeWeight() {
		return tweight;
	}
}

class Computer implements ComputeWeight{
	double cweight;
	Computer(double c){
		this.cweight=c;
	}
	public double computeWeight() {
		return cweight;
	}
}

class WashMachine implements ComputeWeight{
	double wweight;
	WashMachine(double w){
		this.wweight=w;
	}
	public double computeWeight() {
		return wweight;
	}
}

class Truck{
	ComputeWeight [] things;
	double allWeight=0;
	Truck(ComputeWeight[] things){
		this.things=things;
	}
	public void setThings(ComputeWeight[] things) {
		this.things=things;
	}
	public double getAllWeight(int a,int b,int c,ComputeWeight[] things) {
		allWeight=0;
		allWeight=things[0].computeWeight()*a+things[1].computeWeight()*b+things[2].computeWeight()*c;
		return allWeight;
	}
}

public class ComputeCarWeight {
	
	public static void main(String[] args) {
		Random random=new Random();
		int N=random.nextInt(21)+30;
		ComputeWeight[] things=new ComputeWeight[3];
		Truck truck=new Truck(things);
		things[0]=new Television(20);
		things[1]=new Computer(10);
		things[2]=new WashMachine(50);
//		int a=(int)(Math.random()*N);
		int a=random.nextInt(N);
		int b=random.nextInt(N+1-a);
		int c=N-a-b;
		System.out.println("����������Ϊ��"+N);
		System.out.println("���ӻ�����Ϊ��"+a);
		System.out.println("��������Ϊ��"+b);
		System.out.println("ϴ�»�����Ϊ��"+c);
		System.out.println("����������Ϊ��"+truck.getAllWeight(a, b, c, things)+"kg");
	}

}
