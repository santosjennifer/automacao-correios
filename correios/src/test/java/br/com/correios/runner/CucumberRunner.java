package br.com.correios.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		glue =  "br.com.correios.steps",
		plugin = {"pretty"}
)
public class CucumberRunner {

}