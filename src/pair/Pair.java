package pair;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;

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

    public final Pair<B, A> invert() {
        return Pair.make(right, left);
    }

    protected Pair(final A a, final B b) {
        left = a;
        right = b;
    }

    public <R> R into(final BiFunction<A, B, R> fun) {
        return fun.apply(left, right);
    }

    public void into(final BiConsumer<A, B> fun) {
        fun.accept(left, right);
    }

    public <R> R into(final Function<Pair<A, B>, R> fun) {
        return fun.apply(this);
    }

    public void into(final Consumer<Pair<A, B>> fun) {
        fun.accept(this);
    }

    public double intoDouble(final ToDoubleFunction<Pair<A, B>> fun) {
        return fun.applyAsDouble(this);
    }

    public double intoDouble(final ToDoubleBiFunction<A, B> fun) {
        return fun.applyAsDouble(left, right);
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

        public static final <A, B, R> Function<Pair<A, B>, R> into(
                final BiFunction<A, B, R> fun) {
            return pair -> pair.into(fun);
        }

        public static final <A, B> ToDoubleFunction<Pair<A, B>> intoDouble(
                final ToDoubleFunction<Pair<A, B>> fun) {
            return pair -> pair.intoDouble(fun);
        }

        public static final <A, B> Consumer<Pair<A, B>> into(
                final BiConsumer<A, B> fun) {
            return pair -> pair.into(fun);
        }
    }
}
