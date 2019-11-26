/**
 * DIAMOND - Origami Diagram Editor
 * Copyright (C) 2018-2020 Kei Morisue
 */
package diamond.view.ui.screen.draw;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import diamond.model.cyborg.Vertex;

/**
 * @author Kei Morisue
 *
 */
public class VertexDrawer {

    public static Shape buildVertex(Vertex v, double size) {
        double sizeHalf = size * 0.5;
        return new Ellipse2D.Double(
                v.x - sizeHalf,
                v.y - sizeHalf,
                size,
                size);
    }

}
