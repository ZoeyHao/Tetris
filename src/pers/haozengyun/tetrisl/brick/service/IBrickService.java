package pers.haozengyun.tetrisl.brick.service;

import pers.haozengyun.tetrisl.brick.pojo.Brick;

/**

 * @author Administrator
 *
 */
public interface IBrickService {
	public Brick create();//�����󷽿�
	public void move() throws Exception; //�󷽿��ƶ�
	public void Change(Brick brick);//��ʼ��С��������
}
