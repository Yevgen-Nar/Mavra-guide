package com.narozhnyiyevgen.mavraguide.ui.objects;

import androidx.annotation.NonNull;

public enum EnumNode {
    NODE_MAIN("MAVRA"), NODE_USERS("User"), NODE_PIZZERIA("MAVRApizza");


    private String nodeName;

    EnumNode(String nodeName) {
    this.nodeName = nodeName;
    }


    @NonNull
    @Override
    public String toString() {
        return nodeName;
    }
}
