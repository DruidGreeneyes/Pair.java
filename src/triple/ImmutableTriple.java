package triple;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public interface ImmutableTriple<A, B, C> {
    A left();

    B center();

    C right();

    String toString();

    <R> ImmutableTriple<R, B, C> mapLeft(Function<A, R> fun);

    ImmutableTriple<A, B, C> mapLeft(UnaryOperator<A> fun);

    <R> ImmutableTriple<A, R, C> mapCenter(Function<B, R> fun);

    ImmutableTriple<A, B, C> mapCenter(UnaryOperator<B> fun);

    <R> ImmutableTriple<A, B, R> mapRight(Function<C, R> fun);

    ImmutableTriple<A, B, C> mapRight(UnaryOperator<C> fun);

    <R> ImmutableTriple<R, B, C> replaceLeft(R newLeft);

    <R> ImmutableTriple<A, R, C> replaceCenter(R newCenter);

    <R> ImmutableTriple<A, B, R> replaceRight(R newRight);
}
