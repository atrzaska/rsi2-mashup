package org.atrzaska.rsi2.mashup.string;

public class RemoveNumbersTransform implements IStringTransform {
    public String applyTransform(String input) {
        String output = input;

        output = output.replace("1", "");
        output = output.replace("2", "");
        output = output.replace("3", "");
        output = output.replace("4", "");
        output = output.replace("5", "");
        output = output.replace("6", "");
        output = output.replace("7", "");
        output = output.replace("8", "");
        output = output.replace("9", "");
        output = output.replace("0", "");

        return output;
    }

}
