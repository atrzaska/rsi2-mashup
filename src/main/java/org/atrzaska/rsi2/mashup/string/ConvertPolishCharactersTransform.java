package org.atrzaska.rsi2.mashup.string;

/**
 * Transformation replacing polish characters to latin characters.
 */
public class ConvertPolishCharactersTransform implements IStringTransform {
    public String applyTransform(String input) {
        String output = input;

        // small characters
        output = output.replace("ą", "a");
        output = output.replace("ć", "c");
        output = output.replace("ę", "e");
        output = output.replace("ł", "l");
        output = output.replace("ń", "n");
        output = output.replace("ó", "o");
        output = output.replace("ś", "s");
        output = output.replace("ż", "z");
        output = output.replace("ź", "z");

        // large characters
        output = output.replace("Ą", "A");
        output = output.replace("Ć", "C");
        output = output.replace("Ę", "E");
        output = output.replace("Ł", "L");
        output = output.replace("Ń", "N");
        output = output.replace("Ó", "O");
        output = output.replace("Ś", "S");
        output = output.replace("Ż", "Z");
        output = output.replace("Ż", "Z");

        return output;
    }
}
