/**
 * DIAMOND - Origami Diagram Editor
 * Copyright (C) 2018-2019 Kei Morisue
 */
package diamond.view.paint.screen;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import diamond.controller.paint.ScreenContext;
import diamond.controller.paint.listener.ScreenAction;

/**
 * @author long_
 *
 */
public abstract class AbstractScreen extends JPanel
        implements ComponentListener, Observer {
    public AbstractScreen(ScreenContext screenContext) {
        addComponentListener(this);
        ScreenAction screenAction = new ScreenAction(screenContext);
        addMouseListener(screenAction);
        addMouseMotionListener(screenAction);
        addMouseWheelListener(screenAction);
        screenContext.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    protected void drawBackGround(Graphics2D g2d, Color color) {
        g2d.setColor(color);
        int width = getWidth();
        int height = getHeight();
        g2d.fillRect(0, 0, width, height);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        repaint();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }
}
