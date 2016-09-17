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
    
    public double into(final ToDoubleBiFunction<A, B> fun) {
        return fun.applyAsDouble(left, right);
    }
    
    public int into(final ToIntFunction<Pair<A, B>> fun) {
        return fun.applyAsInt(this);
    }
    
    public int into(final ToIntBiFunction<A, B> fun) {
        return fun.applyAsInt(left, right);
    }
    
    public long into(final ToLongFunction<Pair<A, B>> fun) {
        return fun.applyAsLong(this);
    }
    
    public long into(final ToLongBiFunction<A, B> fun) {
        return fun.applyAsLong(left, right);
    }
    
    public Pair<A, B> into(final UnaryOperator<Pair<A, B>> fun) {
        return fun.apply(this);
    }
    
    public boolean into(final Predicate<Pair<A, B>> fun) {
        return fun.test(this);
    }
    
    public boolean into(final BiPredicate<A, B> fun) {
        return fun.test(left, right);
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
