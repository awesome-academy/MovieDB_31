package com.framgia.moviedb_31.screen.movieDetail;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import com.framgia.moviedb_31.data.model.Actor;
import com.framgia.moviedb_31.data.model.Production;

public class ItemMovieDetailViewModel extends BaseObservable {

    public ObservableField<Production> mProduction;
    public ObservableField<Actor> mActor;

    public ItemMovieDetailViewModel() {
        mProduction = new ObservableField<>();
        mActor = new ObservableField<>();
    }

    void setActivityMovieDetailBinding(Production production) {
        mProduction.set(production);
    }

    public Production getProduction() {
        return mProduction.get();
    }

    void setActorBinding(Actor actor) {
        mActor.set(actor);
    }

    public Actor getActor() {
        return mActor.get();
    }
}
