package pers.haozengyun.tetrisl.brick.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

import javax.swing.Box.Filler;

import pers.haozengyun.tetrisl.Game;
import pers.haozengyun.tetrisl.Game.BrickType;
import pers.haozengyun.tetrisl.Game.Direction;
import pers.haozengyun.tetrisl.brick.pojo.Brick;
import pers.haozengyun.tetrisl.brick.service.BrickService;
import pers.haozengyun.tetrisl.brick.service.IBrickService;

public class BrickView implements IBrickView{
	private IBrickService bs=new BrickService();

	@Override
	public void draw(Brick brick,Graphics g,ImageObserver io) {//»­´ó·½¿é
		bs.Change(brick);
		for(int i=0;i<4;i++)
		{
			g.setColor(brick.getBricks().get(i).getColor());
			g.drawImage(brick.getBricks().get(i).getImage(),brick.getBricks().get(i).getX(), brick.getBricks().get(i).getY(), Game.BASE_LENGTH, Game.BASE_LENGTH,io);
		}
	}

}
