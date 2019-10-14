package com.laurel.classInheritance;

abstract class Shape{
	abstract double area();
	abstract double perimeter();
}
//矩形
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
//圆形
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
//直角三角形
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
		System.out.println("矩形的面积："+r.area()+"\n"+"矩形的周长："+r.perimeter());
		System.out.println("圆的面积："+c.area()+"\n"+"圆的周长："+c.perimeter());
		System.out.println("直角三角形的面积："+t.area()+"\n"+"直角三角形的周长："+t.perimeter());
	}

}
