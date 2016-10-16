package triple;

public class Triple<A, B, C> implements ImmutableTriple<A, B, C> {

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

}
