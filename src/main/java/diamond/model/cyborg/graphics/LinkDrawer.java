/**
 * DEFOX - Diagram Editor for Origami Creators
 * Copyright (C) 2018-2021 Kei Morisue
 */
package diamond.model.cyborg.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import diamond.model.cyborg.geom.d0.Ver;
import diamond.model.math.field.F;
import diamond.view.ui.screen.ScreenCp;
import diamond.view.ui.screen.ScreenModel;

/**
 * @author Kei Morisue
 *
 */
public final class LinkDrawer {
    final public static int CAP = BasicStroke.CAP_BUTT;
    final public static int JOIN = BasicStroke.JOIN_ROUND;
    final public static Color POINTED = Color.GREEN;
    final public static Color BASE = Color.BLACK;
    final private static float WIDTH = 3.0f;
    final private static float WIDTH_CP = 0.0f;

    public static <T extends F<T>> void draw(
            ScreenModel<T> screen,
            Graphics2D g2d,
            Ver<T> p,
            Ver<T> q) {
        g2d.setColor(BASE);
        g2d.setStroke(strokeModel(screen.getScale()));
        g2d.draw(
                ShapeBuilder.build(p, q));
    }

    public static <T extends F<T>> void draw(
            ScreenCp<T> screen,
            Graphics2D g2d,
            Ver<T> p,
            Ver<T> q) {
        g2d.setColor(BASE);
        g2d.setStroke(strokeCp(screen.getScale()));
        g2d.draw(
                ShapeBuilder.build(p, q));
    }

    public static <T extends F<T>> void drawPointed(
            ScreenModel<T> screen,
            Graphics2D g2d,
            Ver<T> p,
            Ver<T> q) {
        g2d.setColor(POINTED);
        g2d.setStroke(strokePointed(screen.getScale()));
        g2d.draw(ShapeBuilder.build(p, q));
    }

    private static BasicStroke strokeCp(double scale) {
        return new BasicStroke(WIDTH_CP / (float) scale, CAP, JOIN);
    }

    private static BasicStroke strokeModel(double scale) {
        return new BasicStroke(WIDTH / (float) scale, CAP, JOIN);
    }

    private static BasicStroke strokePointed(double scale) {
        return new BasicStroke(WIDTH / (float) scale, CAP, JOIN);
    }

}
