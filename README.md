# Pair.java
[![Build Status](https://travis-ci.org/DruidGreeneyes/Pair.java.svg?branch=master)](https://travis-ci.org/DruidGreeneyes/Pair.java) [![Release](https://jitpack.io/v/DruidGreeneyes/Pair.java.svg)](https://jitpack.io/#DruidGreeneyes/Pair.java)

Because Map.Entry is !@#$ stupid.

-----

Get it from jitpack.io: [https://jitpack.io/#druidgreeneyes/pair.java](https://jitpack.io/#druidgreeneyes/pair.java)



Immutable Pairs for java, with some functional goodies along with. For example: most instance methods that take arguments are also available in Function form under Pair.F.methodName.

```java

Pair<Integer, Boolean> p = Pair.make(1, true);

UnaryOperator<Boolean> noes = b -> !b;

Pair<Integer, Boolean> pNot = p.mapRight(noes);

Pair<Integer, Boolean> pNotAgain = Pair.F.mapRight(noes).apply(p);

```
(This makes it easier to use Pair methods inside map statements.)

Pairs can also be fed to two-argument methods/functions with Pair.into():

```java

public class Things {
    public static void doThings(int a, boolean b) {
        System.out.println((a == 1 && b)
                              ? "Works!"
                              : "Doesn't Work!");
    }
    
    p.into(Things::doThings);

    //"Works!"
    
    Pair.F.into(Things::doThings).apply(p);
    
    //"Works!"
}

```
