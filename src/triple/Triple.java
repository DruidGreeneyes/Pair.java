package triple;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Triple<A, B, C> implements ImmutableTriple<A, B, C> {

    public static <A, B, C> Triple<A, B, C> make(A left, B center, C right) {
        return new Triple<>(left, center, right);
    }

    public final A left;
    public final B center;
    public final C right;

    public Triple(A a, B b, C c) {
        left = a;
        center = b;
        right = c;
    }

    @Override
    public A left() {
        return left;
    }

    @Override
    public B center() {
        return center;
    }

    @Override
    public C right() {
        return right;
    }

    @Override
    public <R> Triple<R, B, C> mapLeft(Function<A, R> fun) {
        return replaceLeft(fun.apply(left));
    }

    @Override
    public Triple<A, B, C> mapLeft(UnaryOperator<A> fun) {
        return replaceLeft(fun.apply(left));
    }

    @Override
    public <R> Triple<A, R, C> mapCenter(Function<B, R> fun) {
        return replaceCenter(fun.apply(center));
    }

    @Override
    public Triple<A, B, C> mapCenter(UnaryOperator<B> fun) {
        return replaceCenter(fun.apply(center));
    }

    @Override
    public <R> Triple<A, B, R> mapRight(Function<C, R> fun) {
        return replaceRight(fun.apply(right));
    }

    @Override
    public Triple<A, B, C> mapRight(UnaryOperator<C> fun) {
        return replaceRight(fun.apply(right));
    }

    @Override
    public <R> Triple<R, B, C> replaceLeft(R newLeft) {
        return make(newLeft, center, right);
    }

    @Override
    public <R> Triple<A, R, C> replaceCenter(R newCenter) {
        return make(left, newCenter, right);
    }

    @Override
    public <R> Triple<A, B, R> replaceRight(R newRight) {
        return make(left, center, newRight);
    }
}
