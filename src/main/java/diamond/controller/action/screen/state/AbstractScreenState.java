/**
 * DEFOX - Diagram Editor for Origami Creators
 * Copyright (C) 2018-2021 Kei Morisue
 */
package diamond.controller.action.screen.state;

import java.awt.Graphics2D;

import diamond.controller.Context;
import diamond.model.cyborg.geom.d0.Ver;
import diamond.model.cyborg.geom.d1.D1;
import diamond.model.math.field.F;
import diamond.view.ui.screen.ScreenModel;

/**
 * @author Kei Morisue
 *
 */
public abstract class AbstractScreenState<T extends F<T>>
        implements StateCtrl<T> {
    protected AbstractScreenState<T> prevState;
    protected Context<T> context;
    protected Ver<T> pointedV;
    protected D1<T> pointedS;

    protected AbstractScreenState(
            Context<T> context,
            AbstractScreenState<T> prevState) {
        this.prevState = prevState;
        this.context = context;
    }

    public void initialize() {
        pointedV = null;
        pointedV = null;
    }

    public AbstractScreenState<T> next(
            boolean isLeft,
            boolean isCtrl) {
        if (isCtrl) {
            return onCtrl(isLeft);
        } else {
            return on(isLeft);
        }
    };

    private AbstractScreenState<T> on(
            boolean isLeft) {
        if (isLeft) {
            return onLeft();
        } else {
            return onRight();
        }
    }

    protected AbstractScreenState<T> onRight() {
        return prevState;
    }

    @Override
    final public AbstractScreenState<T> right(Ver<T> v) {
        return null;
    }

    @Override
    final public AbstractScreenState<T> right(D1<T> s) {
        return null;
    }

    protected AbstractScreenState<T> onLeft() {
        if (pointedV != null) {
            return left(pointedV);
        }
        if (pointedS != null) {
            return left(pointedS);
        }
        return this;

    }

    protected AbstractScreenState<T> onCtrl(boolean isLeft) {
        if (pointedV != null) {
            return leftCtrl(pointedV);
        }
        if (pointedS != null) {
            return leftCtrl(pointedS);
        }
        return this;
    }

    public abstract void drawModel(
            ScreenModel<T> screen,
            Graphics2D g2d);

    public void setPointedV(Ver<T> pointedV) {
        this.pointedV = pointedV;
    }

    public void setPointedS(D1<T> pointedS) {
        this.pointedS = pointedS;
    }

    public Context<T> getContext() {
        return context;
    }

}
