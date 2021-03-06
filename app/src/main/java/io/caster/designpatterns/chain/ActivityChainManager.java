package io.caster.designpatterns.chain;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import io.caster.designpatterns.observer.ObserverActivity;

public class ActivityChainManager {
    private final ActivityChainElement head;

    public ActivityChainManager(@NonNull AppCompatActivity host) {
        head = new ActivityChainElement(0, new Intent(host, ObserverActivity.class), host);
        ActivityChainElement chainOfResponsibility = new ActivityChainElement(1, new Intent(host, ChainOfResponsibilityActivity.class), host);

        head.setNext(chainOfResponsibility);
    }

    public void onPatternReceived(int patternId) {
        head.onRequest(patternId);
    }

}
