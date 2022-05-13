package com.narozhnyiyevgen.mavraguide.ui.objects;

public enum EnumNode {
    NODE_MAIN("MAVRA"), NODE_USERS("User"), NODE_PIZZERIA("MAVRApizza");


    private final String NODE_NAME;

    EnumNode(String nodeName) {
    this.NODE_NAME = nodeName;
    }

    public String getNODE_NAME() {
        return NODE_NAME;
    }
}
