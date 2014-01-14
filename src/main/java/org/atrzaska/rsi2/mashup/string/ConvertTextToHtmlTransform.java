package org.atrzaska.rsi2.mashup.string;

public class ConvertTextToHtmlTransform implements IStringTransform {
    public String applyTransform(String input) {
        String output = input;

        output = output.replace("\r\n", "<br />");
        output = output.replace("\n", "<br />");

        return output;
    }
}
