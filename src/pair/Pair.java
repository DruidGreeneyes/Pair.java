package pair;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Pair<A, B> implements ImmutablePair<A, B> {
    public <T> UniformPair<T> of(T thing) {
        return new UniformPair<>(thing, thing);
    }

    public final A left;

    public final B right;

    public Pair(final A a, final B b) {
        left = a;
        right = b;
    }

    public final A left() {
        return left;
    }

    public final B right() {
        return right;
    }

    public final Pair<B, A> invert() {
        return new Pair<>(right, left);
    }

    public final String toString() {
        return String.format("%s :: %s", left.toString(), right.toString());
    }

    public <R> Pair<R, B> mapLeft(final Function<A, R> fun) {
        return new Pair<>(fun.apply(left), right);
    }

    public <R> Pair<A, R> mapRight(final Function<B, R> fun) {
        return new Pair<>(left, fun.apply(right));
    }

    public Pair<A, B> mapLeft(UnaryOperator<A> fun) {
        return new Pair<>(fun.apply(left), right);
    }

    public Pair<A, B> mapRight(UnaryOperator<B> fun) {
        return new Pair<>(left, fun.apply(right));
    }

    public <R> Pair<R, B> replaceLeft(final R neoLiberal) {
        return new Pair<>(neoLiberal, right);
    }

    public <R> Pair<A, R> replaceRight(final R altRight) {
        return new Pair<>(left, altRight);
    }

    public static final class F {
        public static final <A, B> Function<A, Pair<A, B>> partialRight(
                final B right) {
            return left -> new Pair<>(left, right);
        }

        public static final <A, B> Function<B, Pair<A, B>> partialLeft(
                final A left) {
            return right -> new Pair<>(left, right);
        }
    }
}
