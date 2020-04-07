package pers.haozengyun.tetrisl.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import pers.haozengyun.tetrisl.Const;
import pers.haozengyun.tetrisl.Game;
import pers.haozengyun.tetrisl.Game.Direction;
import pers.haozengyun.tetrisl.brick.pojo.BaseBrick;
import pers.haozengyun.tetrisl.brick.service.BrickService;
import pers.haozengyun.tetrisl.brick.service.IBrickService;
import pers.haozengyun.tetrisl.brick.view.BrickView;
import pers.haozengyun.tetrisl.brick.view.IBrickView;
import pers.haozengyun.tetrisl.thread.MoveThread;

public class GameFrame extends Frame {
	private Image image = null;
	private IBrickView bv = null;
	private IBrickService bs = null;
	private boolean key = true;
	private Image backGround=null;
	private Image S=null;
	private Image T=null;
	private Image Z=null;
	private Image J=null;
	private Image L=null;
	private Image O=null;
	private Image I=null;

	public GameFrame() {
		setSize(Game.SCREEN_WITDH, Game.SCREEN_HEIGHT+30);
		setTitle("����˹����Client");
		setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setLocationRelativeTo(null);
		setVisible(true);
		bv = new BrickView();
		bs = new BrickService();
		this.addKeyListener(new KeyListener());//���̼���
		new Thread(new RepaintThread()).start();//�����ػ��߳�
		new Thread(new MoveThread()).start();//�������������ƶ��߳�
		String filename = "picture/tetris.png";
		try {
	   backGround= ImageIO.read(new File(filename)); 
		} catch (IOException e) {
		System.out.println("����ͼ����󣡣���");
		e.printStackTrace();
		}
		
	}

	/**
	 * ���λ���
	 */
	@Override
	public void update(Graphics g) {
		image = createImage(Game.SCREEN_WITDH, Game.SCREEN_HEIGHT);
		Graphics gimage = image.getGraphics();
		gimage.setColor(Color.BLACK);
		gimage.setFont(new Font("����", 1, 30));
		gimage.drawImage(backGround,0,0, Game.SCREEN_WITDH,Game.SCREEN_HEIGHT,this);
		gimage.drawString("LINE:" + Const.Score, 380, 195);
		draw(gimage);
		g.drawImage(image, 0, 30,this);
	}

	/**
	 * draw����
	 * ����Ϸҳ��
	 * @param g
	 */
	public void draw(Graphics g) {
		for (int i = 0; i < Const.bricks.size(); i++) {
			for (int j = 0; j < Const.bricks.get(i).size(); j++) {
				int x = Const.bricks.get(i).get(j).getX();
				int y = Const.bricks.get(i).get(j).getY();
				g.drawImage(Const.bricks.get(i).get(j).getImage(),x, y, Game.BASE_LENGTH, Game.BASE_LENGTH,this);
			}
		}
		bv.draw(Const.nowBrick, g,this);
	}

	public class RepaintThread implements Runnable {

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(10);
					for (int i = 0; i < 19; i++) {
						if (Const.bricks.get(i).size() >= 10) {
							Const.bricks.remove(i);
							Const.bricks.add(new ArrayList<BaseBrick>());
							Const.Score++;
							i--;
						}
					}
					for (int i = 0; i < 19; i++) {
						//System.out.print(Const.bricks.get(i).size());
						if (Const.bricks.get(i).size() != 0) {
							if (Const.bricks.get(i).get(0).getY() != (19 - i)* Game.BASE_LENGTH-Game.PADDIND) {
								for (int j = 0; j < Const.bricks.get(i).size(); j++) {
									Const.bricks.get(i).get(j).setY((19 - i) * Game.BASE_LENGTH-Game.PADDIND);
								}
							}
						}
					}
					//System.out.println();
					update(getGraphics());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * ���̼���
	 * ����Ϊ�˼���bug����д����������
	 * ��Ȼ��дkeypressed����
	 * 
	 * @author Administrator
	 *
	 */
	public class KeyListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			//if (key) {
				switch (e.getKeyCode()) {
				/**
				 * ������������������ƶ�
				 */
				case KeyEvent.VK_LEFT:
					boolean flag = true;
					int oldX = Const.nowBrick.getX();
					int oldY = Const.nowBrick.getY();
					Const.nowBrick.setX(Const.nowBrick.getX()- Game.BASE_LENGTH);
					bs.Change(Const.nowBrick);
					for (int i = 0; i < 4; i++) {
						if (Const.nowBrick.getBricks().get(i).getX() < Game.PADDIND) {
							flag = false;
						}
					}
					for (int i = 0; i < Const.bricks.size(); i++) {
						for (int j = 0; j < Const.bricks.get(i).size(); j++) {
							for (int m = 0; m < 4; m++) {
								if (Const.nowBrick.getBricks().get(m).getX() == Const.bricks.get(i).get(j).getX()&&Const.nowBrick.getBricks().get(m).getY() == Const.bricks.get(i).get(j).getY()) {
									flag = false;
								}
							}
						}
					} 
					if (!flag) {
						Const.nowBrick.setX(oldX);
						bs.Change(Const.nowBrick);
					}
					break;
					/**
					 * �����Ҽ������������ƶ�
					 */
				case KeyEvent.VK_RIGHT:
					flag = true;
					oldX = Const.nowBrick.getX();
					oldY = Const.nowBrick.getY();
					Const.nowBrick.setX(Const.nowBrick.getX()+ Game.BASE_LENGTH);
					bs.Change(Const.nowBrick);
					for (int i = 0; i < 4; i++) {
						if (Const.nowBrick.getBricks().get(i).getX() > Game.GAME_WIDTH- Game.BASE_LENGTH+Game.PADDIND) {
							flag = false;
						}
					}
					for (int i = 0; i < Const.bricks.size(); i++) {
						for (int j = 0; j < Const.bricks.get(i).size(); j++) {
							for (int m = 0; m < 4; m++) {
								if (Const.nowBrick.getBricks().get(m).getX() == Const.bricks.get(i).get(j).getX()&&Const.nowBrick.getBricks().get(m).getY() == Const.bricks.get(i).get(j).getY()) {
									flag = false;
								}
							}
						}
					}
					if (!flag) {
						Const.nowBrick.setX(oldX);
						bs.Change(Const.nowBrick);
						}
					break;
					
					/**
					 * ���¿ո�ı䷽��
					 */
				case KeyEvent.VK_SPACE:
					flag=true;
					int oldDir = Const.nowBrick.getDir().ordinal();
					int newDir = (oldDir + 1) % 4;
					Const.nowBrick.setDir(Direction.values()[newDir]);
					bs.Change(Const.nowBrick);
					for (int i = 0; i < 4; i++) {
						if ((Const.nowBrick.getBricks().get(i).getX() > Game.GAME_WIDTH- Game.BASE_LENGTH+Game.PADDIND)
								|| (Const.nowBrick.getBricks().get(i).getX() < +Game.PADDIND)) {
							flag=false;
							break;
						}
					}
					for (int i = 0; i < Const.bricks.size(); i++) {
						for (int j = 0; j < Const.bricks.get(i).size(); j++) {
							for (int m = 0; m < 4; m++) {
								if (Const.nowBrick.getBricks().get(m).getX() == Const.bricks.get(i).get(j).getX()&&Const.nowBrick.getBricks().get(m).getY() == Const.bricks.get(i).get(j).getY()) {
									flag = false;
								}
							}
						}
					} 
					if(!flag){
						Const.nowBrick.setDir(Direction.values()[oldDir]);
						bs.Change(Const.nowBrick);
					}
					break;
				
					/**
					 * ��down�����ƶ�
					 */
				case KeyEvent.VK_DOWN:
					try {
						bs.move();
					} catch (Exception e1) {
						System.out.println("��Ϸ����");
						System.out.println("��������Ϊ:"+Const.Score);
						System.exit(3);
					}
					break;
				}
				key = false;
			}
		//}

		/*@Override
		public void keyReleased(KeyEvent e) {
			key = true;
		}*/
	}

}
