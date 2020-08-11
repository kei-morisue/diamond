/**
 * DIAMOND - Origami Diagram Editor
 * Copyright (C) 2018-2021 Kei Morisue
 */
package diamond.model.cyborg.geom;

import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.util.LinkedList;

import diamond.model.cyborg.geom.d0.Vertex;
import diamond.model.cyborg.geom.d1.AbstractSegment;
import diamond.model.cyborg.geom.d1.SegmentCrease;
import diamond.model.cyborg.geom.d1.SegmentEdge;
import diamond.model.cyborg.geom.d2.Face;

/**
 * @author Kei Morisue
 *
 */
public class ShapeBuilder {
    public static Ellipse2D.Double build(Vertex v, double size) {
        double sizeHalf = size * 0.5;
        return new Ellipse2D.Double(
                v.getX() - sizeHalf,
                v.getY() - sizeHalf,
                size,
                size);
    }

    public static GeneralPath build(Face face) {
        GeneralPath outline = new GeneralPath();
        LinkedList<Vertex> vertices = face.getVertices();
        Vertex v0 = vertices.get(0);
        outline.moveTo(v0.getX(), v0.getY());
        for (Vertex v : vertices) {
            outline.lineTo(v.getX(), v.getY());
        }
        outline.closePath();
        return outline;
    }

    public static Line2D.Double build(SegmentEdge mV) {
        Vertex v0 = mV.getV0();
        Vertex v1 = mV.getV1();
        return build(v0, v1);
    }

    public static Line2D.Double build(SegmentCrease crease, double clipped0,
            double clipped1) {
        Vertex v0 = crease.getV0();
        Vertex v1 = crease.getV1();
        Vertex pivot = v1.c(v0);
        v0 = v0.scale(clipped0, pivot);
        v1 = v1.scale(clipped1, pivot);
        return build(v0, v1);
    }

    public static Line2D.Double build(AbstractSegment segment) {
        Vertex v0 = segment.getV0();
        Vertex v1 = segment.getV1();
        return build(v0, v1);
    }

    private static Line2D.Double build(Vertex v0, Vertex v1) {
        Line2D.Double line = new Line2D.Double(v0.getX(), v0.getY(), v1.getX(),
                v1.getY());
        return line;
    }

}