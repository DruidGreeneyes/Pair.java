package triple;

import java.util.function.Function;

public class Triple<A, B, C> implements ImmutableTriple<A, B, C> {

    public static <A, B, C> Triple<A, B, C> make(final A left, final B center,
            final C right) {
        return new Triple<>(left, center, right);
    }

    public final A left;
    public final B center;
    public final C right;

    public Triple(A a, B b, C c) {
        left = a;
        center = b;
        right = c;
    }

    @Override
    public A left() {
        return left;
    }

    @Override
    public B center() {
        return center;
    }

    @Override
    public C right() {
        return right;
    }

    @Override
    public String toString() {
        return String.format("%s::%s::%s",
                             left.toString(),
                             center.toString(),
                             right.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass()
               .equals(Triple.class))
            return equals((Triple<?, ?, ?>) obj);
        else
            return false;
    }

    public boolean equals(Triple<?, ?, ?> other) {
        return other.left.equals(this.left) && other.center.equals(this.center)
               && other.right.equals(this.right);
    }

    @Override
    public <R> Triple<R, B, C> mapLeft(final Function<A, R> fun) {
        return replaceLeft(fun.apply(left));
    }

    @Override
    public <R> Triple<A, R, C> mapCenter(final Function<B, R> fun) {
        return replaceCenter(fun.apply(center));
    }

    @Override
    public <R> Triple<A, B, R> mapRight(final Function<C, R> fun) {
        return replaceRight(fun.apply(right));
    }

    @Override
    public <R> Triple<R, B, C> replaceLeft(final R newLeft) {
        return make(newLeft, center, right);
    }

    @Override
    public <R> Triple<A, R, C> replaceCenter(final R newCenter) {
        return make(left, newCenter, right);
    }

    @Override
    public <R> Triple<A, B, R> replaceRight(final R newRight) {
        return make(left, center, newRight);
    }

    public static final class F {
        private F() {
        }

        public static <A, B, C, R> Function<Triple<A, B, C>, Triple<R, B, C>> mapLeft(
                final Function<A, R> fun) {
            return t -> t.mapLeft(fun);
        }

        public static <A, B, C, R> Function<Triple<A, B, C>, Triple<A, R, C>> mapCenter(
                final Function<B, R> fun) {
            return t -> t.mapCenter(fun);
        }

        public static <A, B, C, R> Function<Triple<A, B, C>, Triple<A, B, R>> mapRight(
                final Function<C, R> fun) {
            return t -> t.mapRight(fun);
        }

        public static <A, B, C, R> Function<Triple<A, B, C>, Triple<R, B, C>> replaceLeft(
                final R newLeft) {
            return t -> t.replaceLeft(newLeft);
        }

        public static <A, B, C, R> Function<Triple<A, B, C>, Triple<A, R, C>> replaceCenter(
                final R newCenter) {
            return t -> t.replaceCenter(newCenter);
        }

        public static <A, B, C, R> Function<Triple<A, B, C>, Triple<A, B, R>> replaceRight(
                final R newRight) {
            return t -> t.replaceRight(newRight);
        }
    }
}
