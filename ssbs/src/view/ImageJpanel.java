package view;

import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

//Ìí¼Ó±³¾°Í¼Æ¬·½·¨
//¼Ì³ÐJpanelÌí¼ÓCustom¿Ø¼þ

public class ImageJpanel extends JPanel {
	private static final long serialVersionUID = -2403661436220830630L;
	Image image = null;
	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
	}
}


