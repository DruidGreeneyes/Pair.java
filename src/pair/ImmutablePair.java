package pair;

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
    A left();

    B right();

    ImmutablePair<B, A> invert();

    String toString();

    default <R> R intoFun(final BiFunction<A, B, R> fun) {
        return fun.apply(left(), right());
    }

    default <R> R intoFun(final Function<ImmutablePair<A, B>, R> fun) {
        return fun.apply(this);
    }

    default void intoCon(final BiConsumer<A, B> fun) {
        fun.accept(left(), right());
    }

    default void intoCon(final Consumer<ImmutablePair<A, B>> fun) {
        fun.accept(this);
    }

    default double intoDouble(final ToDoubleFunction<ImmutablePair<A, B>> fun) {
        return fun.applyAsDouble(this);
    }

    default double intoDouble(final ToDoubleBiFunction<A, B> fun) {
        return fun.applyAsDouble(left(), right());
    }

    default int intoInt(final ToIntFunction<ImmutablePair<A, B>> fun) {
        return fun.applyAsInt(this);
    }

    default int intoInt(final ToIntBiFunction<A, B> fun) {
        return fun.applyAsInt(left(), right());
    }

    default long intoLong(final ToLongFunction<ImmutablePair<A, B>> fun) {
        return fun.applyAsLong(this);
    }

    default long intoLong(final ToLongBiFunction<A, B> fun) {
        return fun.applyAsLong(left(), right());
    }

    default boolean intoPred(final Predicate<ImmutablePair<A, B>> fun) {
        return fun.test(this);
    }

    default boolean intoPred(final BiPredicate<A, B> fun) {
        return fun.test(left(), right());
    }

    default boolean predLeft(final Predicate<A> fun) {
        return fun.test(left());
    }

    default boolean predRight(final Predicate<B> fun) {
        return fun.test(right());
    }

    <R> ImmutablePair<R, B> mapLeft(final Function<A, R> fun);

    <R> ImmutablePair<R, B> replaceLeft(final R neoLiberal);

    <R> ImmutablePair<A, R> mapRight(final Function<B, R> fun);

    <R> ImmutablePair<A, R> replaceRight(final R altRight);

    public static final class F {
        public static final <A, B, R> Function<ImmutablePair<A, B>, ImmutablePair<R, B>> mapLeft(
                final Function<A, R> fun) {
            return pair -> pair.mapLeft(fun);
        }

        public static final <A, B, R> Function<ImmutablePair<A, B>, ImmutablePair<A, R>> mapRight(
                final Function<B, R> fun) {
            return pair -> pair.mapRight(fun);
        }

        public static final <A, B, R> Function<ImmutablePair<A, B>, ImmutablePair<R, B>> replaceLeft(
                final R neoLiberal) {
            return pair -> pair.replaceLeft(neoLiberal);
        }

        public static final <A, B, R> Function<ImmutablePair<A, B>, ImmutablePair<A, R>> replaceRight(
                final R altRight) {
            return pair -> pair.replaceRight(altRight);
        }

        public static final <A, B, R> Function<ImmutablePair<A, B>, R> intoFun(
                final BiFunction<A, B, R> fun) {
            return pair -> pair.intoFun(fun);
        }

        public static final <A, B> UnaryOperator<ImmutablePair<A, B>> intoPair(
                final UnaryOperator<ImmutablePair<A, B>> fun) {
            return pair -> pair.intoFun(fun);
        }

        public static final <A, B> ToDoubleFunction<ImmutablePair<A, B>> intoDouble(
                final ToDoubleFunction<ImmutablePair<A, B>> fun) {
            return pair -> pair.intoDouble(fun);
        }

        public static final <A, B> ToDoubleFunction<ImmutablePair<A, B>> intoDouble(
                final ToDoubleBiFunction<A, B> fun) {
            return pair -> pair.intoDouble(fun);
        }

        public static final <A, B> Consumer<ImmutablePair<A, B>> intoCon(
                final BiConsumer<A, B> fun) {
            return pair -> pair.intoCon(fun);
        }

        public static final <A, B> Predicate<ImmutablePair<A, B>> intoPred(
                final BiPredicate<A, B> pred) {
            return pair -> pair.intoPred(pred);
        }

        public static final <A, B> Predicate<ImmutablePair<A, B>> predLeft(
                final Predicate<A> pred) {
            return pair -> pair.predLeft(pred);
        }

        public static final <A, B> Predicate<ImmutablePair<A, B>> predRight(
                final Predicate<B> pred) {
            return pair -> pair.predRight(pred);
        }
    }
}
