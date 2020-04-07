package pers.haozengyun.tetrisl;

import java.awt.Image;

/**
 *常量类 
 *
 */

public class Game {
	public final static int BASE_LENGTH=30;//小方块的变长
	public final static int GAME_WIDTH=300;//游戏页面的宽度
	public final static int GAME_HEIGHT=600;//游戏页面的高度
	public final static int SCREEN_WITDH=600;//窗口的宽度
	public final static int SCREEN_HEIGHT=600;//窗口的高度
	public final static int PADDIND=15;
	public static Image S;
	public static Image Z;
	public static Image L;
	public static Image J;
	public static Image O;
	public static Image I;
	public static Image T;
	
	
	//定义枚举，方块的四个方向
	public enum Direction {
		UP,RIGHT,DOWN,LEFT;
	}
	
	//定义方块的种类，共七种
	public enum BrickType{
		S,L,J,T,Z,I,O;
	}
}
