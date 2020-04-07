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
	 * �󷽿��ƶ��߳�
	 */
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(700,3000);//ÿ700�����ƶ�һ��
				bs.move();
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(Exception e){
				System.out.println("��Ϸ����");
				System.out.println("��������Ϊ:"+Const.Score);
				System.exit(3);
			}
			
		}
	}
}
