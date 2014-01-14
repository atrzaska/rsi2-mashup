package org.atrzaska.rsi2.mashup.string;

import java.util.ArrayList;
import java.util.List;

public class StringProcessor {
    private String originalString;
    private List<IStringTransform> stringTransforms = new ArrayList<>();

    public StringProcessor(String originalString) {
        this.originalString = originalString;
    }

    public void addTransform(IStringTransform transform) {
        stringTransforms.add(transform);
    }

    /**
     * Gets the processed string.
     * @return
     */
    public String getProcessedString() {
        String processedString = originalString;

        for (IStringTransform transform : stringTransforms) {
            processedString = transform.applyTransform(processedString);
        }

        return processedString;
    }
}
