/**
 * DEFOX - Diagram Editor for Origami Creators
 * Copyright (C) 2018-2021 Kei Morisue
 */
package diamond.model.math.field;

/**
 * @author Kei Morisue
 *
 */
public class Real extends F<Real> {
    private double a = 1;
    public static final Real ONE = new Real(1.0);
    public static final Real ZERO = new Real(0);

    @Deprecated
    public Real() {
    }

    public Real(double a) {
        this.a = a;
    }

    @Override
    public F<Real> add(F<Real> f) {
        return new Real(a + ((Real) (f)).a);
    }

    @Override
    public F<Real> neg() {
        return new Real(-a);
    }

    @Override
    public F<Real> mul(F<Real> f) {
        return new Real(a * ((Real) (f)).a);
    }

    @Override
    public F<Real> invImpl() {
        return new Real(1.0 / a);
    }

    @Override
    public String toString() {
        return Double.toString(a);
    }

    @Override
    public boolean isZero() {
        return a == 0;
    }

    @Deprecated
    public double getA() {
        return a;
    }

    @Deprecated
    public void setA(double a) {
        this.a = a;
    }

    @Override
    public double d() {
        return a;
    }

    @Override
    public F<Real> mul(int i) {
        return new Real(a * i);
    }

    @Override
    public F<Real> div(int i) {
        return new Real(a / i);
    }

    @Override
    public F<Real> sqrt() {
        return new Real(Math.sqrt(a));
    }

    @Override
    public boolean isNeg() {
        return a < 0.0;
    }
}
