/**
 * DEFOX - Diagram Editor for Origami Creators
 * Copyright (C) 2018-2021 Kei Morisue
 */
package diamond.model.cyborg.axiom;

import diamond.model.cyborg.geom.d0.Dir;
import diamond.model.cyborg.geom.d0.Ver;
import diamond.model.cyborg.geom.d1.D1;
import diamond.model.cyborg.geom.d1.Seg;
import diamond.model.math.field.F;

/**
 * @author Kei Morisue
 *
 */
public class Axioms {
    public static <T extends F<T>> Seg<T> axiom1(Ver<T> v0, Ver<T> v1) {
        if (v0 == v1) {
            return null;
        }
        return new Seg<T>(v0, v1);
    }

    public static <T extends F<T>> Seg<T> axiom2(Ver<T> v0, Ver<T> v1) {
        if (v0 == v1) {
            return null;
        }
        Dir<T> d = v1.dir(v0).div(2);
        Ver<T> w0 = d.ver(v0);
        return new Seg<T>(
                ((Dir<T>) d.n().neg()).ver(w0),
                d.n().ver(w0));
    }

    //TODO refactor!!!
    public static <T extends F<T>> Seg<T> axiom3(D1<T> s0, D1<T> s1) {
        if (s0 == s1) {
            return null;
        }
        Ver<T> w = null;
        Ver<T> node = s0.node(s1);
        if (node != null) {
            w = node;
            Dir<T> u0 = s0.dir(w).u();
            Dir<T> u1 = s1.dir(w).u();
            return new Seg<T>(w, ((Dir<T>) u0.add(u1)).mul(100).ver(w));
        }

        Dir<T> d0 = s0.dir();
        Dir<T> n = d0.n();
        Dir<T> d1 = s1.dir();

        if (n.prod(d1).isZero()) {
            Ver<T> v0 = s0.getP();
            Ver<T> v1 = s1.getP();
            w = v1.dir(v0).div(2).ver(v0);
            return new Seg<T>(((Dir<T>) d1.neg()).ver(w), d1.ver(w));
        }
        F<T> beta = s1.dir(s0).prod(n).div(d1.prod(n));
        Dir<T> u0 = d0.u();
        Dir<T> u1 = d1.u();
        if (beta.isNeg()) {
            u1 = (Dir<T>) u1.neg();
        }
        w = ((Dir<T>) d1.scale(beta)).ver(s1.getP());
        return new Seg<T>(
                ((Dir<T>) u1.add(u0)).mul(100).ver(w),
                ((Dir<T>) u1.sub(u0)).mul(100).ver(w));
    }

    public static <T extends F<T>> Seg<T> axiom4(D1<T> s, Ver<T> v) {
        Dir<T> n = s.dir().n();
        Dir<T> d0 = s.dir(v);
        F<T> prod = d0.prod(n);
        if (prod.isZero()) {
            return null;
        }
        F<T> alpha = prod.div(n.norm());
        Ver<T> w = ((Dir<T>) n.scale(alpha)).ver(v);
        return new Seg<T>(((Dir<T>) n.neg()).ver(w), n.ver(w));
    }

}
