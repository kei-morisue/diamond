/**
 * DEFOX - Diagram Editor for Origami Creators
 * Copyright (C) 2018-2021 Kei Morisue
 */
package diamond.model.cyborg.geom.d1;

import java.awt.Graphics2D;

import diamond.model.cyborg.Util;
import diamond.model.cyborg.geom.Metric;
import diamond.model.cyborg.geom.d0.Dir;
import diamond.model.cyborg.geom.d0.Ver;
import diamond.model.math.field.F;
import diamond.view.ui.screen.ScreenModel;

/**
 * @author Kei Morisue
 *
 */
public abstract class D1<T extends F<T>> implements Metric {
    protected Ver<T> p;
    protected Ver<T> q;
    private static final double EPS = 100;

    @Deprecated
    protected D1() {
    }

    protected D1(Ver<T> p, Ver<T> q) {
        this.p = p;
        this.q = q;
    }

    public Ver<T> c() {
        Dir<T> dir = q.dir(p);
        return dir.div(2).ver(p);
    }

    protected F<T> lengthSquared() {
        return q.dir(p).norm();
    }

    @Override
    public boolean isNear(double x, double y, double scale) {
        return distSquare(x, y) < EPS / scale / scale &&
                c().distSquare(x, y) < lengthSquared().div(4).d();
    }

    @Override
    public double distSquare(double x, double y) {
        return Util.footSquare(p, q, x, y);
    };

    public Dir<T> dir() {
        return q.dir(p);
    }

    public Dir<T> dir(D1<T> d) {
        return p.dir(d.p);
    }

    public Ver<T> node(D1<T> d0) {
        if (d0.p == p) {
            return p;
        }
        if (d0.p == q) {
            return q;
        }
        if (d0.q == p) {
            return p;
        }
        if (d0.q == q) {
            return q;
        }
        return null;
    }

    public Dir<T> dir(Ver<T> v) {
        if (v == p) {
            return q.dir(p);
        }
        if (v == q) {
            return p.dir(q);
        }
        return p.dir(v);
    }

    public Ver<T> ver0(D1<T> d) {
        F<T> np = p.dir(d.p).norm();
        F<T> nq = p.dir(d.q).norm();
        return (np.sub(nq).isNeg()) ? d.p : d.q;
    }

    public Ver<T> ver1(D1<T> d) {
        F<T> np = q.dir(d.p).norm();
        F<T> nq = q.dir(d.q).norm();
        return (np.sub(nq).isNeg()) ? d.p : d.q;
    }

    public abstract void drawPointed(ScreenModel<T> screen, Graphics2D g2d);

    public abstract void draw(ScreenModel<T> screen, Graphics2D g2d);

    @Deprecated
    public Ver<T> getP() {
        return p;
    }

    @Deprecated
    public void setP(Ver<T> p) {
        this.p = p;
    }

    @Deprecated
    public Ver<T> getQ() {
        return q;
    }

    @Deprecated
    public void setQ(Ver<T> q) {
        this.q = q;
    }
}
