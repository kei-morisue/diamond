/**
 * DIAMOND - Origami Diagram Editor
 * Copyright (C) 2018-2021 Kei Morisue
 */
package diamond.controller.action.paint;

import java.awt.Graphics2D;

import diamond.controller.Context;
import diamond.controller.action.state.AddSegment;
import diamond.controller.action.state.PickCyborg;
import diamond.model.cyborg.diagram.Diagram;
import diamond.model.cyborg.geom.PickerCyborg;
import diamond.model.cyborg.geom.PointerCyborg;
import diamond.model.cyborg.geom.d0.Vertex;

/**
 * @author Kei Morisue
 *
 */
public class PaintAxiom1 extends AbstractPaintActionMouse {
    private Context context;

    public PaintAxiom1(Context context) {
        this.context = context;
        initialize(
                new PickCyborg<Vertex>(context, Vertex.class),
                new PickCyborg<Vertex>(context, Vertex.class),
                new AddSegment(context));
    }

    @Override
    public void onDraw(Graphics2D g2d) {
        Diagram diagram = context.getDiagram();
        PointerCyborg<Vertex> pointer = context.getPointer(Vertex.class);
        pointer.setG2d(g2d, diagram);
        pointer.draw(g2d, diagram);
        PickerCyborg<Vertex> picker = context.getPicker(Vertex.class);
        picker.setG2d(g2d, diagram);
        picker.draw(g2d, diagram);
    }

    @Override
    protected void onLeftCtrl() {
    }

    @Override
    protected void onRightCtrl() {
    }
}