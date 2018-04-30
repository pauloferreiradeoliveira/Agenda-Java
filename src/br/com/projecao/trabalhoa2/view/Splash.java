package br.com.projecao.trabalhoa2.view;


import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class Splash extends JWindow {

		private static final long serialVersionUID = 1L;
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		int z = 2;
		private JLabel mudar;
		private JLabel mudar1;
		private JLabel mudar2;
		private JLabel mudar3;
		int x = (w - 500) / z;
		int y = (h - 331) / z;
		// ImageIcon ico = new ImageIcon("agenda2.jpg");
		private JLabel img = new JLabel(new ImageIcon("Images/agenda2.jpg"));

		private JProgressBar agenda2;

		public int getW() {
			return w;
		}

		public void setW(int w) {
			this.w = w;
		}

		public int getH() {
			return h;
		}

		public void setH(int h) {
			this.h = h;
		}

		public int getZ() {
			return z;
		}

		public void setZ(int z) {
			this.z = z;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public JLabel getImg() {
			return img;
		}

		public void setImg(JLabel img) {
			this.img = img;
		}

		public JProgressBar getagenda2() {
			return agenda2;
		}

		public void setagenda2(JProgressBar agenda2) {
			this.agenda2 = agenda2;
		}
		

		public JLabel getMudar() {
			return mudar;
		}

		public void setMudar(JLabel mudar) {
			this.mudar = mudar;
		}

		
		public JLabel getMudar1() {
			return mudar1;
		}

		public void setMudar1(JLabel mudar1) {
			this.mudar1 = mudar1;
		}

		public JLabel getMudar2() {
			return mudar2;
		}

		public void setMudar2(JLabel mudar2) {
			this.mudar2 = mudar2;
		}

		public JLabel getMudar3() {
			return mudar3;
		}

		public void setMudar3(JLabel mudar3) {
			this.mudar3 = mudar3;
		}

		public Splash() throws InterruptedException {
			this.setLayout(null);
			this.setLocation(new Point(x, y));
			this.setSize(500, 340);
			this.setVisible(true);
			// img = new JLabel();
			// img.setIcon(ico);
			img.setLocation(new Point(0, 0));
			// img.setBounds(1, 10, 521, 315);
			img.setSize(500, 330);

			agenda2 = new JProgressBar();
			//agenda2.setBackground(new Color(0, 102, 52));
			agenda2.setBounds(2, 315, 535, 20);
			agenda2.setStringPainted(true);
			mudar = new JLabel();
			mudar.setBounds(210, 290, 200, 20);
			mudar1 = new JLabel();
			mudar1.setBounds(232, 290, 200, 20);
			mudar2 = new JLabel();
			mudar2.setBounds(254, 290, 200, 20);
			mudar3 = new JLabel();
			mudar3.setBounds(276, 290, 200, 20);
			
			getContentPane().add(mudar);
			getContentPane().add(mudar1);
			getContentPane().add(mudar2);
			getContentPane().add(mudar3);
			getContentPane().add(img);
			getContentPane().add(agenda2);
			
			// this.add(img);
			this.add(agenda2);

			new Thread() {
				public void run() {
					for (int progress = 0; progress <= 100; progress++) {
						if(progress == 20){
							mudar.setIcon(new ImageIcon("Images/Perfil.png"));
						}
						if(progress == 40){
							mudar1.setIcon( new ImageIcon("Images/Tipo.png"));
						}
						if(progress == 60){
							mudar2.setIcon(new ImageIcon("Images/Add.png"));
						}
						if(progress == 80){
							mudar3.setIcon(new ImageIcon("Images/login.png"));
						}
						try {
							agenda2.setValue(progress);
							sleep(50);
							
							
							

						} catch (InterruptedException e1) {
							e1.printStackTrace();

						}
					}

				}

			}.start();
			Thread.sleep(9500);
			this.setVisible(false);
			new TelaLogin();
		}

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			new Splash();

		}

	}

