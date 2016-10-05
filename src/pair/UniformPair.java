package pair;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UniformPair<T> implements ImmutablePair<T, T> {
    public static <T> UniformPair<T> of(T thing) {
        return new UniformPair<>(thing, thing);
    }

    public final T left;

    public final T right;

    public UniformPair(final T a, final T b) {
        left = a;
        right = b;
    }

    public final T left() {
        return left;
    }

    public final T right() {
        return right;
    }

    public final UniformPair<T> invert() {
        return new UniformPair<>(right, left);
    }

    public final String toString() {
        return String.format("%s :: %s", left.toString(), right.toString());
    }

    public <R> Pair<R, T> mapLeft(final Function<T, R> fun) {
        return new Pair<>(fun.apply(left), right);
    }

    public <R> Pair<T, R> mapRight(final Function<T, R> fun) {
        return new Pair<>(left, fun.apply(right));
    }

    public UniformPair<T> mapLeft(UnaryOperator<T> fun) {
        return new UniformPair<>(fun.apply(left), right);
    }

    public UniformPair<T> mapRight(UnaryOperator<T> fun) {
        return new UniformPair<>(left, fun.apply(right));
    }

    public <R> Pair<R, T> replaceLeft(final R neoLiberal) {
        return new Pair<>(neoLiberal, right);
    }

    public <R> Pair<T, R> replaceRight(final R altRight) {
        return new Pair<>(left, altRight);
    }

    /*
     * public UniformPair<T> replaceLeft(final T neoLiberal) { return new
     * UniformPair<>(neoLiberal, right); }
     * 
     * public UniformPair<T> replaceRight(final T altRight) { return new
     * UniformPair<>(left, altRight); }
     */

    public static final class F {
        public static final <T> Function<T, UniformPair<T>> partialRight(
                final T right) {
            return left -> new UniformPair<>(left, right);
        }

        public static final <T> Function<T, UniformPair<T>> partialLeft(
                final T left) {
            return right -> new UniformPair<>(left, right);
        }
    }
}
