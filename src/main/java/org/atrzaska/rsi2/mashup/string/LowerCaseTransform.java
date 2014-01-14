package org.atrzaska.rsi2.mashup.string;

public class LowerCaseTransform implements IStringTransform {
    public String applyTransform(String input) {
        String output = input;

        output = output.toLowerCase();

        return output;
    }

}
