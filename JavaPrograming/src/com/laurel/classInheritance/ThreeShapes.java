package com.laurel.classInheritance;

abstract class Shape{
	abstract double area();
	abstract double perimeter();
}
//����
class Rectangle extends Shape{
	protected double length;
	protected double width;
	public Rectangle(double length,double width) {
		this.length=length;
		this.width=width;
	}
	double area() {
		return length*width;
	}
	double perimeter() {
		return 2*(length+width);
	}
	public void setLength(double length) {
		this.length=length;
	}
	public void setWidth(double width) {
		this.width=width;
	}
	public double getLength() {
		return length;
	}
	public double getWidth() {
		return width;
	}
}
//Բ��
class Circle extends Shape{
	protected double radius;
	public Circle(double radius) {
		this.radius=radius;
	}
	double area() {
		return Math.PI*radius*radius;
	}
	double perimeter() {
		return 2*Math.PI*radius;
	}
	public void setRadius(double radius) {
		this.radius=radius;
	}
	public double getRadius() {
		return radius;
	}
}
//ֱ��������
class Righttriangle extends Shape{
	protected double edgea,edgeb,edgec;
	public Righttriangle(double edgea,double edgeb,double edgec) {
		this.edgea=edgea;
		this.edgeb=edgeb;
		this.edgec=edgec;
	}
	double area() {
		return edgea*edgeb*0.5;
	}
	double perimeter() {
		return edgea+edgeb+edgec;
	}
	public void setEdgea(double edgea) {
		this.edgea=edgea;
	}
	public void setEdgeb(double edgeb) {
		this.edgeb=edgeb;
	}
	public void setEdgec(double edgec) {
		this.edgec=edgec;
	}
	public double getEdgea() {
		return edgea;
	}
	public double getEdgeb() {
		return edgeb;
	}
	public double getEdgec() {
		return edgec;
	}
}
public class ThreeShapes {

	public static void main(String[] args) {
		Shape r=new Rectangle(6.0,1.0);
		Shape c=new Circle(2.0);
		Shape t=new Righttriangle(3.0,4.0,5.0);
		System.out.println("���ε������"+r.area()+"\n"+"���ε��ܳ���"+r.perimeter());
		System.out.println("Բ�������"+c.area()+"\n"+"Բ���ܳ���"+c.perimeter());
		System.out.println("ֱ�������ε������"+t.area()+"\n"+"ֱ�������ε��ܳ���"+t.perimeter());
	}

}
