package pers.haozengyun.tetrisl;

import java.awt.Image;

/**
 *������ 
 *
 */

public class Game {
	public final static int BASE_LENGTH=30;//С����ı䳤
	public final static int GAME_WIDTH=300;//��Ϸҳ��Ŀ��
	public final static int GAME_HEIGHT=600;//��Ϸҳ��ĸ߶�
	public final static int SCREEN_WITDH=600;//���ڵĿ��
	public final static int SCREEN_HEIGHT=600;//���ڵĸ߶�
	public final static int PADDIND=15;
	public static Image S;
	public static Image Z;
	public static Image L;
	public static Image J;
	public static Image O;
	public static Image I;
	public static Image T;
	
	
	//����ö�٣�������ĸ�����
	public enum Direction {
		UP,RIGHT,DOWN,LEFT;
	}
	
	//���巽������࣬������
	public enum BrickType{
		S,L,J,T,Z,I,O;
	}
}
