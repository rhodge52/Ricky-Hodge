// Package 1
// package com.example.package1;
import package1.*;

// Abstract class with constructor overloading and method overloading
abstract class AbstractClass1 {
    private int privateMember;
    protected static int staticMember;

    public AbstractClass1() {}

    public AbstractClass1(int privateMember) {
        this.privateMember = privateMember;
    }

    public abstract void abstractMethod();

    public void overloadedMethod() {
        // Method implementation
    }

    protected void protectedMethod() {
        // Protected method implementation
    }
}

// Class implementing interface
public class Class1 extends AbstractClass1 implements Interface1 {
    private final int finalMember;

    public Class1() {
        super();
        this.finalMember = 0;
    }

    public Class1(int privateMember, int finalMember) {
        super(privateMember);
        this.finalMember = finalMember;
    }

    public Class1(int privateMember) {
        super(privateMember);
        this.finalMember = 0;
    }

    public void interfaceMethod() {
        // Interface method implementation
    }

    @Override
    public void abstractMethod() {
        // Override abstract method
    }

    @Override
    public void overriddenMethod() {
        // Override interface method
    }

    public void overloadedMethod(int param) {
        // Method overloading
    }
}

// Interface
interface Interface1 {
    void overriddenMethod();
}

// Package 2
// package com.example.package2;

// Another abstract class
abstract class AbstractClass2 {
    protected abstract void abstractMethod();
}

// Class extending abstract class and implementing interface
public class Class2 extends AbstractClass2 implements Interface2 {
    private static int staticMember;

    public Class2() {}

    public Class2(int param) {}

    @Override
    protected void abstractMethod() {
        // Override abstract method
    }

    @Override
    public void overriddenMethod() {
        // Override interface method
    }

    static {
        // Static block
    }
}

// Interface
interface Interface2 {
    void overriddenMethod();
}

// Package 3
// package com.example.package3;

// Class with overloaded constructors and methods
public class Class3 {
    public Class3() {}

    public Class3(int param) {}

    private void privateMethod() {}

    public void overloadedMethod(int param) {}

    public void overloadedMethod(String param) {}

    protected void protectedMethod() {}
}

// Package 4
// package com.example.package4;

// Class with overloaded constructors and methods
public class Class4 extends Class3 {
    public Class4() {
        super();
    }

    public Class4(int param) {
        super(param);
    }

    @Override
    public void overloadedMethod(int param) {
        // Override method
    }
}

