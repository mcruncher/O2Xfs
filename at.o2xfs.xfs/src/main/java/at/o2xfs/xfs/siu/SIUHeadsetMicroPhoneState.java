package at.o2xfs.xfs.siu;

import at.o2xfs.xfs.XfsConstant;

/**
 * @author sundar
 * @since 8.1.0
 */
public enum SIUHeadsetMicroPhoneState implements XfsConstant
{
    /**
     * The status is not available.
     */
    NOT_AVAILABLE(0x0000L),

    /**
     * There is a headset microphone connected.
     */
    PRESENT(0x0001L),

    /**
     * There is no headset microphone connected.
     */
    NOT_PRESENT(0x0002L);

    private final long value;

    private SIUHeadsetMicroPhoneState(final long value) {
        this.value = value;
    }
    @Override
    public long getValue()
    {
        return value;
    }
}
