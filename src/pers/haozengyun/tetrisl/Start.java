package pers.haozengyun.tetrisl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import pers.haozengyun.tetrisl.brick.pojo.BaseBrick;
import pers.haozengyun.tetrisl.brick.service.BrickService;
import pers.haozengyun.tetrisl.brick.service.IBrickService;
import pers.haozengyun.tetrisl.frame.GameFrame;

public class Start {
	private IBrickService bs = null;

	/**
	 * ��ʼ�����о�̬����
	 */
	public Start() {
		bs = new BrickService();
		Const.nowBrick = bs.create();
		Const.bricks = new ArrayList<ArrayList<BaseBrick>>();

		for (int i = 0; i < 20; i++) {
			Const.bricks.add(new ArrayList<BaseBrick>());
		}
		try {
			Game.J = ImageIO.read(new File("picture/J.png"));
			Game.L = ImageIO.read(new File("picture/L.png"));
			Game.O = ImageIO.read(new File("picture/O.png"));
			Game.T = ImageIO.read(new File("picture/T.png"));
			Game.I = ImageIO.read(new File("picture/I.png"));
			Game.S = ImageIO.read(new File("picture/S.png"));
			Game.Z = ImageIO.read(new File("picture/Z.png"));
		} catch (IOException e) {
			System.out.println("����ͼ����󣡣���");
			e.printStackTrace();
		}

		/**
		 * ����Ϸ����
		 */
		GameFrame gf = new GameFrame();
	}
}
