package pair;

import java.util.Map.Entry;
import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class IntDoublePair {
    public final int    left;
    public final double right;

    public IntDoublePair(int a, double b) {
        left = a;
        right = b;
    }

    public static final IntDoublePair make(int left, double right) {
        return new IntDoublePair(left, right);
    }

    public static final IntDoublePair fromEntry(Entry<Integer, Double> e) {
        return make(e.getKey(), e.getValue());
    }

    public final int left() {
        return left;
    }

    public final double right() {
        return right;
    }

    public final String toString() {
        return String.format("%d::%f", right, left);
    }

    public IntDoublePair mapLeft(IntUnaryOperator fun) {
        return make(fun.applyAsInt(left), right);
    }

    public <R> Pair<R, Double> mapLeft(IntFunction<R> fun) {
        return Pair.make(fun.apply(left), right);
    }

    public IntDoublePair mapRight(DoubleUnaryOperator fun) {
        return make(left, fun.applyAsDouble(right));
    }

    public <R> Pair<Integer, R> mapRight(DoubleFunction<R> fun) {
        return Pair.make(left, fun.apply(right));
    }

    public IntDoublePair replaceLeft(int neoLiberal) {
        return make(neoLiberal, right);
    }

    public <R> Pair<R, Double> replaceLeft(R neoLiberal) {
        return Pair.make(neoLiberal, right);
    }

    public IntDoublePair replaceRight(double altRight) {
        return make(left, altRight);
    }

    public <R> Pair<Integer, R> replaceRight(R altRight) {
        return Pair.make(left, altRight);
    }

    public IntDoublePair map(UnaryOperator<IntDoublePair> fun) {
        return fun.apply(this);
    }

    public <A, B> Pair<A, B> map(Function<IntDoublePair, Pair<A, B>> fun) {
        return fun.apply(this);
    }

    public static final class F {
        public static final UnaryOperator<IntDoublePair> mapLeft(
                IntUnaryOperator fun) {
            return pair -> pair.mapLeft(fun);
        }

        public static final <R> Function<IntDoublePair, Pair<R, Double>> mapLeft(
                IntFunction<R> fun) {
            return pair -> pair.mapLeft(fun);
        }

        public static final UnaryOperator<IntDoublePair> mapRight(
                DoubleUnaryOperator fun) {
            return pair -> pair.mapRight(fun);
        }

        public static final <R> Function<IntDoublePair, Pair<Integer, R>> mapRight(
                DoubleFunction<R> fun) {
            return pair -> pair.mapRight(fun);
        }

        public static final UnaryOperator<IntDoublePair> replaceLeft(
                int neoLiberal) {
            return pair -> pair.replaceLeft(neoLiberal);
        }

        public static final <R> Function<IntDoublePair, Pair<R, Double>> replaceLeft(
                R neoLiberal) {
            return pair -> pair.replaceLeft(neoLiberal);
        }

        public static final UnaryOperator<IntDoublePair> replaceRight(
                double altRight) {
            return pair -> pair.replaceRight(altRight);
        }

        public static final <R> Function<IntDoublePair, Pair<Integer, R>> replaceRight(
                R altRight) {
            return pair -> pair.replaceRight(altRight);
        }
    }
}
