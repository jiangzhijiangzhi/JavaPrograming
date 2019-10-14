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
		System.out.println("货物总数量为："+N);
		System.out.println("电视机数量为："+a);
		System.out.println("电脑数量为："+b);
		System.out.println("洗衣机数量为："+c);
		System.out.println("货物总重量为："+truck.getAllWeight(a, b, c, things)+"kg");
	}

}
