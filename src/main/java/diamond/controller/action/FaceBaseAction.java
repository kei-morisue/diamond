/**
 * DIAMOND - Origami Diagram Editor
 * Copyright (C) 2018-2020 Kei Morisue
 */
package diamond.controller.action;

import java.awt.Graphics2D;

import diamond.controller.Context;
import diamond.controller.action.state.facebase.State0;

/**
 * @author Kei Morisue
 *
 */
public class FaceBaseAction extends AbstractPaintAction {

    @Override
    public void onDraw(Graphics2D g2d, Context context) {
    }

    @Override
    protected void setInitialState() {
        setActionState(new State0());
    }

}
