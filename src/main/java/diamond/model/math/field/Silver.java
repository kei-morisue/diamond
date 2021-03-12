/**
 * DEFOX - Diagram Editor for Origami Creators
 * Copyright (C) 2018-2021 Kei Morisue
 */
package diamond.model.math.field;

/**
 * @author Kei Morisue
 *
 */
public class Silver extends F<Silver> {
    private Rational a = new Rational(1, 1);
    private Rational b = new Rational(0, 1);
    private static Rational TWO = new Rational(2, 1);

    @Deprecated
    public Silver() {
    }

    public Silver(Rational a, Rational b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public F<Silver> add(F<Silver> f) {
        Silver g = (Silver) f;
        return new Silver(
                (Rational) (a.add(g.a)),
                (Rational) (b.add(g.b)));
    }

    @Override
    public F<Silver> neg() {
        return new Silver(a.neg(), b.neg());
    }

    @Override
    public F<Silver> mul(F<Silver> f) {
        Silver g = (Silver) f;
        return new Silver(
                (Rational) (a.mul(g.a).add(TWO.mul(b.mul(g.b)))),
                (Rational) (a.mul(g.b).add(b.mul(g.a))));
    }

    @Override
    public F<Silver> invImpl() {
        F<Rational> d = TWO.mul(b).mul(b).sub(a.mul(a));
        return new Silver(
                (Rational) a.div(d),
                (Rational) b.neg().div(d));
    }

    @Override
    public String toString() {
        return a.toString() + " + √2 " + b.toString();
    }

    @Override
    public boolean isZero() {
        return (a.isZero() && b.isZero());
    }

    @Deprecated
    public Rational getA() {
        return a;
    }

    @Deprecated
    public void setA(Rational a) {
        this.a = a;
    }

    @Deprecated
    public Rational getB() {
        return b;
    }

    @Deprecated
    public void setB(Rational b) {
        this.b = b;
    }

    @Override
    public double d() {
        return a.d() + b.d() * Math.sqrt(2);
    }

    @Override
    public F<Silver> mul(int i) {
        return new Silver((Rational) a.mul(i), (Rational) b.mul(i));
    }

    @Override
    public F<Silver> div(int i) {
        return new Silver((Rational) a.div(i), (Rational) b.div(i));
    }

}
