/**
 * DIAMOND - Origami Diagram Editor
 * Copyright (C) 2018-2019 Kei Morisue
 */
package diamond.controller.paint.action.axiom1;

import java.awt.Graphics2D;

import diamond.controller.paint.PaintContext;
import diamond.controller.paint.action.AbstractPaintAction;
import diamond.controller.paint.state.pick.OriPoint0PickkingState;

/**
 * @author long_
 *
 */
public class Axiom1Action extends AbstractPaintAction {
    public Axiom1Action() {
        super();
        setActionState(new OriPoint0PickkingState());
    }

    @Override
    public void onPress(PaintContext context) {
    }

    @Override
    public void onDrag(PaintContext context) {
    }

    @Override
    public void onRelease(PaintContext context) {
    }

    @Override
    public void onDraw(Graphics2D g2d, PaintContext context) {
        super.onDraw(g2d, context);
        drawTemporaryLine(g2d, context);
        drawPointedVertex(g2d, context);

    }
}
