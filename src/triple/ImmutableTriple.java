package triple;

import java.util.function.Function;

public interface ImmutableTriple<A, B, C> {
    A left();

    B center();

    C right();

    String toString();

    <R> ImmutableTriple<R, B, C> mapLeft(Function<A, R> fun);

    <R> ImmutableTriple<A, R, C> mapCenter(Function<B, R> fun);

    <R> ImmutableTriple<A, B, R> mapRight(Function<C, R> fun);

    <R> ImmutableTriple<R, B, C> replaceLeft(R newLeft);

    <R> ImmutableTriple<A, R, C> replaceCenter(R newCenter);

    <R> ImmutableTriple<A, B, R> replaceRight(R newRight);

    boolean equals(Object obj);
}
