package pers.haozengyun.tetrisl.brick.pojo;

import java.awt.Color;
import java.awt.Image;

import pers.haozengyun.tetrisl.Game;

/**
 * С�����࣬һ���󷽿麬���ĸ�С����
 * @author Administrator
 *
 */
public class BaseBrick {
	private int x;//С�����x��
	private int y;//С�����y��
	private int length;//С����ı䳤
	private Color color;//С�������ɫ
	private Image image;
	
	public  int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public BaseBrick(int x,int y,Image image){
		this.x=x;
		this.y=y;
		this.length=Game.BASE_LENGTH;
		this.setImage(image);
	}

	
	
}
