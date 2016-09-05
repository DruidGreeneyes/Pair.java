package main;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Pair<A, B> {
    public static <A, B> Pair<A, B> make(final A left, final B right) {
        return new Pair<>(left, right);
    }

    public final A left;

    public final B right;

    protected Pair(final A a, final B b) {
        left = a;
        right = b;
    }

    public <R> R apply(final BiFunction<A, B, R> fun) {
        return fun.apply(left, right);
    }

    public <R> Pair<R, B> mapLeft(final Function<A, R> fun) {
        return Pair.make(fun.apply(left), right);
    }

    public <R> Pair<A, R> mapRight(final Function<B, R> fun) {
        return Pair.make(left, fun.apply(right));
    }
}
