package org.magiclen.pagefaultalgorithm;

/**
 * The structure of Frame.
 *
 * @author Magic Len
 */
public class Frame {

    String reference; // Use string to represent a reference.
    byte usebit; // Reference bit. If the frame is referenced, set this use bit.

    Frame() {
        // Initialize
        reference = null;
        usebit = 0;
    }
}
