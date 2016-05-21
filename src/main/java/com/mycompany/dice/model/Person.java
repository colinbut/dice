/*
 * |-------------------------------------------------
 * | Copyright © 2016 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.dice.model;

/**
 * A person
 *
 * @author colin
 */
class Person {

    private String name;

    Person(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }
}
