package de.tum.in.ase.pse;

import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(EasyMockExtension.class)
class EasyMock {

    @TestSubject
    private A a = new A();

    @Mock(MockType.DEFAULT)
    private B b;

    @Test
    void test() {
        B b = mock(B.class);
        expect(b.getValue()).andReturn(23).atLeastOnce();
        expect(b.print()).andReturn(12).anyTimes();
        b.voidMethod();
        expectLastCall();
        b.voidString("Hello");
        b.voidString("World");
        expectLastCall();

        replay(b);
        a.interactB(b);
        verify(b);
    }
}
