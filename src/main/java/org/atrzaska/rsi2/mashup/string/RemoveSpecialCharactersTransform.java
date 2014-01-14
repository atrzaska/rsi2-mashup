package org.atrzaska.rsi2.mashup.string;

public class RemoveSpecialCharactersTransform implements IStringTransform {
    public String applyTransform(String input) {
        String output = input;

//        output = output.replaceAll("!\"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~´", "");

        output = output.replace("!", "");
        output = output.replace("\"", "");
        output = output.replace("#", "");
        output = output.replace("$", "");
        output = output.replace("%", "");
        output = output.replace("&", "");
        output = output.replace("$", "");
        output = output.replace("'", "");
        output = output.replace("(", "");
        output = output.replace(")", "");
        output = output.replace("*", "");
        output = output.replace("+", "");
        output = output.replace(",", "");
        output = output.replace("-", "");
        output = output.replace(".", "");
        output = output.replace("/", "");
        output = output.replace(":", "");
        output = output.replace(";", "");
        output = output.replace("<", "");
        output = output.replace("=", "");
        output = output.replace(">", "");
        output = output.replace("?", "");
        output = output.replace("?", "");
        output = output.replace("@", "");
        output = output.replace("[", "");
        output = output.replace("\\", "");
        output = output.replace("]", "");
        output = output.replace("^", "");
        output = output.replace("_", "");
        output = output.replace("`", "");
        output = output.replace("{", "");
        output = output.replace("|", "");
        output = output.replace("}", "");
        output = output.replace("~", "");
        output = output.replace("´", "");
        return output;
    }
}
