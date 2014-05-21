package fr.alainmuller.androidtestsample.app.ui.activity;

import android.test.ActivityInstrumentationTestCase2;

import fr.alainmuller.androidtestsample.app.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.clearText;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeTextIntoFocusedView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Espresso will not launch our activity for us, we must launch it via getActivity().
        getActivity();
    }

    public void testEmptyName() {
        clearName();
        clickAndCheckName("toi");
    }

    public void testSomeName() {
        String name = "Alain";
        fillName(name);
        clickAndCheckName(name);
    }

    public void testFullName() {
        String name = "Alain Muller";
        fillName(name);
        clickAndCheckName(name);
    }

    public void testMultipleNames() {
        String name1 = "Alain";
        String name2 = "Paul";

        fillName(name1);
        clickAndCheckName(name1);
        clearName();
        fillName(name2);
        clickAndCheckName(name2);

    }

    /**
     * Méthode permettant de renseigner un nom dans l'appli
     *
     * @param name le nom a taper
     */
    private void fillName(String name) {
        onView(withId(R.id.et_main_name)).perform(typeTextIntoFocusedView(name));
    }

    /**
     * Méthode permettant de réinitialiser le champ nom dans l'appli
     */
    private void clearName() {
        onView(withId(R.id.et_main_name)).perform(clearText());
    }

    /**
     * Méthode permettant de simuler le clic
     *
     * @param name le nom qui devrait être affiché
     */
    private void clickAndCheckName(String name) {
        // On déclenche le clic sur le bouton GO
        onView(withId(R.id.btn_main_go))
                .perform(click());
        // On récupère le textview pour en tester le contenu
        onView(withId(R.id.tv_message))
                .check(matches(withText("Bonjour " + name)));
    }
}