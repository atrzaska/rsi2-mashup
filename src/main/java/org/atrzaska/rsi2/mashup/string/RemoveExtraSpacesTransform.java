package org.atrzaska.rsi2.mashup.string;

public class RemoveExtraSpacesTransform implements IStringTransform {
    public String applyTransform(String input) {
        String output = input;

        output = output.replace("          ", " ");
        output = output.replace("         ", " ");
        output = output.replace("        ", " ");
        output = output.replace("       ", " ");
        output = output.replace("      ", " ");
        output = output.replace("     ", " ");
        output = output.replace("    ", " ");
        output = output.replace("   ", " ");
        output = output.replace("  ", " ");

        output = output.replace(" \r\n", " ");
        output = output.replace(" \n", " ");

        // check for extra space at the beginning
        if(output.startsWith(" ")) {
            output = output.substring(1);
        }

        // check for extra space at the end
        if(output.endsWith(" ")) {
            output = output.substring(0, output.length()- 1);
        }

        return output;
    }

}
