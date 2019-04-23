/**
 * DIAMOND - Origami Diagram Editor
 * Copyright (C) 2018-2019 Kei Morisue
 */
package diamond.controller.paint.state;

import java.awt.geom.Point2D.Double;

import diamond.controller.paint.PaintContext;
import diamond.model.geom.element.cp.OriPoint;
import diamond.model.geom.util.NearestPointFinder;

/**
 * @author long_
 *
 */
public abstract class OriVertexPickkingState extends AbstractPaintState {

    @Override
    protected void undoAction(PaintContext context) {
        if (context.getPickedPoints().size() > 0) {
            context.popLatestPickedPoint();
        }
    }

    @Override
    protected boolean onAction(
            PaintContext context,
            Double currentPoint) {
        OriPoint picked = NearestPointFinder.findAround(context);
        if (picked == null) {
            return false;
        }
        context.pushPoint(picked);
        context.pointedOriPoint = picked;
        return true;
    }

}