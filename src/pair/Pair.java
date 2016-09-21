package pair;

import java.util.Map;
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

    public static <A> Pair<A, A> of(final A item) {
        return make(item, item);
    }

    public static <A, B> Pair<A, B> fromEntry(Map.Entry<A, B> entry) {
        return make(entry.getKey(), entry.getValue());
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

    public <R> R intoFun(final BiFunction<A, B, R> fun) {
        return fun.apply(left, right);
    }

    public void intoCon(final BiConsumer<A, B> fun) {
        fun.accept(left, right);
    }

    public <R> R intoFun(final Function<Pair<A, B>, R> fun) {
        return fun.apply(this);
    }

    public void intoCon(final Consumer<Pair<A, B>> fun) {
        fun.accept(this);
    }

    public double intoDouble(final ToDoubleFunction<Pair<A, B>> fun) {
        return fun.applyAsDouble(this);
    }
    
    public double intoDouble(final ToDoubleBiFunction<A, B> fun) {
        return fun.applyAsDouble(left, right);
    }
    
    public int intoInt(final ToIntFunction<Pair<A, B>> fun) {
        return fun.applyAsInt(this);
    }
    
    public int intoInt(final ToIntBiFunction<A, B> fun) {
        return fun.applyAsInt(left, right);
    }
    
    public long intoLong(final ToLongFunction<Pair<A, B>> fun) {
        return fun.applyAsLong(this);
    }
    
    public long intoLong(final ToLongBiFunction<A, B> fun) {
        return fun.applyAsLong(left, right);
    }
    
    public Pair<A, B> intoPair(final UnaryOperator<Pair<A, B>> fun) {
        return fun.apply(this);
    }
    
    public boolean intoPred(final Predicate<Pair<A, B>> fun) {
        return fun.test(this);
    }
    
    public boolean predLeft(final Predicate<A> pred) {
        return pred.test(left);
    }

    public boolean predRight(final Predicate<B> pred) {
        return pred.test(right);
    }

    public boolean intoPred(final BiPredicate<A, B> fun) {
        return fun.test(left, right);
    }

    public <R> Pair<R, B> mapLeft(final Function<A, R> fun) {
        return Pair.make(fun.apply(left), right);
    }

    public <R> Pair<A, R> mapRight(final Function<B, R> fun) {
        return Pair.make(left, fun.apply(right));
    }

    public <R> Pair<R, B> mapLeft(final R neoLiberal) {
        return Pair.make(neoLiberal, right);
    }

    public Pair<A, B> replaceLeft(final A neoLiberal) {
        return Pair.make(neoLiberal, right);
    }

    public <R> Pair<A, R> mapRight(final R altRight) {
        return Pair.make(left, altRight);
    }

    public Pair<A, B> replaceRight(final B altRight) {
        return Pair.make(left, altRight);
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

        public static final <A, B, R> Function<Pair<A, B>, Pair<R, B>> mapLeft(
                final R neoLiberal) {
            return pair -> pair.mapLeft(neoLiberal);
        }


        public static final <A, B, R> Function<Pair<A, B>, Pair<A, R>> mapRight(
                final R altRight) {
            return pair -> pair.mapRight(altRight);
        }

        public static final <A, B> UnaryOperator<Pair<A, B>> replaceLeft(
                A neoLiberal) {
            return pair -> pair.replaceLeft(neoLiberal);
        }

        public static final <A, B> UnaryOperator<Pair<A, B>> replaceRight(
                B altRight) {
            return pair -> pair.replaceRight(altRight);
        }

        public static final <A, B, R> Function<Pair<A, B>, R> intoFun(
                final BiFunction<A, B, R> fun) {
            return pair -> pair.intoFun(fun);
        }

        public static final <A, B> UnaryOperator<Pair<A, B>> intoPair(
                final UnaryOperator<Pair<A, B>> fun) {
            return pair -> pair.intoFun(fun);
        }

        public static final <A, B> ToDoubleFunction<Pair<A, B>> intoDouble(
                final ToDoubleFunction<Pair<A, B>> fun) {
            return pair -> pair.intoDouble(fun);
        }
        
        public static final <A, B> ToDoubleFunction<Pair<A, B>> intoDouble(
                final ToDoubleBiFunction<A, B> fun) {
            return pair -> pair.intoDouble(fun);
        }

        public static final <A, B> Consumer<Pair<A, B>> intoCon(
                final BiConsumer<A, B> fun) {
            return pair -> pair.intoCon(fun);
        }

        public static final <A, B> Predicate<Pair<A, B>> intoPred(
                final BiPredicate<A, B> pred) {
            return pair -> pair.intoPred(pred);
        }

        public static final <A, B> Predicate<Pair<A, B>> predLeft(
                final Predicate<A> pred) {
            return pair -> pair.predLeft(pred);
        }

        public static final <A, B> Predicate<Pair<A, B>> predRight(
                final Predicate<B> pred) {
            return pair -> pair.predRight(pred);
        }
    }
}
