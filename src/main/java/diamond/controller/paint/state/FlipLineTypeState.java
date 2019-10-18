/**
 * DIAMOND - Origami Diagram Editor
 * Copyright (C) 2018-2019 Kei Morisue
 */
package diamond.controller.paint.state;

import diamond.controller.paint.context.Context;
import diamond.controller.paint.context.PaintScreenContext;
import diamond.controller.paint.context.PickedElements;

/**
 * @author long_
 *
 */
public class FlipLineTypeState extends OriLinePickkingState {

    @Override
    protected void initialize() {
        setNextClass(FlipLineTypeState.class);
        setPrevClass(FlipLineTypeState.class);
    }

    @Override
    protected void onResult(Context context) {
        PaintScreenContext paintScreenContext = context.getPaintScreenContext();
        PickedElements pickedElements = paintScreenContext.getPickedElements();
        pickedElements.getOriLines().get(0).flipType();
        paintScreenContext.initialize();
    }

}
