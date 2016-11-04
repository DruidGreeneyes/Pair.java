package druid.utils.pair;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.UnaryOperator;

public class UniformPair<T> implements ImmutablePair<T, T> {
    public static <T> UniformPair<T> of(final T thing) {
        return new UniformPair<>(thing, thing);
    }

    public static <T> UniformPair<T> make(final T a, final T b) {
        return new UniformPair<>(a, b);
    }

    public final T left;

    public final T right;

    public UniformPair(final T a, final T b) {
        left = a;
        right = b;
    }

    @Override
    public final T left() {
        return left;
    }

    @Override
    public final T right() {
        return right;
    }

    @Override
    public final UniformPair<T> invert() {
        return new UniformPair<>(right, left);
    }

    @Override
    public final String toString() {
        return String.format("%s :: %s", left.toString(), right.toString());
    }

    @Override
    public <R, Fn extends Function<T, R>> Pair<R, T> mapLeft(final Fn fun) {
        return new Pair<>(fun.apply(left), right);
    }

    @Override
    public <R, Fn extends Function<T, R>> Pair<T, R> mapRight(final Fn fun) {
        return new Pair<>(left, fun.apply(right));
    }

    public <Fn extends UnaryOperator<T>> UniformPair<T> mapLeft(final Fn fun) {
        return new UniformPair<>(fun.apply(left), right);
    }

    public <Fn extends UnaryOperator<T>> UniformPair<T> mapRight(final Fn fun) {
        return new UniformPair<>(left, fun.apply(right));
    }

    public <Fn extends UnaryOperator<UniformPair<T>>> UniformPair<T> map(
            final Fn fun) {
        return fun.apply(this);
    }

    @Override
    public <R> Pair<R, T> replaceLeft(final R neoLiberal) {
        return new Pair<>(neoLiberal, right);
    }

    @Override
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

        public static final <T, R, Fn extends Function<T, R>> Function<UniformPair<T>, Pair<R, T>> mapLeft(
                final Fn fun) {
            return pair -> pair.mapLeft(fun);
        }

        public static final <T, R, Fn extends Function<T, R>> Function<UniformPair<T>, Pair<T, R>> mapRight(
                final Fn fun) {
            return pair -> pair.mapRight(fun);
        }

        public static final <T, R> Function<UniformPair<T>, Pair<R, T>> replaceLeft(
                final R neoLiberal) {
            return pair -> pair.replaceLeft(neoLiberal);
        }

        public static final <T, R> Function<UniformPair<T>, Pair<T, R>> replaceRight(
                final R altRight) {
            return pair -> pair.replaceRight(altRight);
        }

        public static final <T, R, Fn extends BiFunction<T, T, R>> Function<UniformPair<T>, R> intoFun(
                final Fn fun) {
            return pair -> pair.intoFun(fun);
        }

        public static final <T, Fn extends UnaryOperator<UniformPair<T>>> UnaryOperator<UniformPair<T>> map(
                final Fn fun) {
            return pair -> pair.map(fun);
        }

        public static final <T, Fn extends ToDoubleFunction<ImmutablePair<T, T>>> ToDoubleFunction<UniformPair<T>> intoDouble(
                final Fn fun) {
            return pair -> pair.intoDouble(fun);
        }

        public static final <T, Fn extends ToDoubleBiFunction<T, T>> ToDoubleFunction<UniformPair<T>> intoDouble(
                final Fn fun) {
            return pair -> pair.intoDouble(fun);
        }

        public static final <T, Fn extends BiConsumer<T, T>> Consumer<UniformPair<T>> intoCon(
                final Fn fun) {
            return pair -> pair.intoCon(fun);
        }

        public static final <T, Fn extends BiPredicate<T, T>> Predicate<UniformPair<T>> intoPred(
                final Fn pred) {
            return pair -> pair.intoPred(pred);
        }

        public static final <T, Fn extends Predicate<T>> Predicate<UniformPair<T>> predLeft(
                final Fn pred) {
            return pair -> pair.predLeft(pred);
        }

        public static final <T, Fn extends Predicate<T>> Predicate<UniformPair<T>> predRight(
                final Fn pred) {
            return pair -> pair.predRight(pred);
        }
    }

    @Override
    public UniformPair<T> copy() {
        return intoFun(UniformPair::make);
    }
}
