package pers.haozengyun.tetrisl.brick.service;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import pers.haozengyun.tetrisl.Const;
import pers.haozengyun.tetrisl.Game;
import pers.haozengyun.tetrisl.Game.BrickType;
import pers.haozengyun.tetrisl.Game.Direction;
import pers.haozengyun.tetrisl.brick.pojo.BaseBrick;
import pers.haozengyun.tetrisl.brick.pojo.Brick;

public class BrickService implements IBrickService{
	private Random ran=null;
	
	public BrickService(){
		ran=new Random();
	}
	
	@Override
	/**
	 * �����󷽿�
	 */
	public Brick create() {
		int x=ran.nextInt(10)*Game.BASE_LENGTH;//������󷽿��x������
		Direction dir=Direction.values()[ran.nextInt(4)];//������󷽿�ķ���
		BrickType type=BrickType.values()[ran.nextInt(7)];//������󷽿������
		
		//ʵ�����󷽿�
		Brick brick=new Brick(x+Game.PADDIND, Game.PADDIND,type,dir);
		
		//��󷽿�������ĸ�С����
		for(int i=0;i<4;i++){
			brick.getBricks().add(new BaseBrick(0,0,Game.I));
		}
		
		/**
		 * ���������󷽿����ĸ�С���������
		 * ���ݴ󷽿�����࣬������ת����
		 */
		Change(brick);
		
		/**
		 * �����ʼ��ʱ����
		 * ��߳���������һ����λ��С����ı䳤��
		 * �ҳ���������һ����λ
		 */
		for(int i=0;i<4;i++){
			if(brick.getBricks().get(i).getX()<0){
				brick.setX(brick.getX()+Game.BASE_LENGTH);
				Change(brick);
			}
			if(brick.getBricks().get(i).getX()>Game.GAME_WIDTH-Game.BASE_LENGTH){
				brick.setX(brick.getX()-Game.BASE_LENGTH);
				Change(brick);
			}
		}
		return brick;
	}
	
	/**
	 * �����ƶ�
	 */
	@Override
	public void move() throws Exception{
		boolean stop=false;
		for(int i=0;i<Const.bricks.size();i++){
			for(int j=0;j<Const.bricks.get(i).size();j++){
				if(Const.nowBrick.getBricks().get(0).getY()+Game.BASE_LENGTH==Const.bricks.get(i).get(j).getY()&&Const.nowBrick.getBricks().get(0).getX()==Const.bricks.get(i).get(j).getX()){
					stop=true;
				}
				if(Const.nowBrick.getBricks().get(1).getY()+Game.BASE_LENGTH==Const.bricks.get(i).get(j).getY()&&Const.nowBrick.getBricks().get(1).getX()==Const.bricks.get(i).get(j).getX()){
					stop=true;
				}
				if(Const.nowBrick.getBricks().get(2).getY()+Game.BASE_LENGTH==Const.bricks.get(i).get(j).getY()&&Const.nowBrick.getBricks().get(2).getX()==Const.bricks.get(i).get(j).getX()){
					stop=true;
				}
				if(Const.nowBrick.getBricks().get(3).getY()+Game.BASE_LENGTH==Const.bricks.get(i).get(j).getY()&&Const.nowBrick.getBricks().get(3).getX()==Const.bricks.get(i).get(j).getX()){
					stop=true;
				}
				/*if(Const.nowBrick.getY()>=Game.GAME_HEIGHT-Game.BASE_LENGTH){
					stop=true;
				}*/
			}
			}
		for(int i=0;i<4;i++){
		if(Const.nowBrick.getBricks().get(i).getY()>=Game.GAME_HEIGHT-Game.BASE_LENGTH-+Game.PADDIND){
			stop=true;
		}
		}
		if(!stop){
			Const.nowBrick.setY(Const.nowBrick.getY()+Game.BASE_LENGTH);
			Change(Const.nowBrick);
		}
		else{
			for(int i=0;i<4;i++){
			Const.bricks.get((Game.GAME_HEIGHT-+Game.PADDIND-Const.nowBrick.getBricks().get(i).getY())/Game.BASE_LENGTH-1).add(Const.nowBrick.getBricks().get(i));
			}
			Const.nowBrick=create();
		}
	
}
		
		
	
	
	
	/**
	 * �ı�󷽿����ĸ�С�����x��y����
	 * ��Ȼ�ܳ��������Ҿ��ýṹͦ�����ģ�
	 * ����������ף���֪�����ǳ�ʼ��С�����������
	 * ÿ�δ󷽿�ı䷽�����λ�ã�����Ҫ��ʼ��һ������
	 */
	@Override
	public void Change(Brick brick){	
		int x=brick.getX();
		int y=brick.getY();
		Image image=null;
		switch(brick.getType()){
		case I:
			image=Game.I;
			switch(brick.getDir()){
			case UP:
			case DOWN:
				brick.getBricks().set(0, new BaseBrick(x, y-Game.BASE_LENGTH, image));
				brick.getBricks().set(1, new BaseBrick(x-2*Game.BASE_LENGTH, y-Game.BASE_LENGTH, image));
				brick.getBricks().set(2, new BaseBrick(x-Game.BASE_LENGTH, y-Game.BASE_LENGTH, image));
				brick.getBricks().set(3, new BaseBrick(x+Game.BASE_LENGTH, y-Game.BASE_LENGTH, image));
				break;
			case LEFT:
			case RIGHT:
				brick.getBricks().set(0, new BaseBrick(x, y-2*Game.BASE_LENGTH, image));
				brick.getBricks().set(1, new BaseBrick(x, y-Game.BASE_LENGTH, image));
				brick.getBricks().set(2, new BaseBrick(x, y, image));
			brick.getBricks().set(3, new BaseBrick(x, y+Game.BASE_LENGTH, image));
				break;
			}
			break;
		case J:
			image=Game.J;
			switch(brick.getDir()){
			case UP:
				brick.getBricks().set(0, new BaseBrick(x, y, image));
				brick.getBricks().set(1, new BaseBrick(x-Game.BASE_LENGTH, y-Game.BASE_LENGTH, image));
				brick.getBricks().set(2, new BaseBrick(x-Game.BASE_LENGTH, y, image));
				brick.getBricks().set(3, new BaseBrick(x+Game.BASE_LENGTH, y, image));
				break;
			case DOWN:
				brick.getBricks().set(0, new BaseBrick(x, y, image));
				brick.getBricks().set(1, new BaseBrick(x+Game.BASE_LENGTH, y, image));
				brick.getBricks().set(2, new BaseBrick(x-Game.BASE_LENGTH, y, image));
				brick.getBricks().set(3, new BaseBrick(x+Game.BASE_LENGTH, y+Game.BASE_LENGTH, image));
				break;
			case LEFT:
				brick.getBricks().set(0, new BaseBrick(x, y-Game.BASE_LENGTH, image));
				brick.getBricks().set(1, new BaseBrick(x, y+Game.BASE_LENGTH, image));
				brick.getBricks().set(2, new BaseBrick(x-Game.BASE_LENGTH, y+Game.BASE_LENGTH, image));
				brick.getBricks().set(3, new BaseBrick(x, y, image));
				break;
			case RIGHT:
				brick.getBricks().set(0, new BaseBrick(x, y, image));
				brick.getBricks().set(1, new BaseBrick(x+Game.BASE_LENGTH, y-Game.BASE_LENGTH, image));
				brick.getBricks().set(2, new BaseBrick(x, y-Game.BASE_LENGTH, image));
				brick.getBricks().set(3, new BaseBrick(x, y+Game.BASE_LENGTH, image));
				break;
			}
			break;
		case L:
			image=Game.L;
			switch(brick.getDir()){
			case UP:
				brick.getBricks().set(0, new BaseBrick(x, y, image));
				brick.getBricks().set(1, new BaseBrick(x+Game.BASE_LENGTH, y-Game.BASE_LENGTH, image));
				brick.getBricks().set(2, new BaseBrick(x-Game.BASE_LENGTH, y, image));
				brick.getBricks().set(3, new BaseBrick(x+Game.BASE_LENGTH, y, image));
				break;
			case DOWN:
				brick.getBricks().set(0, new BaseBrick(x-Game.BASE_LENGTH, y+Game.BASE_LENGTH, image));
				brick.getBricks().set(1, new BaseBrick(x, y, image));
				brick.getBricks().set(2, new BaseBrick(x+Game.BASE_LENGTH, y, image));
				brick.getBricks().set(3, new BaseBrick(x-Game.BASE_LENGTH, y, image));
				break;
			case LEFT:
				brick.getBricks().set(0, new BaseBrick(x-Game.BASE_LENGTH, y-Game.BASE_LENGTH, image));
				brick.getBricks().set(1, new BaseBrick(x, y+Game.BASE_LENGTH, image));
				brick.getBricks().set(2, new BaseBrick(x, y-Game.BASE_LENGTH, image));
				brick.getBricks().set(3, new BaseBrick(x, y, image));
				break;
			case RIGHT:
				brick.getBricks().set(0, new BaseBrick(x+Game.BASE_LENGTH, y+Game.BASE_LENGTH, image));
				brick.getBricks().set(1, new BaseBrick(x, y+Game.BASE_LENGTH, image));
				brick.getBricks().set(2, new BaseBrick(x, y-Game.BASE_LENGTH, image));
				brick.getBricks().set(3, new BaseBrick(x, y, image));
				break;
			}
			break;
		case T:
			image=Game.T;
			switch(brick.getDir()){
			case UP:
				brick.getBricks().set(0, new BaseBrick(x, y, image));
				brick.getBricks().set(1, new BaseBrick(x+Game.BASE_LENGTH, y, image));
				brick.getBricks().set(2, new BaseBrick(x-Game.BASE_LENGTH, y, image));
				brick.getBricks().set(3, new BaseBrick(x, y-Game.BASE_LENGTH, image));
				break;
			case DOWN:
				brick.getBricks().set(0, new BaseBrick(x, y, image));
				brick.getBricks().set(1, new BaseBrick(x+Game.BASE_LENGTH, y, image));
				brick.getBricks().set(2, new BaseBrick(x-Game.BASE_LENGTH, y, image));
				brick.getBricks().set(3, new BaseBrick(x, y+Game.BASE_LENGTH, image));
				break;
			case LEFT:
				brick.getBricks().set(0, new BaseBrick(x, y, image));
				brick.getBricks().set(1, new BaseBrick(x, y+Game.BASE_LENGTH, image));
				brick.getBricks().set(2, new BaseBrick(x, y-Game.BASE_LENGTH, image));
				brick.getBricks().set(3, new BaseBrick(x-Game.BASE_LENGTH, y, image));
				break;
			case RIGHT:
				brick.getBricks().set(0, new BaseBrick(x, y, image));
				brick.getBricks().set(1, new BaseBrick(x, y+Game.BASE_LENGTH, image));
				brick.getBricks().set(2, new BaseBrick(x, y-Game.BASE_LENGTH, image));
				brick.getBricks().set(3, new BaseBrick(x+Game.BASE_LENGTH, y, image));
				break;
			}
			break;
		case Z:
			image=Game.Z;
			switch(brick.getDir()){
			case UP:
			case DOWN:	
				brick.getBricks().set(0, new BaseBrick(x, y, image));
				brick.getBricks().set(1, new BaseBrick(x-Game.BASE_LENGTH, y, image));
				brick.getBricks().set(2, new BaseBrick(x, y+Game.BASE_LENGTH, image));
				brick.getBricks().set(3, new BaseBrick(x+Game.BASE_LENGTH, y+Game.BASE_LENGTH, image));
				break;
			case LEFT:
			case RIGHT:
				brick.getBricks().set(0, new BaseBrick(x, y, image));
				brick.getBricks().set(1, new BaseBrick(x+Game.BASE_LENGTH, y, image));
				brick.getBricks().set(2, new BaseBrick(x, y+Game.BASE_LENGTH, image));
				brick.getBricks().set(3, new BaseBrick(x+Game.BASE_LENGTH, y-Game.BASE_LENGTH, image));
				break;
			}
			break;
		case S:
			image=Game.S;
			switch(brick.getDir()){
			case UP:
			case DOWN:	
				brick.getBricks().set(0, new BaseBrick(x, y, image));
				brick.getBricks().set(1, new BaseBrick(x+Game.BASE_LENGTH, y, image));
				brick.getBricks().set(2, new BaseBrick(x, y+Game.BASE_LENGTH, image));
				brick.getBricks().set(3, new BaseBrick(x-Game.BASE_LENGTH, y+Game.BASE_LENGTH, image));
				break;
			case LEFT:
			case RIGHT:
				brick.getBricks().set(0, new BaseBrick(x, y, image));
				brick.getBricks().set(1, new BaseBrick(x-Game.BASE_LENGTH, y, image));
				brick.getBricks().set(2, new BaseBrick(x, y+Game.BASE_LENGTH, image));
				brick.getBricks().set(3, new BaseBrick(x-Game.BASE_LENGTH, y-Game.BASE_LENGTH, image));
				break;
			}
			break;
		case O:
			image=Game.O;
			switch(brick.getDir()){
			case UP:
			case DOWN:
			case LEFT:
			case RIGHT:
				brick.getBricks().set(0, new BaseBrick(x, y, image));
				brick.getBricks().set(1, new BaseBrick(x-Game.BASE_LENGTH, y, image));
				brick.getBricks().set(2, new BaseBrick(x, y-Game.BASE_LENGTH, image));
				brick.getBricks().set(3, new BaseBrick(x-Game.BASE_LENGTH, y-Game.BASE_LENGTH, image));
				break;
			}
			break;
		}
	}
	

}
