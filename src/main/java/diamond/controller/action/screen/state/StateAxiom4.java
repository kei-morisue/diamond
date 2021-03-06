/**
 * DEFOX - Diagram Editor for Origami Creators
 * Copyright (C) 2018-2021 Kei Morisue
 */
package diamond.controller.action.screen.state;

import java.awt.Graphics2D;

import diamond.controller.Context;
import diamond.model.cyborg.geom.d0.Ver;
import diamond.model.cyborg.geom.d1.D1;
import diamond.model.cyborg.geom.d1.Seg;
import diamond.model.math.field.F;
import diamond.view.ui.screen.ScreenModel;

/**
 * @author Kei Morisue
 *
 */
public final class StateAxiom4<T extends F<T>> extends AbstractStateAxiom<T> {
    private Ver<T> v;
    private D1<T> s;
    private Seg<T> axiom4;

    public StateAxiom4(
            Context<T> context,
            AbstractScreenState<T> prevState,
            Ver<T> v,
            D1<T> s,
            Seg<T> axiom) {
        super(context, prevState);
        this.v = v;
        this.s = s;
        this.axiom4 = axiom;
    }

    @Override
    public void drawModel(ScreenModel<T> screen, Graphics2D g2d) {
        v.drawPointed(screen, g2d);
        s.drawPointed(screen, g2d);
        axiom4.drawPointed(screen, g2d);
    }

    @Override
    protected void cut() {
        // TODO 自動生成されたメソッド・スタブ

    }

}
