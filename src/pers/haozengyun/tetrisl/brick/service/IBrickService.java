package pers.haozengyun.tetrisl.brick.service;

import pers.haozengyun.tetrisl.brick.pojo.Brick;

/**

 * @author Administrator
 *
 */
public interface IBrickService {
	public Brick create();//创建大方块
	public void move() throws Exception; //大方块移动
	public void Change(Brick brick);//初始化小方块坐标
}
