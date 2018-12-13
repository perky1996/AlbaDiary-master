package com.example.key.a1123.albaInfo;

import io.realm.RealmObject;

public class albaInfo extends RealmObject {
    String name;
    int sigeup;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSigeup() {
        return sigeup;
    }

    public void setSigeup(int sigeup) {
        this.sigeup = sigeup;
    }

    @Override
    public String toString() {
        return "albaInfo " +
                "name='" + name + "    " +
                ", sigeup=" + sigeup +
                "\n";
    }
}
