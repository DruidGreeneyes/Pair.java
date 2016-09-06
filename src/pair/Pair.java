package pair;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Pair<A, B> {
    public static <A, B> Pair<A, B> make(final A left, final B right) {
        return new Pair<>(left, right);
    }

    public final A left;

    public final B right;

    public final A left() {
        return left;
    }

    public final B right() {
        return right;
    }

    protected Pair(final A a, final B b) {
        left = a;
        right = b;
    }

    public <R> R into(final BiFunction<A, B, R> fun) {
        return fun.apply(left, right);
    }

    public <R> R into(final Function<Pair<A, B>, R> fun) {
        return fun.apply(this);
    }

    public <R> Pair<R, B> mapLeft(final Function<A, R> fun) {
        return Pair.make(fun.apply(left), right);
    }

    public <R> Pair<A, R> mapRight(final Function<B, R> fun) {
        return Pair.make(left, fun.apply(right));
    }

    public static final class F {
        public static final <A, B> Function<A, Pair<A, B>> partialRight(
                final B right) {
            return left -> Pair.make(left, right);
        }

        public static final <A, B> Function<B, Pair<A, B>> partialLeft(
                final A left) {
            return right -> Pair.make(left, right);
        }

        public static final <A, B, R> Function<Pair<A, B>, Pair<R, B>> mapLeft(
                final Function<A, R> fun) {
            return pair -> pair.mapLeft(fun);
        }

        public static final <A, B, R> Function<Pair<A, B>, Pair<A, R>> mapRight(
                final Function<B, R> fun) {
            return pair -> pair.mapRight(fun);
        }
    }
}
