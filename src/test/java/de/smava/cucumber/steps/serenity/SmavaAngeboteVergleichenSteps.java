package de.smava.cucumber.steps.serenity;


import static org.assertj.core.api.Assertions.assertThat;

import de.smava.cucumber.pages.AngeboteVergleichenPage;
import de.smava.cucumber.pages.SmavaWebAnalyticsUtility;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmavaAngeboteVergleichenSteps extends ScenarioSteps{
    private AngeboteVergleichenPage angeboteVergleichenPage;
    private SmavaWebAnalyticsUtility smavaWebAnalyticsUtility;

    private static List<List<String>> AngeboteVergleichenPageGMTObjects = new ArrayList<List<String>>();
    static {
        {

            AngeboteVergleichenPageGMTObjects.add(Arrays.asList("pageId", "RdiAccount"));
            //AngeboteVergleichenPageGMTObjects.add(Arrays.asList("channel", "smava intern"));
            //kreditPageGMTObjects.add(0, ("pageId","CreditSelection") );

        }
    }

    @Step
    public void completeAngeboteVergleichenSteps(){
        angeboteVergleichenPage.fillAngeboteVergleichenPageInfoAndGotoNextPage();
    }

    @Step
    public void verifyGTMDataForSmavaAngeboteVergleichenPage(){
        assertThat( angeboteVergleichenPage.isAngeboteVergleichenPageLoaded()).isTrue();
        smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaAngeboteVergleichenPage");
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(AngeboteVergleichenPageGMTObjects);
    }

    @Step
    public void verifyGTMDataForSmavaAngeboteVergleichenPageWithData(List<List<String>> data){
        assertThat( angeboteVergleichenPage.isAngeboteVergleichenPageLoaded() ).isTrue();
        smavaWebAnalyticsUtility.fetchGTMObjectsForGivenPage("SmavaAngeboteVergleichenPage");
        smavaWebAnalyticsUtility.verifyGTM_KeyValuePair(data);
    }
}
