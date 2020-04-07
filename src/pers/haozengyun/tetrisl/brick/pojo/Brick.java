package pers.haozengyun.tetrisl.brick.pojo;

import java.util.ArrayList;
import java.util.List;

import pers.haozengyun.tetrisl.Game.BrickType;
import pers.haozengyun.tetrisl.Game.Direction;

/**
 * �󷽿��࣬һ���󷽿������ĸ�С����
 * @author Administrator
 *
 */
public class Brick {
	private int x;//�󷽿���ת���ĵ�x��
	private int y;//�󷽿���ת���ĵ�y��
	private BrickType type;//�󷽿������
	private Direction dir;//�󷽿���ĸ�����
	private List<BaseBrick> bricks;//�󷽿����ĸ�С����ļ���
	public int getX() {
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
	public BrickType getType() {
		return type;
	}
	public void setType(BrickType type) {
		this.type = type;
	}
	public Direction getDir() {
		return dir;
	}
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	public List<BaseBrick> getBricks() {
		return bricks;
	}
	public void setBricks(List<BaseBrick> bricks) {
		this.bricks = bricks;
	}
	/**
	 * ���췽��
	 * @param x
	 * @param y
	 * @param type
	 * @param dir
	 */
	public Brick(int x,int y,BrickType type,Direction dir){
		this.x=x;
		this.y=y;
		this.type=type;
		this.dir=dir;
		bricks=new ArrayList<BaseBrick>(4);
	}
	
}
