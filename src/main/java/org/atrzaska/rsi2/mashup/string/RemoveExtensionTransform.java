package org.atrzaska.rsi2.mashup.string;

public class RemoveExtensionTransform implements IStringTransform {
    public String applyTransform(String input) {
        String output = input;

        output = output.replaceFirst("[.][^.]+$", "");

        return output;
    }
}
