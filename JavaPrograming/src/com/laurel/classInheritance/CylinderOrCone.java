package com.laurel.classInheritance;

public class CylinderOrCone {
	int x,y,R=3;
	double ¦Ð=3.14;
	CylinderOrCone(){
		/*this.x=x;
		this.y=y;
		this.R=R;*/
	}	
	void setRadius(int a) {
		R=a;
	}
	double Area() {
		return ¦Ð*R*R;
	}
	double Perimeter(){
		return 2*¦Ð*R;
	}

static class Zhu {
	CylinderOrCone c=new CylinderOrCone();
	int height=3;
	double calculateCyArea() {
		return c.Area()+c.Perimeter()*height;
	}
	double calculateCyVol() {
		return c.Area()*height;
	}
}

static class Zhui{
	CylinderOrCone d=new CylinderOrCone();
	int height=3;
	double V2;
	double calculateCoVol() {
//		V2=d.Area()*height*1/3;
		V2=1.0/3*d.Area()*height;
		return V2;
	}
}
	public static void main(String[] args) {
		CylinderOrCone c;
		c=new CylinderOrCone();
		c.setRadius(5);
		System.out.println(c.Area());
		Zhu d=new Zhu();
		System.out.println(d.calculateCyVol());
		Zhui e=new Zhui();
		System.out.println(e.calculateCoVol());
	}

}
