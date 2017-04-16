package com.justplaingoatappsgmail.phonesilencer;

import android.app.Application;

import com.justplaingoatappsgmail.phonesilencer.modules.ApplicationModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class PhoneSilencerApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        // configure realm for the application
        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder()
                .name("timers.realm")
                .build();

        // Make this realm the default
        Realm.setDefaultConfiguration(realmConfiguration);

        // DaggerApplicationComponent is generated by Dagger 2
        // Part of component processor in which was created when we did
        // "make project" on our application.
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }

}