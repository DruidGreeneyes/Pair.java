package triple;

public interface ImmutableTriple<A, B, C> {
    A left();

    B center();

    C right();

    String toString();
}
