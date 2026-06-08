package org.deeper.archery.domain;

public class Cracker extends Target {

    @Override
    public boolean isHitBy(Arrow arrow) {
        return false;
    }
}
