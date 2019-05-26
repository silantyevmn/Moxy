package io.moxy.provide_methods_test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import android.os.Bundle;
import android.util.Log;

import io.moxy.MvpDelegate;
import io.moxy.provide_methods_test.resources.LocalProvidedView;
import io.moxy.provide_methods_test.resources.TwoLocalProvidedView;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class ProvideMethodsTest {

    @Test
    public void testLocalIsProvided() {
        LocalProvidedView view = new LocalProvidedView();

        view.delegate = new MvpDelegate<>(view);
        view.delegate.onCreate(new Bundle());

        Assert.assertNotNull(view.oneLocalPresenter);
        Assert.assertSame(view.oneLocalPresenter, view.oneLocalProvidedPresenter);
    }

    @Test
    public void testTwoLocalUseDifferentProvided() {
        TwoLocalProvidedView view = new TwoLocalProvidedView();

        view.delegate = new MvpDelegate<>(view);
        view.delegate.onCreate(new Bundle());

        Assert.assertNotSame(view.oneLocalPresenter, view.secondLocalPresenter);
    }
}