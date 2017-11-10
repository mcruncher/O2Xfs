package at.o2xfs.xfs.win32;

import static org.junit.Assert.assertTrue;

import java.util.EnumSet;

import org.junit.Test;

import at.o2xfs.win32.UINT;
import at.o2xfs.xfs.XfsConstant;

public class XfsDWordBitmaskTest {

	private enum MockEnum implements XfsConstant {

		VALUE_1(1L),
		VALUE_2(2L),
		MAX_VALUE(UINT.MAX_VALUE);

		private long value;

		private MockEnum(long value) {
			this.value = value;
		}

		@Override
		public long getValue() {
			return value;
		}
	}

	@Test
	public void test() {
		XfsDWordBitmask<MockEnum> bitmask = new XfsDWordBitmask<>(MockEnum.class, EnumSet.allOf(MockEnum.class));
		assertTrue(bitmask.get().containsAll(EnumSet.allOf(MockEnum.class)));
	}
}
