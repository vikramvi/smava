package de.smava.cucumber.steps.serenity;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import de.smava.cucumber.pages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmavaPersonPage1Steps extends ScenarioSteps {
    private PersonStep1Page personStep1Page;
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;

    private static List<List<String>> personStep1PageGMTObjects = new ArrayList<List<String>>();
    static {
        {

            personStep1PageGMTObjects.add(Arrays.asList("pageId", "ContactInfo"));
            //kreditPageGMTObjects.add(Arrays.asList("channel", "smava intern1"));
        }
    }

    @Step
    public void completePersonPage1Steps(){
        personStep1Page.fillPersonStep1PageInfoAndGotoNextPage();
    }

    @Step
    public void verifyGTMDataForSmavaPersonPage1Steps(){
        assertThat( personStep1Page.isPersonStep1PageLoaded() ).isTrue();
        smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaPersonStep1Page");
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(personStep1PageGMTObjects);
    }

    @Step
    public void verifyGTMDataForSmavaPersonStep1PageWithData(List<List<String>> data){
        assertThat( personStep1Page.isPersonStep1PageLoaded() ).isTrue();
        smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaPersonStep1Page");
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(data);
    }
}
