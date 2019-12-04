/**
 * DIAMOND - Origami Diagram Editor
 * Copyright (C) 2018-2020 Kei Morisue
 */
package diamond.model.cyborg.fold;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import diamond.model.cyborg.Cp;
import diamond.model.cyborg.EdgeType;
import diamond.model.cyborg.Face;
import diamond.model.cyborg.HalfEdge;
import diamond.model.cyborg.Vertex;
import diamond.model.math.Kawasaki;
import diamond.model.math.Maekawa;

/**
 * @author Kei Morisue
 *
 */
public class Folder {
    public static void fold(Cp cp) {
        for (Face face : cp.getFaces()) {
            face.initialize();
        }
        Face face = cp.getBaseFace();
        fold(face, new AffineTransform());
        face.setFaceFront(false);
        for (HalfEdge he : face.getHalfEdges()) {
            setAffine(face.getTransform(), he);
        }
        validate(cp);
    }

    private static void validate(Cp cp) {
        for (Vertex v : cp.getVertices()) {
            boolean maekawa = Maekawa.isValid(v);
            boolean kawasaki = Kawasaki.isValid(v);
            v.getProperty().isWrong = !maekawa || !kawasaki;
        }
    }

    public static void setAffine(AffineTransform accumulatedTransform,
            HalfEdge he) {
        Face face = he.getPair().getFace();
        if (face == null) {
            return;
        }
        if (face.getTransform() != null || he.getPair().getNext() == null) {
            return;
        }
        if (he.getType() != EdgeType.CUT) {
            face.setFaceFront(!he.getFace().isFaceFront());
            fold(face,
                    createFlipTransform(he.getPair(), accumulatedTransform));
        } else {
            face.setFaceFront(he.getFace().isFaceFront());
            fold(face, accumulatedTransform);
        }
        for (HalfEdge walkHe : face.getHalfEdges()) {
            setAffine(face.getTransform(), walkHe);
        }

    }

    public static AffineTransform createFlipTransform(HalfEdge he,
            AffineTransform accumulatedtransform) {
        Vertex v0 = he.getV0();
        Vertex v1 = he.getV1();

        Point2D p0 = new Point2D.Double();
        Point2D p1 = new Point2D.Double();
        accumulatedtransform.transform(v0, p0);
        accumulatedtransform.transform(v1, p1);

        AffineTransform transform = new AffineTransform();
        double dx = p1.getX() - p0.getX();
        double dy = p1.getY() - p0.getY();
        double theta = Math.atan2(dy, dx);
        double x = p0.getX();
        double y = p0.getY();

        transform.translate(x, y);
        transform.rotate(theta);
        transform.scale(1.0, -1.0);
        transform.rotate(-theta);
        transform.translate(-x, -y);
        transform.concatenate(accumulatedtransform);
        return transform;

    }

    public static void fold(Face face, AffineTransform transform) {
        face.setTransform(transform);
        for (HalfEdge he : face.getHalfEdges()) {
            fold(he, transform);
        }
        for (HalfEdge he : face.getUnsettledLines()) {
            fold(he, transform);
        }
    }

    public static void fold(HalfEdge he, AffineTransform transform) {
        Vertex v0 = he.getV0();
        Vertex v1 = he.getV1();
        fold(v0, transform);
        fold(v1, transform);
    }

    public static void fold(Vertex v, AffineTransform transform) {
        transform.transform(v, v.getFolded());
    }

}
