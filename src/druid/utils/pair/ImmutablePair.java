package druid.utils.pair;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;

public interface ImmutablePair<A, B> {
    public static final class F {
        public static final <A, B, Fn extends BiConsumer<A, B>> Consumer<ImmutablePair<A, B>> intoCon(
                final Fn fun) {
            return pair -> pair.intoCon(fun);
        }

        public static final <A, B, Fn extends ToDoubleFunction<ImmutablePair<A, B>>> ToDoubleFunction<ImmutablePair<A, B>> intoDouble(
                final Fn fun) {
            return pair -> pair.intoDouble(fun);
        }

        public static final <A, B, Fn extends ToDoubleBiFunction<A, B>> ToDoubleFunction<ImmutablePair<A, B>> intoDouble(
                final Fn fun) {
            return pair -> pair.intoDouble(fun);
        }

        public static final <A, B, R, Fn extends BiFunction<A, B, R>> Function<ImmutablePair<A, B>, R> intoFun(
                final Fn fun) {
            return pair -> pair.intoFun(fun);
        }

        public static final <A, B, Fn extends UnaryOperator<ImmutablePair<A, B>>> UnaryOperator<ImmutablePair<A, B>> intoPair(
                final Fn fun) {
            return pair -> pair.intoFun(fun);
        }

        public static final <A, B, Fn extends BiPredicate<A, B>> Predicate<ImmutablePair<A, B>> intoPred(
                final Fn pred) {
            return pair -> pair.intoPred(pred);
        }

        public static final <A, B, R, Fn extends Function<A, R>> Function<ImmutablePair<A, B>, ImmutablePair<R, B>> mapLeft(
                final Fn fun) {
            return pair -> pair.mapLeft(fun);
        }

        public static final <A, B, R, Fn extends Function<B, R>> Function<ImmutablePair<A, B>, ImmutablePair<A, R>> mapRight(
                final Fn fun) {
            return pair -> pair.mapRight(fun);
        }

        public static final <A, B, Fn extends Predicate<A>> Predicate<ImmutablePair<A, B>> predLeft(
                final Fn pred) {
            return pair -> pair.predLeft(pred);
        }

        public static final <A, B, Fn extends Predicate<B>> Predicate<ImmutablePair<A, B>> predRight(
                final Fn pred) {
            return pair -> pair.predRight(pred);
        }

        public static final <A, B, R> Function<ImmutablePair<A, B>, ImmutablePair<R, B>> replaceLeft(
                final R neoLiberal) {
            return pair -> pair.replaceLeft(neoLiberal);
        }

        public static final <A, B, R> Function<ImmutablePair<A, B>, ImmutablePair<A, R>> replaceRight(
                final R altRight) {
            return pair -> pair.replaceRight(altRight);
        }
    }

    ImmutablePair<A, B> copy();

    default <Fn extends BiConsumer<A, B>> void intoCon(final Fn fun) {
        fun.accept(left(), right());
    }

    default <Fn extends Consumer<ImmutablePair<A, B>>> void intoCon(
            final Fn fun) {
        fun.accept(this);
    }

    default <Fn extends ToDoubleFunction<ImmutablePair<A, B>>> double intoDouble(
            final Fn fun) {
        return fun.applyAsDouble(this);
    }

    default <Fn extends ToDoubleBiFunction<A, B>> double intoDouble(
            final Fn fun) {
        return fun.applyAsDouble(left(), right());
    }

    default <R, Fn extends BiFunction<A, B, R>> R intoFun(final Fn fun) {
        return fun.apply(left(), right());
    }

    default <R, Fn extends Function<ImmutablePair<A, B>, R>> R intoFun(
            final Fn fun) {
        return fun.apply(this);
    }

    default <Fn extends ToIntFunction<ImmutablePair<A, B>>> int intoInt(
            final Fn fun) {
        return fun.applyAsInt(this);
    }

    default <Fn extends ToIntBiFunction<A, B>> int intoInt(final Fn fun) {
        return fun.applyAsInt(left(), right());
    }

    default <Fn extends ToLongFunction<ImmutablePair<A, B>>> long intoLong(
            final Fn fun) {
        return fun.applyAsLong(this);
    }

    default <Fn extends ToLongBiFunction<A, B>> long intoLong(final Fn fun) {
        return fun.applyAsLong(left(), right());
    }

    default <Fn extends Predicate<ImmutablePair<A, B>>> boolean intoPred(
            final Fn fun) {
        return fun.test(this);
    }

    default <Fn extends BiPredicate<A, B>> boolean intoPred(final Fn fun) {
        return fun.test(left(), right());
    }

    ImmutablePair<B, A> invert();

    A left();

    <R, Fn extends Function<A, R>> ImmutablePair<R, B> mapLeft(final Fn fun);

    <R, Fn extends Function<B, R>> ImmutablePair<A, R> mapRight(final Fn fun);

    default <Fn extends Predicate<A>> boolean predLeft(final Fn fun) {
        return fun.test(left());
    }

    default <Fn extends Predicate<B>> boolean predRight(final Fn fun) {
        return fun.test(right());
    }

    <R> ImmutablePair<R, B> replaceLeft(final R neoLiberal);

    <R> ImmutablePair<A, R> replaceRight(final R altRight);

    B right();

    @Override
    String toString();
}
