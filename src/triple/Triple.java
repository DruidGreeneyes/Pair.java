package triple;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Triple<A, B, C> implements ImmutableTriple<A, B, C> {

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
    public <R> ImmutableTriple<R, B, C> mapLeft(Function<A, R> fun) {
        return new Triple<>(fun.apply(left), center, right);
    }

    @Override
    public ImmutableTriple<A, B, C> mapLeft(UnaryOperator<A> fun) {
        return new Triple<>(fun.apply(left), center, right);
    }

    @Override
    public <R> ImmutableTriple<A, R, C> mapCenter(Function<B, R> fun) {
        return new Triple<>(left, fun.apply(center), right);
    }

    @Override
    public ImmutableTriple<A, B, C> mapCenter(UnaryOperator<B> fun) {
        return new Triple<>(left, fun.apply(center), right);
    }

    @Override
    public <R> ImmutableTriple<A, B, R> mapRight(Function<C, R> fun) {
        return new Triple<>(left, center, fun.apply(right));
    }

    @Override
    public ImmutableTriple<A, B, C> mapRight(UnaryOperator<C> fun) {
        return new Triple<>(left, center, fun.apply(right));
    }

}
