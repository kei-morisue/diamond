/**
 * DEFOX - Diagram Editor for Origami Creators
 * Copyright (C) 2018-2021 Kei Morisue
 */
package diamond.controller.action.screen.state;

import java.awt.Graphics2D;

import diamond.controller.Context;
import diamond.model.cyborg.axiom.Axioms;
import diamond.model.cyborg.geom.d0.Ver;
import diamond.model.cyborg.geom.d1.D1;
import diamond.model.cyborg.geom.d1.Seg;
import diamond.model.math.field.F;
import diamond.view.ui.screen.ScreenModel;

/**
 * @author Kei Morisue
 *
 */
public final class StateIdle34<T extends F<T>> extends AbstractScreenState<T> {
    private D1<T> s;

    public StateIdle34(
            Context<T> context,
            StateIdle<T> stateIdol,
            D1<T> t) {
        super(context, stateIdol);
        s = t;
    }

    @Override
    public AbstractScreenState<T> leftCtrl(Ver<T> v) {
        Seg<T> axiom4 = Axioms.axiom4(s, v);
        if (axiom4 == null) {
            return this;
        }
        return new StateAxiom4<T>(context, this, v, s, axiom4);
    }

    @Override
    public AbstractScreenState<T> leftCtrl(D1<T> s0) {
        Seg<T> axiom3 = Axioms.axiom3(s, s0);
        if (axiom3 == null) {
            return this;
        }
        return new StateAxiom3<T>(context, this, s, s0, axiom3);
    }

    @Override
    public AbstractScreenState<T> left(Ver<T> v) {
        Seg<T> axiom4 = Axioms.axiom4(s, v);
        if (axiom4 == null) {
            return this;
        }
        return new StateAxiom4<T>(context, this, v, s, axiom4);
    }

    @Override
    public AbstractScreenState<T> left(D1<T> s0) {
        Seg<T> axiom3 = Axioms.axiom3(s, s0);
        if (axiom3 == null) {
            return this;
        }
        return new StateAxiom3<T>(context, this, s, s0, axiom3);
    }

    @Override
    public void drawModel(ScreenModel<T> screen, Graphics2D g2d) {
        s.drawPointed(screen, g2d);
        if (pointedS != null) {
            pointedS.drawPointed(screen, g2d);
            Seg<T> axiom3 = Axioms.axiom3(s, pointedS);
            if (axiom3 == null) {
                return;
            }
            axiom3.drawPointed(screen, g2d);
        }
        if (pointedV != null) {
            pointedV.drawPointed(screen, g2d);
            Seg<T> axiom4 = Axioms.axiom4(s, pointedV);
            if (axiom4 == null) {
                return;
            }
            axiom4.drawPointed(screen, g2d);
        }
    }

}
