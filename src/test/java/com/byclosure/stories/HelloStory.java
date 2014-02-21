package com.byclosure.stories;

import com.byclosure.BankAccountSteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

/**
 *
 */
public class HelloStory extends JUnitStory {

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromRelativeFile(
                        CodeLocations.codeLocationFromPath("src/test/java")))
                .useStoryReporterBuilder(new StoryReporterBuilder().
                        withCodeLocation(CodeLocations.codeLocationFromPath("target/test-classes")).
                        withRelativeDirectory("/jbehave-reports").
                        withDefaultFormats().
                        withFormats(Format.HTML, Format.XML, Format.CONSOLE, Format.STATS).
                        withFailureTrace(true));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new BankAccountSteps());
    }
}
