package org.atrzaska.rsi2.mashup.string;

public class ConvertLineEndingsTransform implements IStringTransform {
    public String applyTransform(String input) {
        String output = input;

        output = output.replace("\r\n", "\n");

        return output;
    }
}
