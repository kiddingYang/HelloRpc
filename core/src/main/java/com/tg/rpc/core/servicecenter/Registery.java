package com.tg.rpc.core.servicecenter;

/**
 * Description:
 *
 * @author twogoods
 * @version 0.1
 * @since 2017-03-01
 */
public enum Registery {
    DEFAULT("default"),
    CONSUL("consul"),
    ZOOKEEPER("zookeeper");

    private String name;

    private Registery(String name) {
        this.name = name;
    }

    public String value() {
        return this.name;
    }

    public boolean equals(String name) {
        return this.name.equals(name);
    }
}
