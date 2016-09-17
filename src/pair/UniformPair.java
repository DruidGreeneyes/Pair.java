package pair;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;

public class UniformPair<T> {

    public final T left;

    public final T right;

    public final T left() {
        return left;
    }

    public final T right() {
        return right;
    }

    public final UniformPair<T> invert() {
        return UniformPair.make(right, left);
    }

    protected UniformPair(final T a, final T b) {
        left = a;
        right = b;
    }

    public <R> R into(final BiFunction<T, T, R> fun) {
        return fun.apply(left, right);
    }

    public void into(final BiConsumer<T, T> fun) {
        fun.accept(left, right);
    }

    public <R> R into(final Function<UniformPair<T>, R> fun) {
        return fun.apply(this);
    }

    public void into(final Consumer<UniformPair<T>> fun) {
        fun.accept(this);
    }

    public double intoDouble(final ToDoubleFunction<UniformPair<T>> fun) {
        return fun.applyAsDouble(this);
    }

    public double intoDouble(final ToDoubleBiFunction<T, T> fun) {
        return fun.applyAsDouble(left, right);
    }

    public <R> Pair<R, T> mapLeft(final Function<T, R> fun) {
        return Pair.make(fun.apply(left), right);
    }

    public <R> Pair<T, R> mapRight(final Function<T, R> fun) {
        return Pair.make(left, fun.apply(right));
    }

    public static final class F {
        public static final <T> Function<T, UniformPair<T>> partialRight(
                final T right) {
            return left -> UniformPair.make(left, right);
        }

        public static final <T> Function<T, UniformPair<T>> partialLeft(
                final T left) {
            return right -> UniformPair.make(left, right);
        }

        public static final <T, R> Function<UniformPair<T>, Pair<R, T>> mapLeft(
                final Function<T, R> fun) {
            return pair -> pair.mapLeft(fun);
        }

        public static final <T, R> Function<UniformPair<T>, Pair<T, R>> mapRight(
                final Function<T, R> fun) {
            return pair -> pair.mapRight(fun);
        }

        public static final <T, R> Function<UniformPair<T>, UniformPair<R>> map(
                final Function<T, R> fun) {
            return pair -> pair.map(fun);
        }

        public static final <T, R> Function<UniformPair<T>, R> into(
                final BiFunction<T, T, R> fun) {
            return pair -> pair.into(fun);
        }

        public static final <T> ToDoubleFunction<UniformPair<T>> intoDouble(
                final ToDoubleFunction<UniformPair<T>> fun) {
            return pair -> pair.intoDouble(fun);
        }

        public static final <T> Consumer<UniformPair<T>> into(
                final BiConsumer<T, T> fun) {
            return pair -> pair.into(fun);
        }
    }

    public <R> UniformPair<R> map(Function<T, R> fun) {
        return UniformPair.make(fun.apply(left), fun.apply(right));
    }

    public static <T> UniformPair<T> make(T a, T b) {
        return new UniformPair<T>(a, b);
    }
}
