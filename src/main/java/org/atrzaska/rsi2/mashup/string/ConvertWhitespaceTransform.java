package org.atrzaska.rsi2.mashup.string;

public class ConvertWhitespaceTransform implements IStringTransform {
    public String applyTransform(String input) {
        String output = input;

        output = output.replace("\n", " ");
        output = output.replace("\t", " ");

        return output;
    }
}
