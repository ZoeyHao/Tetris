package pers.haozengyun.tetrisl.brick.pojo;

import java.util.ArrayList;
import java.util.List;

import pers.haozengyun.tetrisl.Game.BrickType;
import pers.haozengyun.tetrisl.Game.Direction;

/**
 * 大方块类，一个大方块中有四个小方块
 * @author Administrator
 *
 */
public class Brick {
	private int x;//大方块旋转中心的x轴
	private int y;//大方块旋转中心的y轴
	private BrickType type;//大方块的种类
	private Direction dir;//大方块的四个方向
	private List<BaseBrick> bricks;//大方块中四个小方块的集合
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
	 * 构造方法
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
