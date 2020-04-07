package pers.haozengyun.tetrisl;

import java.util.ArrayList;
import java.util.List;

import pers.haozengyun.tetrisl.brick.pojo.BaseBrick;
import pers.haozengyun.tetrisl.brick.pojo.Brick;

/**
 * 静态变量类
 */
public class Const {
	public static Brick nowBrick=null;//当前移动的方块
	public static int Score=0;//玩家消除的行数
	public static List<ArrayList<BaseBrick>> bricks=null;//下方累积的方块数。
}
