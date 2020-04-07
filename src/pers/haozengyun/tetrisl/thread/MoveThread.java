package pers.haozengyun.tetrisl.thread;

import pers.haozengyun.tetrisl.Const;
import pers.haozengyun.tetrisl.Game;
import pers.haozengyun.tetrisl.brick.service.BrickService;
import pers.haozengyun.tetrisl.brick.service.IBrickService;
import pers.haozengyun.tetrisl.frame.GameFrame;

public class MoveThread implements Runnable {
	private IBrickService bs = null;

	public MoveThread() {
		bs = new BrickService();
	}

	/**
	 * 大方块移动线程
	 */
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(700,3000);//每700毫秒移动一次
				bs.move();
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(Exception e){
				System.out.println("游戏结束");
				System.out.println("消除行数为:"+Const.Score);
				System.exit(3);
			}
			
		}
	}
}
