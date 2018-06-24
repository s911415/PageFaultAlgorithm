package org.magiclen.pagefaultalgorithm;

import java.util.Arrays;
import java.util.Collections;

public class FrameLogger {
    private final int numberOfFrames;
    private final int numberOfSequence;
    private final String[][] log;

    public FrameLogger(int numberOfFrames, int numberOfSequence) {
        this.numberOfFrames = numberOfFrames;
        this.numberOfSequence = numberOfSequence;

        log = new String[numberOfFrames][numberOfSequence];
    }

    public FrameLogger setValue(int frameIdx, int sequenceIdx, String value) {
        log[frameIdx][sequenceIdx] = value;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        final int FRAME_WIDTH = Arrays.stream(log).parallel().flatMap((Arrays::stream)).mapToInt(x -> x == null ? 0 : x.length()).max().orElse(3);
        final String HR = String.join("", Collections.nCopies((FRAME_WIDTH + 3) * numberOfSequence + 1, "-"));
        final String FRAME_FORMAT = "%" + FRAME_WIDTH + "s";
        sb
                .append(HR)
                .append("\n");

        for (int i = 0; i < numberOfFrames; i++) {
            sb.append("|");
            for (int j = 0; j < numberOfSequence; j++) {
                String v = log[i][j];
                if (v == null) v = "";
                sb.append(" ");
                sb.append(String.format(FRAME_FORMAT, v));
                sb.append(" ");
                sb.append("|");
            }
            sb.append("\n").append(HR).append("\n");
        }

        return sb.toString();
    }
}
