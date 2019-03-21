/**
 * DIAMOND - Origami Diagram Editor
 * Copyright (C) 2018-2019 Kei Morisue
 */
package diamond.controller.paint.state.axiom3;

import java.util.Stack;

import diamond.controller.paint.PaintContext;
import diamond.controller.paint.state.OriLinePickkingState;
import diamond.model.geom.element.Line;
import diamond.model.geom.element.LineType;
import diamond.model.geom.element.cp.OriLine;
import diamond.model.geom.element.cp.OriPoint;
import diamond.model.geom.util.CrossPointUtil;
import diamond.model.geom.util.GeomUtil;

/**
 * @author long_
 *
 */
public class OriLine0PickkingState extends OriLinePickkingState {

    @Override
    protected void initialize() {
        setPrevClass(OriPoint0PickkingState.class);
        setNextClass(OriPoint0PickkingState.class);
    }

    @Override
    protected void onResult(PaintContext context) {
        Stack<OriLine> pickedLines = context.getPickedLines();
        Stack<OriPoint> pickedPoints = context.getPickedPoints();
        if (pickedLines.size() != 1 || pickedPoints.size() != 3) {
            throw new RuntimeException();
        }
        OriPoint v0 = pickedPoints.get(0);
        OriPoint v1 = pickedPoints.get(1);
        OriPoint v2 = pickedPoints.get(2);
        OriLine l = pickedLines.get(0);
        OriLine line = createAngleBisectorLine(v0, v1,
                v2, l, context.inputLineType);
        context.palette.getCP().addLine(line);
        pickedPoints.clear();
        pickedLines.clear();
    }

    public OriLine createAngleBisectorLine(
            OriPoint v0, OriPoint v1, OriPoint v2,
            OriLine l,
            LineType type) {

        OriPoint dir = GeomUtil.getBisectorVec(v0, v1, v2);
        OriPoint cp = CrossPointUtil.getCrossPoint(
                new Line(l.p0, new OriPoint(l.p1.x - l.p0.x, l.p1.y - l.p0.y)),
                new Line(v1, dir));

        OriLine bisector = new OriLine(v1, cp, type);
        return bisector;

    }
}
