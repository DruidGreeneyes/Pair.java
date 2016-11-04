package druid.utils.pair;

import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.UnaryOperator;

public class Pair<A, B> implements ImmutablePair<A, B> {
    public static <A, B> Pair<A, B> make(final A a, final B b) {
        return new Pair<>(a, b);
    }

    public static <A, B> Pair<A, B> fromEntry(final Entry<A, B> entry) {
        return new Pair<>(entry);
    }

    public final A left;

    public final B right;

    public Pair(final A a, final B b) {
        left = a;
        right = b;
    }

    public Pair(final Entry<A, B> entry) {
        this(entry.getKey(), entry.getValue());
    }

    @Override
    public final A left() {
        return left;
    }

    @Override
    public final B right() {
        return right;
    }

    @Override
    public final Pair<B, A> invert() {
        return new Pair<>(right, left);
    }

    @Override
    public final String toString() {
        return String.format("%s :: %s", left.toString(), right.toString());
    }

    @Override
    public <R, Fn extends Function<A, R>> Pair<R, B> mapLeft(final Fn fun) {
        return new Pair<>(fun.apply(left), right);
    }

    @Override
    public <R, Fn extends Function<B, R>> Pair<A, R> mapRight(final Fn fun) {
        return new Pair<>(left, fun.apply(right));
    }

    @Override
    public <R> Pair<R, B> replaceLeft(final R neoLiberal) {
        return new Pair<>(neoLiberal, right);
    }

    @Override
    public <R> Pair<A, R> replaceRight(final R altRight) {
        return new Pair<>(left, altRight);
    }

    public <Fn extends UnaryOperator<Pair<A, B>>> Pair<A, B> map(final Fn fun) {
        return fun.apply(this);
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

        public static final <A, B, R, Fn extends Function<A, R>> Function<Pair<A, B>, Pair<R, B>> mapLeft(
                final Fn fun) {
            return pair -> pair.mapLeft(fun);
        }

        public static final <A, B, R, Fn extends Function<B, R>> Function<Pair<A, B>, Pair<A, R>> mapRight(
                final Fn fun) {
            return pair -> pair.mapRight(fun);
        }

        public static final <A, B, R> Function<Pair<A, B>, Pair<R, B>> replaceLeft(
                final R neoLiberal) {
            return pair -> pair.replaceLeft(neoLiberal);
        }

        public static final <A, B, R> Function<Pair<A, B>, Pair<A, R>> replaceRight(
                final R altRight) {
            return pair -> pair.replaceRight(altRight);
        }

        public static final <A, B, R, Fn extends BiFunction<A, B, R>> Function<Pair<A, B>, R> intoFun(
                final Fn fun) {
            return pair -> pair.intoFun(fun);
        }

        public static final <A, B, Fn extends ToDoubleFunction<ImmutablePair<A, B>>> ToDoubleFunction<Pair<A, B>> intoDouble(
                final Fn fun) {
            return pair -> pair.intoDouble(fun);
        }

        public static final <A, B, Fn extends ToDoubleBiFunction<A, B>> ToDoubleFunction<Pair<A, B>> intoDouble(
                final Fn fun) {
            return pair -> pair.intoDouble(fun);
        }

        public static final <A, B, Fn extends BiConsumer<A, B>> Consumer<Pair<A, B>> intoCon(
                final Fn fun) {
            return pair -> pair.intoCon(fun);
        }

        public static final <A, B, Fn extends BiPredicate<A, B>> Predicate<Pair<A, B>> intoPred(
                final Fn pred) {
            return pair -> pair.intoPred(pred);
        }

        public static final <A, B, Fn extends Predicate<A>> Predicate<Pair<A, B>> predLeft(
                final Fn pred) {
            return pair -> pair.predLeft(pred);
        }

        public static final <A, B, Fn extends Predicate<B>> Predicate<Pair<A, B>> predRight(
                final Fn pred) {
            return pair -> pair.predRight(pred);
        }
    }

    @Override
    public Pair<A, B> copy() {
        return intoFun(Pair::make);
    }
}
